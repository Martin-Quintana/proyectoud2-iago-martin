package proyectoud1iagomartin.cocktails.controller;

import proyectoud1iagomartin.cocktails.model.Drinks;
import proyectoud1iagomartin.cocktails.model.Response;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import static proyectoud1iagomartin.cocktails.tools.ConexionBBDD.*;

/**
 * Contiene el codigo de la ventana principal del progrma.
 */
public class DrinkController implements Initializable {

    //URL de la API para buscar en ella
    private String finalURL = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    private String rndURL = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

    @FXML
    private TextField name;

    @FXML
    private TextField fileName;

    @FXML
    private TableView<Drinks> tableView;

    @FXML
    private TableColumn tbl_name;

    @FXML
    private TableColumn tbl_ingrediente1;

    @FXML
    private TableColumn tbl_ingrediente2;

    @FXML
    private TableColumn tbl_ingrediente3;

    @FXML
    private TableColumn tbl_ingrediente4;

    private ObjectMapper objectMapper = new ObjectMapper();


    private ObservableList<Drinks> tableDrinks;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText("Margarita");
        all();


        tableDrinks = FXCollections.observableArrayList();

        //Inicializar columnas de la tabla
        this.tbl_name.setCellValueFactory(new PropertyValueFactory("strDrink"));
        this.tbl_ingrediente1.setCellValueFactory(new PropertyValueFactory("strIngredient1"));
        this.tbl_ingrediente2.setCellValueFactory(new PropertyValueFactory("strIngredient2"));
        this.tbl_ingrediente3.setCellValueFactory(new PropertyValueFactory("strIngredient3"));
        this.tbl_ingrediente4.setCellValueFactory(new PropertyValueFactory("strIngredient4"));
    }


    public void all() {
        consultAll();

        tableDrinks = FXCollections.observableArrayList(drinkList);
        tableView.setItems(tableDrinks);
        tableDrinks.stream().forEach(System.out::println);
    }

    /**
     * Imprimir en la tabla el cocktail correspondiente al nombre introducido por teclado
     *
     * @param actionEvent the action event
     */
    public void setName(ActionEvent actionEvent) {
        drinkList.clear();
        String cocktailName = this.name.getText();

        nameConsult(cocktailName);

        tableDrinks = FXCollections.observableArrayList(drinkList);
        tableView.setItems(tableDrinks);
        tableDrinks.stream().forEach(System.out::println);
        drinkListAll.addAll(drinkList);


    }

    /**
     * Imprimir en la tabla un cocktail random
     *
     * @param actionEvent the action event
     */
    public void setRandom(ActionEvent actionEvent) {
        try {
            URL jsonURL = new URL(rndURL);
            Response response = objectMapper.readValue(jsonURL, Response.class);

            for (int i = 0; i < response.getDrinks().size(); i++) {

            }

            tableDrinks = FXCollections.observableArrayList(drinkList);
            tableView.setItems(tableDrinks);
            tableDrinks.stream().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exportar el contenido de la tabla a un archivo .txt/.bin/.XML/.JSON
     *
     * @param actionEvent the action event
     */
    public void export(ActionEvent actionEvent) {
        String fileName = this.fileName.getText();

        //Escribir en fichero JSON
        try {

            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File("..\\proyectoud2-iago-martin\\src\\files\\" + fileName + ".json"), drinkListAll);

            System.out.println("Se creó un archivo llamado " + fileName + ".json");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}