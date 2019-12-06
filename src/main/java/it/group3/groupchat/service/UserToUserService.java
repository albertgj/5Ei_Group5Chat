package it.group3.groupchat.service;

import java.io.IOException;

/**
 *
 * @author Gjerjgjaj Albert
 */

public interface UserToUserService 
{
    public void registration(String alias, String topic) throws IOException;
    public void registrationAck(byte[] ack) throws IOException;
    public void receiveUserList(byte[] userList) throws IOException;
    public void requireUserList() throws IOException;
    public void sendMsgToUser(String message,String destAlias) throws IOException;
    public void receiveMsgFromUser(byte[] userPkt) throws IOException;
    public void sendMsgToChat(String message) throws IOException;
    public void receiveMsgFromChat(byte[] chatPkt) throws IOException;
    public void disconnect() throws IOException;
    public void disconnectedByServer(byte[] disconnected) throws IOException;
    public void changeAlias(String alias) throws IOException;
}
