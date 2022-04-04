/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author carlo
 */
public class Servidor {

    public static void main(String[] args) {
         
        try {
            int puerto = 5500;
            ServerSocket sc = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            
            while(true){
                Socket socketCliente = sc.accept();
                ServidorThread x = new ServidorThread(socketCliente);
            }
            
        } catch (IOException ex) {
            System.out.println("Escuchando:" + ex.getMessage());
        }
          
    }
}

