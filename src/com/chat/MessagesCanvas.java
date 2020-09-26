package com.chat;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.awt.*;
import java.util.ArrayList;

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

                dataPackReceived.setSideFlag(true);

                menuCanvas.checkPrevConvReceiver(dataPackReceived);

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

    private MenuCanvas menuCanvas;

    public MenuCanvas getMenuCanvas() {
        return menuCanvas;
    }

    public void setMenuCanvas(MenuCanvas menuCanvas) {
        this.menuCanvas = menuCanvas;
    }

    public void displayConversation(Conversation conversation) {

        this.removeAll();

        ArrayList<DataPack> DataPackList = conversation.getDataPackList();

        int YPosition = 0;

        for (int i = 0; i < DataPackList.size(); i++){

            DataPack dataPack = DataPackList.get(i);

            MessageBox = new JTextArea();

            MessageBox.setEditable(false);

            MessageBox.setLineWrap(true);

            MessageBox.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

            if (dataPack.isSideFlag()) {

                MessageBox.setText("Ip: " + dataPack.getSenderIP() +  "/ Socket: " + dataPack.getSenderSocket() + "\n" + dataPack.getMessage());

            } else {

                MessageBox.setText("Ip: " + dataPack.getSenderIP() +  "/ Socket: " + dataPack.getReceiverSocket() + "\n" + dataPack.getMessage());

            }

            JScrollPane jScrollPane = new JScrollPane(MessageBox);

            if (dataPack.isSideFlag()) {

                jScrollPane.setBounds(0,YPosition,350,75);

            } else {

                jScrollPane.setBounds(65,YPosition,350,75);

            }

            YPosition = YPosition + 75;

            this.add(jScrollPane);

        }

        this.validate();
        this.repaint();

    }
}
