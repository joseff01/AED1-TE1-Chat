package com.chat;

import javax.swing.*;

import java.awt.*;

public class MyCanvas extends JPanel {

    public MyCanvas(){

        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(1,2));


        // Messages Canvas, Left Side

        MenuCanvas menuCanvas = new MenuCanvas();

        add(menuCanvas);


        // Chat Canvas, Right side
        cCanvas = new ChatCanvas();

        add(cCanvas);



    }

    public int getListenSocket() {

        return cCanvas.getListenSocket();

    }

    private ChatCanvas cCanvas;
}
