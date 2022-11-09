package proyectoud1iagomartin.cocktails.tools;

import proyectoud1iagomartin.cocktails.model.Drinks;

import java.sql.*;
import java.util.ArrayList;

public class ConexionBBDD {

    public static ArrayList<Drinks> drinkList = new ArrayList<>();

    public static ArrayList<Drinks> drinkListAll = new ArrayList<>();

    private static Drinks drink = new Drinks();

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String bbdd_Cocktails = "jdbc:mysql://localhost:3306/BBDD_Cocktails";
    public static final String bbdd_LogIn = "jdbc:mysql://localhost:3306/BBDD_LogIn";
    private static final String USR = "root";
    private static final String PASSW = "root";

    public static Connection Conexion(String BBDD) {
        Connection conex = null;

        try {
            Class.forName(driver);
            conex = DriverManager.getConnection(BBDD, USR, PASSW);

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }

        return conex;
    }

    public static void consultAll() {
        try {
            Connection con = DriverManager.getConnection(bbdd_Cocktails, USR, PASSW);
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery("select strDrink, strIngredient1, strIngredient2, strIngredient3, strIngredient4 from drinks ");

            while (resultado.next()) {
                String nombre = resultado.getString("strDrink");
                String igdt1 = resultado.getString("strIngredient1");
                String igdt2 = resultado.getString("strIngredient2");
                String igdt3 = resultado.getString("strIngredient3");
                String igdt4 = resultado.getString("strIngredient4");

                drink = new Drinks(nombre, igdt1, igdt2, igdt3, igdt4);
                drinkList.add(drink);
            }

            resultado.close();
            consulta.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void nameConsult(String cocktailName) {
        try {
            Connection con = DriverManager.getConnection(bbdd_Cocktails, USR, PASSW);
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery("select strDrink, strIngredient1, strIngredient2, strIngredient3, strIngredient4 from drinks where strDrink like '%" + cocktailName + "%';");

            while (resultado.next()) {
                String nombre = resultado.getString("strDrink");
                String igdt1 = resultado.getString("strIngredient1");
                String igdt2 = resultado.getString("strIngredient2");
                String igdt3 = resultado.getString("strIngredient3");
                String igdt4 = resultado.getString("strIngredient4");
                drink = new Drinks(nombre, igdt1, igdt2, igdt3, igdt4);
                drinkList.add(drink);
            }
            resultado.close();
            consulta.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean loging(String usr, String passwd) {
        boolean verificar = false;
        try {
            Connection con = DriverManager.getConnection(bbdd_LogIn, USR, PASSW);
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery("select Usr, Passwd from Usuarios where Usr = '" + usr + "'" + " and Passwd = " + "'" + passwd + "'");

            while (resultado.next()) {
                verificar = true;

            }

            resultado.close();
            consulta.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return verificar;
    }

}
