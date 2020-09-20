package com.chat;

import javax.swing.*;

import java.awt.*;

public class MyWindow extends JFrame{

    public MyWindow(){

        Toolkit tkWindow = Toolkit.getDefaultToolkit();
        Dimension dimWindow = tkWindow.getScreenSize();

        int hWindow = dimWindow.height;
        int wWindow = dimWindow.width;

        this.setSize(wWindow/3,hWindow/2);
        this.setLocation(wWindow/3,hWindow/4);
        this.setTitle("Chat V0.1");

        ImageIcon chatIcon = new ImageIcon("Images\\chatIcon.jpg");
        this.setIconImage(chatIcon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        MyCanvas mainCanvas = new MyCanvas();

        add(mainCanvas);

        setVisible(true);
    }

}
