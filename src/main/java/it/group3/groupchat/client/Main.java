package it.group3.groupchat.client;

import PCP.services.*;
import it.group3.groupchat.implementation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;




class lThread extends Thread{

    private clientPackets cp;
    public lThread(clientPackets clientS)
    {
        cp = clientS;
    }
    
    @Override
    public void run(){
        packetListener pl = new packetListener();
        
        try {
            pl.listening(cp);
        } catch (IOException ex) {
            Logger.getLogger(lThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/**
 *
 * @author Gjergjaj Albert
 */
public class Main 
{
    public static void main(String[] args)  throws IOException, InterruptedException
    {
        
        PCPServer server = new PCPServer(InetAddress.getLoopbackAddress());
        server.acceptAndServe();
        
        Socket clientSocket = new Socket("172.16.7.141", 53101);
        clientPackets cp = new clientPackets(clientSocket);
        
        Thread listener = new lThread(cp);
        listener.start();
        
        cp.registration("SamPorter", "general");
        Thread.sleep(2000);
        cp.sendMsgToChat("Sas Ses Sus");
        cp.changeAlias("SamBridges");
        Thread.sleep(2000);
        cp.sendMsgToChat("Toth asiatico");
        
    }
}
