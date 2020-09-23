package com.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextCanvas extends JPanel{

    String MySocket;

    public TextCanvas(){

        this.setLayout(new BorderLayout());

        TextBox = new JTextArea();

        JScrollPane ScrollBox = new JScrollPane(TextBox);

        this.add(ScrollBox, BorderLayout.CENTER);
    }

    public void setMySocket(String mySocket) {

        MySocket = mySocket;

    }

    public void setFlagStateFalse() {

        popupWindow.setFlagStateFalse();

    }

    public DataPack getDataPack() {

        return popupWindow.getDataPack();

    }

    private JTextArea TextBox;

    public JTextArea getTextBox() {
        return TextBox;
    }

    public void setTextBox(JTextArea textBox) {
        TextBox = textBox;

    }


    private PopupWindow popupWindow;

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public void setPopupWindow(PopupWindow popupWindow) {
        this.popupWindow = popupWindow;
    }

    private JButton SendButton;

    public JButton getSendButton() {
        return SendButton;
    }

    public void setSendButton(JButton sendButton) {
        SendButton = sendButton;

        this.add(SendButton, BorderLayout.EAST);

    }


}
