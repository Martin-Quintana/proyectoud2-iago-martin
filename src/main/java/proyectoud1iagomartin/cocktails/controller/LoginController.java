package proyectoud1iagomartin.cocktails.controller;

import proyectoud1iagomartin.cocktails.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static proyectoud1iagomartin.cocktails.tools.ConexionBBDD.loging;

/**
 * Contiene el codigo de la ventana login del progrma.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    private Stage stage;

    /**
     * Log in.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    public void LogIn(ActionEvent actionEvent) {
        String usr = user.getText();
        String passwd = pass.getText();

        if (loging(usr, passwd) == true) {
            System.out.println("Bienvenido");

            //Abrir main-view
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
            Scene scene2 = null;
            try {
                scene2 = new Scene(fxmlLoader.load(), 645, 490);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene2);
        } else {
            System.out.println("Usuario o contrasena erroena");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Sets stage.
     *
     * @param stage the stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
