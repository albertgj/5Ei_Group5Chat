package groupchat.serverconnection;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Quinta
 */
public class Conn {
    private static Socket clientSocket;
    private static DataOutputStream outputS;
    private static DataInputStream inputS;
            
    Connection() throws IOException
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
        byte[] regB = new byte[alias.length()+topic.length()+4];
        byte[] serverResponse = new byte[100];
        
        int i=0;
        regB[i++] = 10; //opcode
        
        regB[i++] = 0; //version
        
        for (byte b: alias.getBytes()) // alias
                regB[i++] = b;
        regB[i++]=0; 
        
        for (byte b: topic.getBytes()) //topic
                regB[i++] = b;
        
        regB[i++]=0;
        
        outputS.write(regB);
        
        System.out.println("Iviata richiesta");
        
        /* Ricezione pacchetto Ack server
        *    opcode (20) | id assegnato | conferma alias | ("general") 0
        */
            inputS.read(serverResponse);
        byte opcode = serverResponse[0];
        switch(opcode)
        {    
            case 20:
                String aliasAssegnato = new String(Arrays.copyOfRange(serverResponse, 3, serverResponse.length-1));
                System.out.println("Ricevuto Acknowledgement: " + "\nAlias: " + aliasAssegnato);
                break;
            case 50:
                System.out.println("Ricevuto Errore!");
                break;
        }
    }
}
