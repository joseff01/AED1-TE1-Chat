package com.chat;

import javax.swing.*;

import java.awt.*;
import java.io.DataOutput;

public class ChatCanvas extends JPanel {

    GridBagConstraints gbc = new GridBagConstraints();

    public ChatCanvas() {

        this.setLayout(new GridBagLayout());

    }

    public int getListenSocket() {

        return msgCanvas.getListenSocket();

    }

    public void setMySocket(String mySocket) {

        tCanvas.setMySocket(mySocket);

    }


    public DataPack getDataPack() {

        return tCanvas.getDataPack();

    }

    private TextCanvas tCanvas;

    public TextCanvas gettCanvas() {
        return tCanvas;
    }

    public void settCanvas(TextCanvas tCanvas) {
        this.tCanvas = tCanvas;

        this.gbc.gridy = 9;
        this.gbc.anchor = GridBagConstraints.SOUTH;
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.weighty = 1;
        this.gbc.weightx = 1;

        this.add(tCanvas,this.gbc);
    }

    private MessagesCanvas msgCanvas;

    public MessagesCanvas getMsgCanvas() {
        return msgCanvas;
    }

    public void setMsgCanvas(MessagesCanvas msgCanvas) {

        this.msgCanvas = msgCanvas;
        JScrollPane ScrollCanvas = new JScrollPane(this.msgCanvas);

        this.gbc.gridy = 0;
        this.gbc.anchor = GridBagConstraints.NORTH;
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.weighty = 10;
        this.gbc.weightx = 1;

        this.add(ScrollCanvas,this.gbc);
    }

}