/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author Usuario
 */
public class Servidor {
    
    ServerSocket socket;
        
    public Servidor() throws IOException {
        System.out.println("Servidor iniciado");
        this.socket = new ServerSocket(3000);
        Socket cliente;
        while(true) {
            cliente = this.socket.accept();
            new ThreadCliente(cliente).start();
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Servidor();
    }
}
