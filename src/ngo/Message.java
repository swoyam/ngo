/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngo;

/**
 *
 * @author swoyambhu
 */
public class Message {

    public Message(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    
    private boolean status;
    private String message;
    
    @Override
    public String toString(){
        return "Status:" + status + ".\nMessage: " + message;
    }
   
}
