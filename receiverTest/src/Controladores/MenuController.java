
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML
    private Button exitbtn;
    
    @FXML
    private Pane lineaPane;
    
    @FXML
    private Pane llenoPane;
    
    @FXML
    private RadioButton cart1;
    
    @FXML
    private RadioButton cart2;
    
    final ToggleGroup cartones = new ToggleGroup();
    
    private void juegoLinea() {
        try {
            
            Parent page = FXMLLoader.load(getClass().getResource("../Vistas/juegoLinea.fxml"));       
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego de Linea");
            stage.centerOnScreen();
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }
    
    private void juegoLinea2() {
        try {
            Parent page = FXMLLoader.load(getClass().getResource("../Vistas/juegoLinea2.fxml"));       
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego de Linea (2 cartones)");
            stage.centerOnScreen();
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    private void juegoLleno() {
        try {
            
            Parent page = FXMLLoader.load(getClass().getResource("../Vistas/juegoLleno.fxml"));       
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego Cartón Lleno");
            stage.centerOnScreen();
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }
    
    private void juegoLleno2() {
        System.out.println("opcion no disponible");
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
            if(cart1.isSelected()) {
                System.out.println("Opcion de juego de linea con 1 carton clickeado.");
                juegoLinea();
            }
            else {
                System.out.println("Opcion de juego de linea con 2 cartones clickeado.");
                juegoLinea2();
            }
        });
        llenoPane.setOnMouseClicked((event) -> {
            if(cart1.isSelected()) {
                System.out.println("Opcion de juego de carton lleno con 1 carton clickeado.");
                juegoLleno();
            }
            else {
                System.out.println("Opcion de juego de carton lleno con 2 cartones clickeado.");
                juegoLleno2();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cart1.setToggleGroup(cartones);
        cart2.setToggleGroup(cartones);
        cart1.setSelected(true);
        setClickEvents();
        setHovers();
        
    }
    
    @FXML
    private void exitApp(ActionEvent event) {
        System.exit(0);
    }
    

}
