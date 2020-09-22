package com.chat;

import javax.swing.*;

public class PopupWindow extends JFrame{

    String Text;

    public PopupWindow(){

        this.setSize(235,130);
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

    public void setMySocket(String mySocket) {

        popupCanvas.setMySocket(mySocket);

    }

    public PopupCanvas popupCanvas;
/*
    public boolean getFlagState(){

        return popupCanvas.getConvListFlag;

    }
*/
    public void setFlagStateFalse() {

        popupCanvas.setFlagStateFalse();

    }

    public DataPack getDataPack() {

        return popupCanvas.getDataPack();

    }
}
