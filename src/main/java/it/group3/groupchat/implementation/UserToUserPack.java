package it.group3.groupchat.implementation;

import java.io.*;
import java.net.*;
import it.group3.groupchat.service.UserToUserService;
import java.util.Arrays;

/**
 *
 * @author Gjergjaj Albert
 */
public class UserToUserPack implements UserToUserService {

    private byte[] messageSend = new byte[2043];
    private byte[] messageRecive = new byte[2043];
    private static Socket clientSocket;
    private byte[] idUtente ;

    public UserToUserPack() throws IOException {
        clientSocket = new Socket("127.0.0.1", 53102);
    }

    @Override
    public void registration(String alias, String topic) throws IOException {
        byte[] regB = new byte[alias.length() + topic.length() + 4];
        byte[] serverResponse = new byte[100];

        int i = 0;
        regB[i++] = 10; //opcode

        regB[i++] = 0; //version

        for (byte b : alias.getBytes()) // alias
        {
            regB[i++] = b;
        }
        regB[i++] = 0;

        for (byte b : topic.getBytes()) //topic
        {
            regB[i++] = b;
        }

        regB[i++] = 0;

        DataOutputStream outputS = new DataOutputStream(clientSocket.getOutputStream());
        outputS.write(regB);

        System.out.println("Iviata richiesta");

        /* Ricezione pacchetto Ack server
        *    opcode (20) | id assegnato | conferma alias | ("general") 0
         */
        DataInputStream inputS = new DataInputStream(clientSocket.getInputStream());
        inputS.read(serverResponse);
        byte opcode = serverResponse[0];
        switch (opcode) {
            case 20:
                String aliasAssegnato = new String(Arrays.copyOfRange(serverResponse, 3, serverResponse.length - 1));
                System.out.println("Ricevuto Acknowledgement: " + "\nAlias: " + aliasAssegnato);
                break;
            case 50:
                System.out.println("Ricevuto Errore!");
                break;
        }
    }
    
    public void setId(byte[] id)
    {
        this.idUtente = id;
    }
    
    public byte[] getId()
    {
        return idUtente;
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
    public void disconnect() throws IOException
    {
        byte[] id = getId();
        byte[] discB = new byte[id.length + 1];

        int i = 0;
        discB[i++] = 11; //opcode

        for (byte b : id) // id
        {
            discB[i++] = b;
        }

        DataOutputStream outputS = new DataOutputStream(clientSocket.getOutputStream());
        outputS.write(discB);

        System.out.println("Disconnessione Eseguita");
    }
}
