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
import java.util.ArrayList;
import java.util.ResourceBundle;

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

    private Drinks drink = new Drinks();

    private ObservableList<Drinks> tableDrinks;

    private ArrayList<Drinks> drinkList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText("Margarita");

        tableDrinks = FXCollections.observableArrayList();

        //Inicializar columnas de la tabla
        this.tbl_name.setCellValueFactory(new PropertyValueFactory("strDrink"));
        this.tbl_ingrediente1.setCellValueFactory(new PropertyValueFactory("strIngredient1"));
        this.tbl_ingrediente2.setCellValueFactory(new PropertyValueFactory("strIngredient2"));
        this.tbl_ingrediente3.setCellValueFactory(new PropertyValueFactory("strIngredient3"));
        this.tbl_ingrediente4.setCellValueFactory(new PropertyValueFactory("strIngredient4"));
    }

    /**
     * Imprimir en la tabla el cocktail correspondiente al nombre introducido por teclado
     *
     * @param actionEvent the action event
     */
    public void setName(ActionEvent actionEvent) {
        try {
            URL jsonURL = new URL(finalURL + name.getText());

            Response response = objectMapper.readValue(jsonURL, Response.class);
            for (int i = 0; i < response.getDrinks().size(); i++) {
                drink = new Drinks(response.getDrinks().get(i).getStrDrink(),
                        response.getDrinks().get(i).getStrIngredient1(),
                        response.getDrinks().get(i).getStrIngredient2(),
                        response.getDrinks().get(i).getStrIngredient3(),
                        response.getDrinks().get(i).getStrIngredient4());
                drinkList.add(drink);
            }

            tableDrinks = FXCollections.observableArrayList(drinkList);
            tableView.setItems(tableDrinks);
            tableDrinks.stream().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
                drink = new Drinks(response.getDrinks().get(i).getStrDrink(),
                        response.getDrinks().get(i).getStrIngredient1(),
                        response.getDrinks().get(i).getStrIngredient2(),
                        response.getDrinks().get(i).getStrIngredient3(),
                        response.getDrinks().get(i).getStrIngredient4());
                drinkList.add(drink);
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

        //Escribir en fichero .txt
        try (PrintWriter writer = new PrintWriter("..\\proyectoud1-iago-martin\\src\\files\\" + fileName + ".txt")) {
            writer.println(drinkList);
            System.out.println("Se creó un archivo llamado " + fileName + ".txt");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        //Escribir en fichero .bin
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("..\\proyectoud1-iago-martin\\src\\files\\" + fileName + ".bin"))) {
            URL jsonURL = new URL(finalURL + name.getText());

            Response response = objectMapper.readValue(jsonURL, Response.class);

            for (int i = 0; i < response.getDrinks().size(); i++) {
                writer.writeObject(i);
            }
            System.out.println("Se creó un archivo llamado " + fileName + ".bin");
        } catch (IOException ex) {
            System.err.println(ex);
        }

        //Escribir en fichero .XML
        try {
            URL jsonURL = new URL(finalURL + name.getText());

            Response response = objectMapper.readValue(jsonURL, Response.class);

            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Crear un DOMImplementation
            DOMImplementation implementation = builder.getDOMImplementation();

            // Crear un document con un elemento raiz
            Document document = implementation.createDocument(null, "cocktails", null);
            document.setXmlVersion("1.0");

            // Crear los elementos
            Element drinks = document.createElement("drinks");
            Element drink = document.createElement("drink");

            for (int i = 0; i < response.getDrinks().size(); i++) {
                // Nombre
                Element name = document.createElement("nombre");
                Text textName = document.createTextNode(drinkList.get(i).getStrDrink());
                name.appendChild(textName);
                drink.appendChild(name);

                // Ingrediente 1
                Element ingrediente1 = document.createElement("ingrediente1");
                Text textingrediente1 = document.createTextNode(drinkList.get(i).getStrIngredient1());
                ingrediente1.appendChild(textingrediente1);
                drink.appendChild(ingrediente1);

                // Ingrediente 2
                Element ingrediente2 = document.createElement("Ingrediente2");
                Text textingrediente2 = document.createTextNode(drinkList.get(i).getStrIngredient2());
                ingrediente2.appendChild(textingrediente2);
                drink.appendChild(ingrediente2);

                // Ingrediente 3
                Element ingrediente3 = document.createElement("Ingrediente3");
                Text textingrediente3 = document.createTextNode(drinkList.get(i).getStrIngredient3());
                ingrediente3.appendChild(textingrediente3);
                drink.appendChild(ingrediente3);
            }

            // Añadir al elemento drinks el elemento drink
            drinks.appendChild(drink);

            // Añadir al root el elemento drinks
            document.getDocumentElement().appendChild(drinks);

            // Asociar el source con el Document
            Source source = new DOMSource(document);

            // Crear el Result, indicado que fichero se va a crear
            Result result = new StreamResult(new File("..\\proyectoud1-iago-martin\\src\\files\\" + fileName + ".xml"));

            // Crear un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            System.out.println("Se creó un archivo llamado " + fileName + ".xml");

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Escribir en fichero JSON
        try {
            URL jsonURL = new URL(finalURL + name.getText());
            Response response = objectMapper.readValue(jsonURL, Response.class);

            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File("..\\proyectoud1-iago-martin\\src\\files\\" + fileName + ".json"), drinkList);

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