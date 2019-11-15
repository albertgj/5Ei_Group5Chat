package groupchat.serverconnection;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Gruppo 3
 */
public class Conn {
    private static Socket clientSocket;
    private static DataOutputStream outputS;
    private static DataInputStream inputS;
            
    public Conn() throws IOException
    {
        clientSocket = new Socket("127.0.0.1", 53101);
        outputS = new DataOutputStream(clientSocket.getOutputStream());
        inputS =  new DataInputStream( clientSocket.getInputStream() );
    }
    
    public void registration(String alias,String topic) throws IOException
    {
        /* Pacchetto registration
        *    opcode (10) | version(0) | alias | 0 | topic("general") | 0
        */
        byte[] regB = new byte[2043];
        byte[] serverAck = new byte[2043];
        
        int i=0;
        regB[i++] = 1;
        regB[i++] = 0; //opcode
        
        regB[i++] = 0; //version
        
        for (byte b: alias.getBytes()) // alias
                regB[i++] = b;
        regB[i++]=0; 
        
        for (byte b: topic.getBytes()) //topic
                regB[i++] = b;
        
        regB[i++]=0;
        
        outputS.write(regB);
        
        /* Ricezione pacchetto Ack server
        *    opcode (20) | id assegnato | conferma alias | ("general") 0
        */
        
        inputS.read(serverAck);
        String opcode = (String)line.substring(0,2);
        switch(opcode)
        {
            case "20":
                    
            case "50":
        }
        
        
    }

    public void connessione() throws IOException 
    {
        InputStreamReader InputS = new InputStreamReader(clientSocket.getInputStream());

        DataOutputStream OutputS = new DataOutputStream(clientSocket.getOutputStream());
        OutputS.writeBytes("Hello\n");

        BufferedReader bf = new BufferedReader(InputS);
        String line = "";
        while (bf.ready()|| line.length() < 5) {
            char c = (char) bf.read();
            line += c;
        }
        OutputS.close();
        clientSocket.close();
    }
}
