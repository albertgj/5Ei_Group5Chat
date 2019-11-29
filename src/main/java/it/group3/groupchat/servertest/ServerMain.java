package it.group3.groupchat.servertest;

import PCP.services.*;
import java.io.*;
import java.net.InetAddress;

/**
 *
 * @author Gjergjaj Albert
 */

public class ServerMain 
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        PCPServer server = new PCPServer(InetAddress.getLoopbackAddress());
        
        server.acceptAndServe();
        
        Thread.sleep(5000);
    }
}
