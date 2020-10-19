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


    private TextCanvas tCanvas;


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