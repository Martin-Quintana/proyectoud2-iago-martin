package proyectoud1iagomartin.cocktails.tools;

import java.sql.*;
import java.util.Scanner;

public class ConexionBBDD {
    static Scanner scan = new Scanner(System.in);
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/";
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
            ResultSet resultado = consulta.executeQuery("select * from ");

            while (resultado.next()) {
                }

            resultado.close();
            consulta.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
