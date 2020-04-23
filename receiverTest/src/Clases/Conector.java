
package Clases;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Conector {
    private SerialPort readPort = null;
    private SerialPort writePort = null;
    
    public Conector() {
        try {
            this.readPort = SerialPort.getCommPorts()[0];
            this.writePort = SerialPort.getCommPorts()[0];
        }
        catch(Exception e) {
            System.err.println("Ha ocurrido un error al crear los puertos!");
        }
    }
    
    public void probarConectores() {
        System.out.println("Receptor: " + readPort);
        System.out.println("Escritor: " + writePort);
    }
    
    public void enviarMensaje(String mensaje) {
        System.out.println("\n Enviando mensaje...");
        try {
            this.writePort.openPort();
            try (OutputStream out = this.writePort.getOutputStream()) {
                out.flush();
                System.out.println("String: " + mensaje); 
                System.out.print("Bytes: ");
                System.out.println(Arrays.toString(mensaje.getBytes("ASCII")));
                out.write(mensaje.getBytes());
                System.out.println("Mensaje enviado! \n");
            }
            catch (Exception e) {
                System.err.println("Mensaje fallido! \n");
            }
            finally {
                writePort.closePort();
            }
        }
        catch(Exception e) {
            System.out.println("No se puedo abrir el puerto de escritura. \n");
        }
    }
    
    public void configurarEventoReceptor() {
        try {
            System.out.println("Configurando receptor...");
            readPort.openPort();
            readPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
            readPort.addDataListener(new SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                }

                @Override
                public void serialEvent(SerialPortEvent e) {
                    if (e.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) return;
                    else {
                        System.out.println("Leyendo mensaje...");
                        try {
                            InputStream in = readPort.getInputStream();
                            System.out.print("Mensaje Recibido: \n String: ");
                            do {
                                System.out.print((char)in.read());
                            } while(readPort.bytesAvailable() > 0);
                            in.close();
                            System.out.println("\n");
                        }
                        catch(IOException exception) {
                            System.err.println("Error leyendo mensaje!");
                        }
                        catch(Exception exception) {
                            System.err.println("Error leyendo mensaje!");
                        }
                    }
                }
            
            });     
            System.out.println("Receptor Configurado!");
        }
        catch (Exception e) {
            System.out.println("Error al configurar el evento para el puerto receptor!");
        }
    }

    public SerialPort getReadPort() {
        return readPort;
    }

    public SerialPort getWritePort() {
        return writePort;
    }
    
    
}
