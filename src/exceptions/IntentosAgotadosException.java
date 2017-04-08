/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Usuario
 */
public class IntentosAgotadosException extends Exception {

    /**
     * Creates a new instance of <code>IntentosAgotadosException</code> without
     * detail message.
     */
    public IntentosAgotadosException() {
    }

    /**
     * Constructs an instance of <code>IntentosAgotadosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IntentosAgotadosException(String msg) {
        super(msg);
    }
}
