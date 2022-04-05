/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author carlo
 */
public class ServidorThread extends Thread{
    DataInputStream in;
    DataOutputStream out;
    ObjectOutputStream outVector;
    ObjectInputStream inVector;
    Socket socketCliente;
    int numCliente = 1;
    String mesaje;
    
    public ServidorThread(Socket aSocketCliente){
        
        try{
            socketCliente = aSocketCliente;
            in = new DataInputStream(socketCliente.getInputStream());
            out = new DataOutputStream(socketCliente.getOutputStream());
        } catch(IOException ex){
            System.out.println("Conexion:" + ex.getMessage());
        }
       
    }
    
    @Override
    public void run(){
        try{
            out.writeUTF("Conexion aceptada cliente " + numCliente);
            numCliente++;
            System.out.println(in.readUTF());
            while((mesaje = in.readUTF()) != null){
                System.out.println(mesaje);
            }
            socketCliente.close();
        } catch(Exception ex){
            System.out.println("IO:" + ex.getMessage());
        }
    }
}
