package com.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class TextCanvas extends JPanel{

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

             PopupWindow popupWindow = new PopupWindow();

             popupWindow.setText(TextBox.getText());



        }
    }

    private JTextArea TextBox;

}
