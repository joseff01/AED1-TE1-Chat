package com.chat;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame{

    public MyWindow(){

        // Default window values

        this.setSize(850,720);
        this.setLocation(50,50);
        this.setTitle("Chat V0.1");

        ImageIcon chatIcon = new ImageIcon("Images\\chatIcon.jpg");
        this.setIconImage(chatIcon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setMinimumSize(new Dimension(500,500));

        setVisible(true);


    }


}
