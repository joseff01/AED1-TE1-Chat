package com.chat;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class MyWindow extends JFrame{

    public MyWindow(){

        this.setSize(850,720);
        this.setLocation(50,50);
        this.setTitle("Chat V0.1");

        ImageIcon chatIcon = new ImageIcon("Images\\chatIcon.jpg");
        this.setIconImage(chatIcon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(true);

        this.setMinimumSize(new Dimension(500,500));

        setVisible(true);


    }


}
