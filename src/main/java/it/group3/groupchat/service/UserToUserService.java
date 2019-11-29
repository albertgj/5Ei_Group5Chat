package it.group3.groupchat.service;

import java.io.IOException;

/**
 *
 * @author Gjerjgjaj Albert
 */

public interface UserToUserService 
{
    public void registration(String alias, String topic) throws IOException;
    public void sendMsgToUser(String message, String myId, String destId) throws IOException;
    public void receiveMsgFromUser() throws IOException;
    public void disconnect() throws IOException;
}
