
package Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML
    private Button exitbtn;
    
    @FXML
    private Pane lineaPane;
    
    @FXML
    private Pane llenoPane;
    
    private void juegoLinea() {
        try {
            
            Parent page = FXMLLoader.load(getClass().getResource("../Vistas/juegoLinea.fxml"));       
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego de Linea");
            
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }
    
    private void setHovers () {
        lineaPane.setOnMouseEntered((event) -> {
            lineaPane.setStyle("-fx-background-color: #c0c0c0;");
        });
        lineaPane.setOnMouseExited((event) -> {
            lineaPane.setStyle("-fx-background-color: transparent;");
        });
        llenoPane.setOnMouseEntered((event) -> {
            llenoPane.setStyle("-fx-background-color: #c0c0c0;");
        });
        llenoPane.setOnMouseExited((event) -> {
            llenoPane.setStyle("-fx-background-color: transparent;");
        });
        exitbtn.setOnMouseEntered((event) -> {
            exitbtn.setStyle("-fx-background-color: #1a75ff;");
        });
        exitbtn.setOnMouseExited((event) -> {
            exitbtn.setStyle("-fx-background-color: #4d94ff;");
        });
    }
    
    private void setClickEvents() {
        System.out.println("Controlador inicializado.");
        lineaPane.setOnMouseClicked((event) -> {
            System.out.println("Opcion de juego de linea clickeado.");
            juegoLinea();
        });
        llenoPane.setOnMouseClicked((event) -> {
            System.out.println("Opcion de juego de carton lleno clickeado.");
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setClickEvents();
        setHovers();
        
    }
    
    @FXML
    private void exitApp(ActionEvent event) {
        System.exit(0);
    }
    

}
