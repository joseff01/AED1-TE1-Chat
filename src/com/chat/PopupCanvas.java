package com.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class PopupCanvas extends JPanel{

    String Text;

    public PopupCanvas(){

        this.setLayout(null);

        JLabel IPLabel = new JLabel("Ip:");
        IPLabel.setBounds(5,5,50,20);
        this.add(IPLabel);

        JLabel SocketLabel = new JLabel("Socket:");
        SocketLabel.setBounds(5,27,50,20);
        this.add(SocketLabel);

        IPText = new JTextArea();
        IPText.setBounds(55,5,175,20);
        this.add(IPText);

        SocketText = new JTextArea();
        SocketText.setBounds(55,27,175,20);
        this.add(SocketText);

        JButton PopupSendButton = new JButton("Send");
        PopupSendButton.setBounds(80,60,90,40);
        this.add(PopupSendButton);

        SendTextEvent sendTextEvent = new SendTextEvent();

        PopupSendButton.addActionListener(sendTextEvent);

    }

    private class SendTextEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Socket ClientSocket = new Socket(IPText.getText(), Integer.parseInt(SocketText.getText()));

                DataPack dataPack = new DataPack();

                dataPack.setMessage(Text);

                dataPack.setSenderIP(IPText.getText());

                dataPack.setSenderSocket(SocketText.getText());

                ObjectOutputStream StreamOutput = new ObjectOutputStream(ClientSocket.getOutputStream());

                StreamOutput.writeObject(dataPack);

                StreamOutput.close();

                JComponent component = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(component);
                window.dispose();


            } catch (IOException ioException) {

                System.out.println(ioException.getMessage());

                JComponent component = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(component);
                window.dispose();

            }

        }
    }

    public void setText(String ChatText){

        Text = ChatText;

    }

    private JTextArea IPText;
    private JTextArea SocketText;

}