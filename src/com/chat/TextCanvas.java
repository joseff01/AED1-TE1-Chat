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

        TextBox.setLineWrap(true);
        JScrollPane ScrollBox = new JScrollPane(TextBox);

        JButton SendButton = new JButton("Send");
        CreatePopup PopupEvent = new CreatePopup();

        SendButton.addActionListener(PopupEvent);

        this.add(ScrollBox, BorderLayout.CENTER);
        this.add(SendButton, BorderLayout.EAST);


    }

    private class CreatePopup implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            popupWindow = new PopupWindow();

            popupWindow.setText(TextBox.getText());

            popupWindow.setMySocket(MySocket);


        }
    }

    public void setMySocket(String mySocket) {

        MySocket = mySocket;

    }

    private JTextArea TextBox;


    public void setFlagStateFalse() {

        popupWindow.setFlagStateFalse();

    }

    public DataPack getDataPack() {

        return popupWindow.getDataPack();

    }

    public PopupWindow popupWindow;
}
