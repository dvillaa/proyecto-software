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
    final String HOST = "";
    final int PUERTO = 5500;
    DataInputStream in;
    DataOutputStream out;
    
    public Cliente() throws IOException {
        Socket sc = new Socket(HOST, PUERTO);
        
        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());
        
        out.writeUTF("Hola desde el cliente");
        
        String mensaje = in.readUTF();
        
        System.out.println(mensaje);
        
        sc.close();
        
    }    
}
