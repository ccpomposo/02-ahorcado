/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.IntentosAgotadosException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ThreadCliente extends Thread {

    private ObjectOutputStream oStream;
    private ObjectInputStream iStream;
    private Socket cliente;
    public static final Integer INTENTOS = 5;

    public ThreadCliente(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.oStream = new ObjectOutputStream(this.cliente.getOutputStream());
        this.iStream = new ObjectInputStream(this.cliente.getInputStream());
    }

    @Override
    public void run() {
        Ahorcado ahorcado = new Ahorcado(INTENTOS);
        String palabra;
        String salir = "N";
        while (!salir.equalsIgnoreCase("S")) {
            while (true) {
                try {
                    this.oStream.writeObject(String.format("Tienes %d intentos %n %s", ahorcado.getIntentos(), ahorcado.getPalabrita()));
                    palabra = (String) this.iStream.readObject();
                    ahorcado.jugar(palabra);
                    if (ahorcado.getIntentos() == 0) break;
                } catch (IOException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IntentosAgotadosException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                oStream.writeObject("Quieres salir? S/N)");
                salir = (String)iStream.readObject();
                ahorcado = new Ahorcado(INTENTOS);
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            oStream.writeObject("Adios");
            oStream.close();
            iStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
