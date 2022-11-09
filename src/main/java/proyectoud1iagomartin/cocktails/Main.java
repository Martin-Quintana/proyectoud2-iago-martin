package proyectoud1iagomartin.cocktails;

import java.io.IOException;
import java.sql.Connection;

import proyectoud1iagomartin.cocktails.controller.DrinkController;
import proyectoud1iagomartin.cocktails.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proyectoud1iagomartin.cocktails.tools.ConexionBBDD;

import static proyectoud1iagomartin.cocktails.tools.ConexionBBDD.*;
import static proyectoud1iagomartin.cocktails.tools.Encryption.*;

/**
 * The type Main.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 400);
            ((LoginController) fxmlLoader.getController()).setStage(primaryStage);

            //=========================================================================
            // Declaramos una variable para almacenar la conexión que nos va a devolver el método Conexion()
            Connection conex_Cocktails;
            Connection conex_LogIn;

            // Almacenamos lo que nos devuelve el método Conexion() en la variable conex
            conex_Cocktails = ConexionBBDD.Conexion(bbdd_Cocktails);
            conex_LogIn = ConexionBBDD.Conexion(bbdd_LogIn);

            // Si la variable objeto conex es diferente de nulo
            if (conex_Cocktails != null || conex_LogIn != null) {
                // Informamos que la conexión es correcta
                System.out.println("Successfully connected");
                
            } else { // Sino informamos que no nos podemos conectar.
                System.out.println("You couldn't connect");
            }
            //=========================================================================

            primaryStage.setTitle("La Cocktelera");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) {
        try {
            launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}