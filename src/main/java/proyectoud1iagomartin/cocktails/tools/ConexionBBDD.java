package proyectoud1iagomartin.cocktails.tools;

import java.sql.*;
import java.util.Scanner;

public class ConexionBBDD {
    static Scanner scan = new Scanner(System.in);
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/BBDD_Cocktails";
    private static final String usr = "root";
    private static final String passw = "root";

    public static Connection Conexion() {
        // Declaramos una variable para almacenar la cadena de conexión.
        // Primero la iniciamos en null
        Connection conex = null;

        // Controlamos la excepciones que puedan surgir al conectarnos a la BBDD
        try {
            // Registrar el driver
            Class.forName(driver);
            // Creamos una conexión a la Base de Datos
            conex = DriverManager.getConnection(bbdd, usr, passw);

            // Si hay errores informamos al usuario.
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
        // Devolvemos la conexión.
        return conex;
    }

    public static void consultAll() {
        try {
            Connection con = DriverManager.getConnection(bbdd, usr, passw);
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery("select strDrink, strIngredient1, strIngredient2, strIngredient3, strIngredient4 from drinks ");

            while (resultado.next()) {
                String nombre = resultado.getString("strDrink");
                String igdt1 = resultado.getString("strIngredient1");
                String igdt2 = resultado.getString("strIngredient2");
                String igdt3 = resultado.getString("strIngredient3");
                String igdt4 = resultado.getString("strIngredient4");
                System.out.println("Nombre: " + nombre + ", Ingrediente 1: " + igdt1 + ", Ingrediente 2: " + igdt2 + ", Ingrediente 3: " + igdt3 + ", Ingrediente 4: " + igdt4);

            }

            resultado.close();
            consulta.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
