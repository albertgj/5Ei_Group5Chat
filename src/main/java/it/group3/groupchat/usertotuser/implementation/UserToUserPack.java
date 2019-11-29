package it.group3.groupchat.usertotuser.implementation;


import java.io.*;
import java.net.*;
import it.group3.groupchat.usertotuser.service.UserToUserService;

/**
 *
 * @author Gjergjaj Albert
 */
public class UserToUserPack implements UserToUserService {

    private byte[] messageSend = new byte[2043];
    private byte[] messageRecive = new byte[2043];
    private static Socket clientSocket;

    public UserToUserPack() throws IOException {
        clientSocket = new Socket("127.0.0.1", 53102);
    }

    @Override
    public void sendMsgToUser(String message, String myId, String destId) throws IOException {
        //Send Message Part
        int index = 0;
        messageSend[index++] = 0;

        messageSend[index++] = 1;

        for (Byte b : myId.getBytes()) {
            messageSend[index++] = b;
        }

        for (Byte b : destId.getBytes()) {
            messageSend[index++] = b;
        }

        messageSend[index++] = 0;

        for (Byte b : message.getBytes()) {
            messageSend[index++] = b;
        }

        messageSend[index++] = 0;
        
        DataOutputStream ds = new DataOutputStream(clientSocket.getOutputStream());
        ds.write(messageSend);
    }

    @Override
    public void receiveMsgFromUser() throws IOException {
        
        DataInputStream di = new DataInputStream(clientSocket.getInputStream());
        di.read(messageRecive);

        System.out.println(new String(messageRecive, 2, messageRecive.length - 3));
    }

    @Override
    public void disconnect() {

    }
}
