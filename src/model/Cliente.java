/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
    //private ObjectOutputStream oStream;
    //private ObjectInputStream iStream;
    
    public Cliente() throws IOException {
        
    }
//    
//    private void enviarPalabra() throws IOException {
//        Scanner in = new Scanner(System.in);
//        String palabra = in.nextLine();
//        oStream.writeObject(palabra);
//        in.close();
//    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket;
        socket = new Socket("127.0.0.1", 3000);
        ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream iStream = new ObjectInputStream(socket.getInputStream());
        Scanner in = new Scanner(System.in);
        String mensaje;
        while(true) {
            System.out.println((String)iStream.readObject());
            mensaje = in.nextLine();
            oStream.writeObject(mensaje);
        }
    }
}
