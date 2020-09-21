package com.chat;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class PopupWindow extends JFrame{

    String Text;

    public PopupWindow(){

        this.setSize(150,150);
        this.setLocation(50,50);
        this.setTitle("Send Message");

        ImageIcon chatIcon = new ImageIcon("Images\\chatIcon.jpg");
        this.setIconImage(chatIcon.getImage());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setResizable(false);

        popupCanvas = new PopupCanvas();

        add(popupCanvas);

        setVisible(true);


    }

    public void setText(String ChatText){

        Text = ChatText;
        popupCanvas.setText(Text);

    }

    private PopupCanvas popupCanvas;


}
