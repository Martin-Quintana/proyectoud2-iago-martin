package proyectoud1iagomartin.cocktails.tools;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Properties;

/**
 * The type Encryption.
 */
public class Encryption {

    /**
     * Read pass.
     *
     * @throws Exception the exception
     */
    public static void readPass() throws Exception {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/conf/config.properties");
        properties.load(inputStream);
        String password = properties.getProperty("password");

        if (password == null) {
            throw new IllegalArgumentException("No such parameter present in config file");
        }

        byte[] salt = new String("12345678").getBytes();    //son datos aleatorios que usamos como una entrada adicional que codifica datos
        int iterationCount = 40000; //número de iteraciones que debe tomar un algoritmo
        int keyLength = 128;    //longitud de la clave
        SecretKeySpec key = createSecretKey(password.toCharArray(), salt, iterationCount, keyLength);

        String originalPassword = password;
        System.out.println("Original password: " + originalPassword);
        String encryptedPassword = encrypt(originalPassword, key);
        System.out.println("Encrypted password: " + encryptedPassword);
        String decryptedPassword = decrypt(encryptedPassword, key);
        System.out.println("Decrypted password: " + decryptedPassword);
    }

    /**
     * Create secret key secret key spec.
     *
     * @param password       the password
     * @param salt           the salt
     * @param iterationCount the iteration count
     * @param keyLength      the key length
     * @return the secret key spec
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws InvalidKeySpecException  the invalid key spec exception
     */
//devuelve la clave SecretKeySpec
    public static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(keyTmp.getEncoded(), "AES");
    }

    /**
     * Encrypt string.
     *
     * @param dataToEncrypt the data to encrypt
     * @param key           the key
     * @return the string
     * @throws GeneralSecurityException     the general security exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public static String encrypt(String dataToEncrypt, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters parameters = pbeCipher.getParameters();
        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
        byte[] cryptoText = pbeCipher.doFinal(dataToEncrypt.getBytes(StandardCharsets.UTF_8));
        byte[] iv = ivParameterSpec.getIV();
        return base64Encode(iv) + ":" + base64Encode(cryptoText);
    }

    private static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Decrypt string.
     *
     * @param string the string
     * @param key    the key
     * @return the string
     * @throws GeneralSecurityException the general security exception
     * @throws IOException              the io exception
     */
    public static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
        String iv = string.split(":")[0];
        String property = string.split(":")[1];
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
        return new String(pbeCipher.doFinal(base64Decode(property)), StandardCharsets.UTF_8);
    }

    private static byte[] base64Decode(String property) throws IOException {
        return Base64.getDecoder().decode(property);
    }
}
