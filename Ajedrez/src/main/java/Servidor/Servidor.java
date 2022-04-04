/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import common.Conexion;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author carlo
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
         
        try {
            int puerto = 5000;
            ServerSocket sc = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            
            while(true){
                Socket socketCliente = sc.accept();
                Conexion x = new Conexion(socketCliente);
            }
            
        } catch (IOException ex) {
            System.out.println("Escuchando:" + ex.getMessage());
        }
          
    }
}

class Conexion extends Thread{
    DataInputStream in;
    DataOutputStream out;
    ObjectOutputStream outVector;
    ObjectInputStream inVector;
    Socket socketCliente;
    String[] num = new String[4];
    int servicio;
    int inicio;
    int fin;
    int[] primos = new int[10000000];
    int resultado;
    
    public Conexion(Socket aSocketCliente){
        
        try{
            socketCliente = aSocketCliente;
            in = new DataInputStream(socketCliente.getInputStream());
            out = new DataOutputStream(socketCliente.getOutputStream());
            outVector = new ObjectOutputStream(socketCliente.getOutputStream());
            inVector = new ObjectInputStream(socketCliente.getInputStream());
            this.start();
        } catch(IOException ex){
            System.out.println("Conexion:" + ex.getMessage());
        }
       
    }
    
    @Override
    public void run(){
        try{
            num = (String[])inVector.readObject();
            servicio = Integer.parseInt(num[1]);
            inicio = Integer.parseInt(num[2]);
            fin = Integer.parseInt(num[3]);
            System.out.println("Servicio: " + num[1]);
            System.out.println("Rango: " + num[2] + " " + num[3]);
            
            if(servicio == 0){
                resultado = cuenta_primos(inicio, fin);
                System.out.println("Numero de primos: " + resultado);
                out.writeInt(resultado);
            } else if(servicio == 1){
                resultado = encuentra_primos(inicio, fin, primos);
                System.out.println("Numero de primos: " + resultado);
                out.writeInt(resultado);
                outVector.writeObject(primos);
            }
            socketCliente.close();
        } catch(Exception ex){
            System.out.println("IO:" + ex.getMessage());
        }
    }

