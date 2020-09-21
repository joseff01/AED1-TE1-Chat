package com.chat;

import javax.swing.*;

import java.awt.*;
import java.io.DataOutput;

public class ChatCanvas extends JPanel {

    public ChatCanvas() {

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Messages Canvas

        msgCanvas = new MessagesCanvas();
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 10;
        gbc.weightx = 1;

        this.add(msgCanvas,gbc);

        // TextBox Canvas

        tCanvas = new TextCanvas();
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;

        this.add(tCanvas,gbc);




    }

    public int getListenSocket() {

        return msgCanvas.getListenSocket();

    }

    public void setMySocket(String mySocket) {

        tCanvas.setMySocket(mySocket);

    }

    public TextCanvas tCanvas;

    private MessagesCanvas msgCanvas;


    public void setFlagStateFalse() {

        tCanvas.setFlagStateFalse();
    }

    public DataPack getDataPack() {

        return tCanvas.getDataPack();

    }
}