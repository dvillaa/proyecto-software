/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.ModeloEnLinea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author david
 */
public class Cliente {
    final String HOST = "10.1.64.61";
    final int PUERTO = 5500;
    DataInputStream in;
    DataOutputStream out;
    
    
    public Cliente(boolean truno) throws IOException {
        Socket sc = new Socket(HOST, PUERTO);
        
        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());
        
        out.writeUTF("Hola desde el cliente" + truno);
        
        String mensaje = in.readUTF();
        
        System.out.println(mensaje);
        if (truno){
            for (int i = 0; i < 100; i++){

               out.writeUTF("Hola");
            }
        }
        
        sc.close();
        
    }    
}
