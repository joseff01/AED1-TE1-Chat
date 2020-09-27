package com.chat;

import javax.swing.*;

public class PopupWindow extends JFrame{

    String Text;

    public PopupWindow(){

        this.setSize(235,150);
        this.setLocation(50,50);
        this.setTitle("Send Message");

        ImageIcon chatIcon = new ImageIcon("Images\\chatIcon.jpg");
        this.setIconImage(chatIcon.getImage());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setResizable(false);

        setVisible(true);


    }

    public void setText(String ChatText){

        Text = ChatText;
        popupCanvas.setTextMessage(Text);

    }

    public void setPopupCanvas(PopupCanvas popupCanvas) {

        this.popupCanvas = popupCanvas;
        this.add(this.popupCanvas);

    }

    public PopupCanvas popupCanvas;
/*
    public boolean getFlagState(){

        return popupCanvas.getConvListFlag;

    }
*/


    public DataPack getDataPack() {

        return popupCanvas.getDataPack();

    }
}
