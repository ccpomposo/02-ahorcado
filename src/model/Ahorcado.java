/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.IntentosAgotadosException;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Ahorcado {

    public static final String[] PALABRAS = {"RELOJ", "HOJA", "TORTUGA", "CORROSION", "CARTILAGO", "TRIFOSFATO", "AUTOMOVIL", "PICAPORTE", "ALMOHADA", "PIZARRON",
        "PARED", "ANTICONSTITUCIONALMENTE", "ORIENTACION", "NACIONALISMO", "IDENTIFICACION", "INDIVIDUO", "FUNDAMENTALMENTE", "HOMOGENEIZACION", "CATEGORIA", "DESARROLLO"};
    private Integer intentos;
    private String palabra;
    private char[] palabrita;

    public Ahorcado(Integer intentos) {
        this.intentos = intentos;
        Random random = new Random();
        int pos = (int)Math.round(random.nextDouble() * Ahorcado.PALABRAS.length);
        this.palabra = PALABRAS[pos];
        System.out.println(pos);
        this.palabrita = new char[this.palabra.length()];
        for (int i = 0; i < palabrita.length; i++) {
            this.palabrita[i] = '-';
        }
    }

    public boolean jugar(String palabra) throws IntentosAgotadosException {
        boolean flag = false;
        if (this.intentos > 0) {
            if (palabra.equalsIgnoreCase(this.palabra)) {
                this.intentos = 0;
                return true;
                
            } else {
                char c = palabra.toUpperCase().charAt(0);
                for (int i = 0; i < this.palabra.length(); i++) {
                    if (c == this.palabra.charAt(i)) {
                        this.palabrita[i] = c;
                        if(!flag){
                            flag = true;
                        }
                    }
                }
                if (this.palabra.compareTo(new String(this.palabrita)) == 0) {
                    this.intentos = 0;
                    return true;
                } else {
                    if(!flag) {
                        this.intentos--;
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        } else {
            throw new IntentosAgotadosException();
        }
    }

    public Integer getIntentos() {
        return intentos;
    }

    public String getPalabra() {
        return palabra;
    }
    
    public String getPalabrita() {
        return new String(this.palabrita);
    }
    
}
