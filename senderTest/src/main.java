
import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;



public class main {

    public static void main(String[] args) throws IOException {
        System.out.println("Enviando mensaje...");
        SerialPort writePort = SerialPort.getCommPorts()[1];
        writePort.openPort();
        try (OutputStream out = writePort.getOutputStream()) {
            out.flush();
            String msg = "BINGO";
            System.out.println("String: " + msg);
            System.out.print("Bytes: ");
            System.out.println(Arrays.toString(msg.getBytes("ASCII")));
            out.write(msg.getBytes());
        }
       
    }
    
}

