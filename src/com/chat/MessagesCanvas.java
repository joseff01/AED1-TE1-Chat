package com.chat;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.awt.*;

public class MessagesCanvas extends JPanel implements Runnable{

    int ListenSocketNum = 10000;

    public MessagesCanvas(){

        this.setBackground(Color.ORANGE);

        this.setLayout(new GridLayout(8,2,5,5));

        MessageBox = new JLabel();

        this.setPreferredSize(new Dimension(420,135));

        add(MessageBox);

        Thread ParallelThread = new Thread(this);

        ParallelThread.start();

    }

    public int getListenSocket(){

        return ListenSocketNum;

    }


    @Override
    public void run() {

        try {

            ServerSocket ListenSocket = new ServerSocket(ListenSocketNum);

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
