package com.chat;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextCanvas extends JPanel{

    public TextCanvas(){

        this.setLayout(new BorderLayout());

        TextBox = new JTextArea();

        TextBox.setLineWrap(true);
        JScrollPane ScrollBox = new JScrollPane(TextBox);

        JButton SendButton = new JButton("Send");
        SendText event = new SendText();

        SendButton.addActionListener(event);

        add(ScrollBox, BorderLayout.CENTER);
        add(SendButton, BorderLayout.EAST);


    }

    private class SendText implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(TextBox.getText());

        }
    }

    private JTextArea TextBox;

}
