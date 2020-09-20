package com.chat;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.awt.*;

public class MessagesCanvas extends JPanel implements Runnable{

    public MessagesCanvas(){

        this.setBackground(Color.ORANGE);

        this.setLayout(new GridLayout(8,2,5,5));

        MessageBox = new JLabel();

        this.setPreferredSize(new Dimension(420,135));

        add(MessageBox);

        Thread ParallelThread = new Thread(this);

        ParallelThread.start();

    }

    @Override
    public void run() {

        try {

            ServerSocket ListenSocket = new ServerSocket(10000);

            while(true) {

                Socket EntrySocket = ListenSocket.accept();

                DataInputStream StreamInput = new DataInputStream(EntrySocket.getInputStream());

                String EntryMessage = StreamInput.readUTF();

                MessageBox.setText("\n" + EntryMessage);

                EntrySocket.close();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    private JLabel MessageBox;
}
