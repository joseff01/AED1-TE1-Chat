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
        SendText event = new SendText();

        SendButton.addActionListener(event);

        add(ScrollBox, BorderLayout.CENTER);
        add(SendButton, BorderLayout.EAST);


    }

    private class SendText implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Socket ClientSocket = new Socket("127.0.0.1", 10000);

                DataOutputStream StreamOutput = new DataOutputStream(ClientSocket.getOutputStream());

                StreamOutput.writeUTF(TextBox.getText());

                StreamOutput.close();

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());;
            }

        }
    }

    private JTextArea TextBox;

}
