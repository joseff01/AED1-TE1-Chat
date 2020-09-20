package com.chat;

import javax.swing.*;

import java.awt.*;

public class ChatCanvas extends JPanel {

    public ChatCanvas(){

        this.setBackground(Color.BLUE);

        this.setLayout(null);

        // TextBox Canvas

        TextCanvas tCanvas = new TextCanvas();

        tCanvas.setBounds(0,550,420,135);

        // Messages Canvas

        MessagesCanvas msgCanvas = new MessagesCanvas();

        msgCanvas.setBounds(0,0,420,550);

        add(tCanvas);
        add(msgCanvas);


    }
}
