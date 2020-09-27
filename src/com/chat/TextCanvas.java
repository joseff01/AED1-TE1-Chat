package com.chat;

import javax.swing.*;
import java.awt.*;



public class TextCanvas extends JPanel{

    String MySocket;

    public TextCanvas(){

        //Basic Config

        this.setLayout(new BorderLayout());

        TextBox = new JTextArea();

        TextBox.setLineWrap(true);

        JScrollPane ScrollBox = new JScrollPane(TextBox);

        this.add(ScrollBox, BorderLayout.CENTER);
    }

    public void setMySocket(String mySocket) {

        MySocket = mySocket;

    }

    public DataPack getDataPack() {

        return popupWindow.getDataPack();

    }

    private JTextArea TextBox;

    public JTextArea getTextBox() {
        return TextBox;
    }

    private PopupWindow popupWindow;

    private JButton SendButton;


    public void setSendButton(JButton sendButton) {
        SendButton = sendButton;

        this.add(SendButton, BorderLayout.EAST);

    }


}
