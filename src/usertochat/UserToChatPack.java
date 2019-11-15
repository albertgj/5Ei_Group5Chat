package usertochat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;

/**
 *
 * @author Donzi
 */

public class UserToChatPack 
{
    private Socket serverSocket;
    private String myid;
    
    public void usertochat(String message) throws IOException
    {
       this.serverSocket = new Socket("127.0.0.1", 53101);
       DatagramPacket dp = null;
       int i= 0;
       byte[] cons = new byte[2044];
       cons[i++]= 0;
       cons[i++]= 5;
       for (byte b : this.myid.getBytes()){
           cons[i++]= b;
       }
       for (byte m : message.getBytes()){
           cons[i++]= m;
       }
       cons[i++]= 0;
       
       DataOutputStream dos = new DataOutputStream(serverSocket.getOutputStream());
       dos.write(cons);
    }

    public Socket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public String getMyid() {
        return myid;
    }

    public void setMyid(String myid) {
        this.myid = myid;
    }
    
     
}
