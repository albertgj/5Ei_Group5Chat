/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.group3.groupchat.implementation;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;



class mThread extends Thread{
    private byte[] bytes;
    private clientPackets cp;
    
    public mThread(byte[] b,clientPackets clientP){
        this.bytes = b;
        this.cp = clientP;
    }
    
    @Override
    public void run(){
        
        byte opcode = bytes[0];
        
        switch (opcode) {
            case 01:{
                try {
                    cp.receiveMsgFromUser(bytes);
                    break;
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
            case 05:{
                        try {
                            cp.receiveMsgFromChat(bytes);
                            break;
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
            case 11:{
                        try {
                            cp.disconnectedByServer(bytes);
                            break;
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
            case 20:{
                cp.registrationAck(bytes);
                break;
            }
            case 51:{
                try {
                    cp.receiveUserList(bytes);
                    break;
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
        }
        
    }
}
/**
 *
 * @author Quinta
 */
public class packetListener {
    
    public void listening(clientPackets clientP) throws IOException{
        
        byte[] response = new byte[2048]; 
        Socket cs = clientPackets.getClientSocket();
        DataInputStream inputS = new DataInputStream(cs.getInputStream());
            
        while(true){
            inputS.read(response);
            
            
            Thread manager = new mThread(response,clientP);
            manager.start();
        }
    }
    
    
}
