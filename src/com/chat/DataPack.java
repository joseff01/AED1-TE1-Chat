package com.chat;

import java.io.Serializable;

public class DataPack implements Serializable {

    private String SenderIP, Message, SenderSocket;

    public String getSenderIP() {
        return SenderIP;
    }

    public void setSenderIP(String senderIP) {
        SenderIP = senderIP;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSenderSocket() {
        return SenderSocket;
    }

    public void setSenderSocket(String senderSocket) {
        SenderSocket = senderSocket;
    }


}
