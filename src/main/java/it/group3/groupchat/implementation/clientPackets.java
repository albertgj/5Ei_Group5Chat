package it.group3.groupchat.implementation;

import java.io.*;
import java.net.*;
import it.group3.groupchat.service.UserToUserService;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gjergjaj Albert
 */
public class clientPackets implements UserToUserService {

    private ArrayList<String> userList = new ArrayList();
    private static Socket clientSocket;
    private byte[] idUtente;
    private String aliasUtente;

    
    public clientPackets(Socket cs) throws IOException {
        this.clientSocket = cs;
    }

    @Override
    public void registration(String alias, String topic) throws IOException {
        byte[] regB = new byte[alias.length() + topic.length() + 4];

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

        System.out.println("Iviata richiesta di connessione");
    }
    
    @Override
    public void registrationAck(byte[] ack)
    {
        /* Ricezione pacchetto Ack server
        *    opcode (20) | id assegnato | conferma alias | ("general") 0
        */
        setId(Arrays.copyOfRange(ack,1,2));
        String aliasAssegnato = new String(Arrays.copyOfRange(ack, 3, ack.length - 1));
        setAliasUtente(aliasAssegnato);
        System.out.println("Ricevuto Acknowledgement: " + "Alias: " + aliasAssegnato);
    }
    
    @Override
    public synchronized void receiveUserList(byte[] userList) throws IOException
    {
        String list = new String( Arrays.copyOfRange(userList,2,userList[2]));    
        System.out.println(list);
        switch (userList[1]) {
            case 0:{
                for(int i = 0 ; i<list.length();i++)
                {
                    this.userList.add(list);
                }
                break;
            }
            case 1:
                this.userList.add(list);
                break;
            case 2:
                this.userList.remove(list);
                break;
        }
    }
    
    @Override
    public void requireUserList() throws IOException
    {
        byte[] reqB = new byte[1 + getId().length];
        
        int index = 0;
        reqB[index++] = 50;

        for (Byte b : getId()) {
            reqB[index++] = b;
        }

        DataOutputStream ds = new DataOutputStream(clientSocket.getOutputStream());
        ds.write(reqB);
        System.out.println("Lista richiesta con successo");
    }
    
    @Override
    public void sendMsgToUser(String message, String destAlias) throws IOException {
        
        byte[] msgB = new byte[3 + getId().length + destAlias.length() + message.length()];
        
        int index = 0;
        msgB[index++] = 01;

        for (Byte b : getId()) {
            msgB[index++] = b;
        }

        for (Byte b : destAlias.getBytes()) {
            msgB[index++] = b;
        }

        msgB[index++] = 0;

        for (Byte b : message.getBytes()) {
            msgB[index++] = b;
        }

        msgB[index++] = 0;

        DataOutputStream ds = new DataOutputStream(clientSocket.getOutputStream());
        ds.write(msgB);
    }

    @Override
    public void receiveMsgFromUser(byte[] userPkt) throws IOException
    {
        System.out.println(new String(userPkt).trim());
    }
    
    @Override
    public void sendMsgToChat(String message) throws IOException {
        
        byte[] chatMsgB = new byte[2 + getId().length + message.length()];
        
        int index = 0;
        chatMsgB[index++] = 05;

        for (Byte b : getId()) {
            chatMsgB[index++] = b;
        }

        for (Byte c : message.getBytes()) {
            chatMsgB[index++] = c;
        }

        chatMsgB[index++] = 0;

        DataOutputStream ds = new DataOutputStream(clientSocket.getOutputStream());
        ds.write(chatMsgB);
    }
    
    @Override
    public void receiveMsgFromChat(byte[] chatPkt) throws IOException
    {
        int aliasEnd = 0;
        for (byte b: chatPkt){
            if(b == 0)
            {
                break;
            }
            aliasEnd++;
        }
        
        int messageEnd = aliasEnd+1;
        for (int i = messageEnd; i<chatPkt.length - aliasEnd;i++){
            
            if(chatPkt[i] == 0)
            {
                break;
            }
            messageEnd++;
        }
        
        System.out.println(new String(Arrays.copyOfRange(chatPkt,1,aliasEnd)) + ": ");
        System.out.println(new String(Arrays.copyOfRange(chatPkt,aliasEnd+1,messageEnd)));
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

        this.userList.clear();
        System.out.println("Disconnessione Eseguita.\nLa lista utenti è stata azzerata");
    }
    
    @Override
    public void disconnectedByServer(byte[] disconnection) throws IOException
    {
        
        switch(disconnection[1]){
            case 0:
               System.out.println("Disconnesso dal server");
               break;
            case 1:
               System.out.println("Disconnesso dal server per inattività!\nSei rimasto AFK per più di 15 minuti");
               break;
            case 2:
               System.out.println("Il server è andato offline!\nSei stato disconnesso");
               break;
        }
    }
    
    @Override
    public void changeAlias(String alias) throws IOException
    {
        byte[] cngB = new byte[3 + getId().length + getAliasUtente().length() + alias.length()];
    
        int i=0;
        cngB[i++] = 18;
        
        for(byte b: getId())
            cngB[i++] = b;
        
        for(byte b: getAliasUtente().getBytes())
            cngB[i++] = b;
        
        cngB[i++] = 0;
        
        for(byte b: alias.getBytes())
            cngB[i++] = b;
        
        cngB[i++] = 0;
        
        setAliasUtente(alias);
    }
    
    public String getAliasUtente() {
        return aliasUtente;
    }

    public void setAliasUtente(String aliasUtente) {
        this.aliasUtente = aliasUtente;
    }
    
    public static Socket getClientSocket() {
        return clientSocket;
    }

    public static void setClientSocket(Socket clientSocket) {
        clientPackets.clientSocket = clientSocket;
    }
    
    public void setId(byte[] id)
    {
        this.idUtente = id;
    }
    
    public byte[] getId()
    {
        return idUtente;
    }
    

}
