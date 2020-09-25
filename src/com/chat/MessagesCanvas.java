package com.chat;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.awt.*;

public class MessagesCanvas extends JPanel implements Runnable{

    int ListenSocketNum = 10000;

    byte RowLevel = 0;

    int YPosition = 0;

    public MessagesCanvas(){

        Thread ParallelThread = new Thread(this);

        this.setLayout(null);

        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        ParallelThread.start();


    }

    public int getListenSocket(){

        return ListenSocketNum;

    }


    @Override
    public void run() {

        try {

            ServerSocket ListenSocket = new ServerSocket(ListenSocketNum);

            String SenderIP, Message, SenderSocket;

            DataPack dataPackReceived;

            while(true) {

                Socket EntrySocket = ListenSocket.accept();

                ObjectInputStream StreamInput = new ObjectInputStream(EntrySocket.getInputStream());

                dataPackReceived = (DataPack) StreamInput.readObject();

                SenderIP = dataPackReceived.getSenderIP();
                Message = dataPackReceived.getMessage();
                SenderSocket = dataPackReceived.getSenderSocket();


                MessageBox = new JTextArea();

                MessageBox.setEditable(false);

                MessageBox.setLineWrap(true);

                MessageBox.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

                MessageBox.setText("Ip: " + SenderIP +  "/ Socket: " + SenderSocket + "\n" + Message);

                JScrollPane jScrollPane = new JScrollPane(MessageBox);
                jScrollPane.setBounds(0,YPosition,350,75);

                YPosition = YPosition + 300;

                getParent().validate();

                this.add(jScrollPane);

                this.validate();
                this.repaint();

                EntrySocket.close();


            }

        } catch (IOException | ClassNotFoundException e) {

            if (ListenSocketNum < 20000){

                ListenSocketNum++;
                run();

            }
            else{

                e.printStackTrace();

            }

        }


    }

    private JTextArea MessageBox;

}
