
package Clases;


import com.fazecast.jSerialComm.SerialPort;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Scanner;
import javafx.application.Platform;

public class Main extends Application {

    public static void main(String[] args) throws IOException {
        
        /*
        Conector conector = new Conector();
        conector.probarConectores();
        conector.configurarEventoReceptor();
        conector.enviarMensaje("mensajito");
        conector.enviarMensaje("hola");
        try {
            conector.getReadPort().closePort();
        }
        catch(Exception e) {
            System.err.println("Ocurrio un error al cerrar el puerto, verifica que VSPE este activo.");
        }*/
        
        
        launch(args);
        
        /*
        //Pruebas para clase jugador
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de cartones que tendrá el jugador");
        int cartones = entrada.nextInt();
        
        Jugador jugador = new Jugador();
        jugador.crearCartones(1);
        */
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Vistas/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Bingo");
        stage.setX(450);
        stage.setY(50);
        stage.setOnCloseRequest(e->{
                Platform.exit();
                System.exit(0);    
        });
        stage.setResizable(false);
        stage.getIcons().add(new Image("/Image/bingo.png"));
        stage.show();
        
    }

}
