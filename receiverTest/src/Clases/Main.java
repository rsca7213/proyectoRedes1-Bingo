
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

public class Main extends Application {

    public static void main(String[] args) throws IOException {
        /*
        System.out.println("Esperando recepcion de mensaje...");
        SerialPort readPort = SerialPort.getCommPorts()[1];
        readPort.openPort();
        readPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        System.out.println(readPort.getInputStream());
        InputStream in = readPort.getInputStream();
        System.out.print("Mensaje Recibido: \n String: ");
        for (int j = 0; j < 5; ++j)
            System.out.print((char)in.read());
        in.close();
        System.out.println("\n");
        readPort.closePort();
        */
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
        stage.setResizable(false);
        stage.getIcons().add(new Image("/Image/bingo.png"));
        stage.show();
        
    }

}