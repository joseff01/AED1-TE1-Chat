package com.chat;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;

public class MessagesCanvas extends JPanel implements Runnable{

    int ListenSocketNum = 10000;

    public MessagesCanvas(){

        //Creation of thread for the while loop that constantly checks if there is a new message from someone

        Thread ParallelThread = new Thread(this);

        this.setLayout(null);

        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        ParallelThread.start();


    }

    public int getListenSocket(){

        return ListenSocketNum;

    }


    //Thread with the while loop that receives incoming messages:

    @Override
    public void run() {

        try {

            //Sets the socket that will receive the messages
            ServerSocket ListenSocket = new ServerSocket(ListenSocketNum);

            DataPack dataPackReceived;

            while(true) {

                //Receives the messages:
                Socket EntrySocket = ListenSocket.accept();

                ObjectInputStream StreamInput = new ObjectInputStream(EntrySocket.getInputStream());

                dataPackReceived = (DataPack) StreamInput.readObject();

                dataPackReceived.setSideFlag(true);

                //Sends the message to the menuCanvas,
                //so it can check if there already exist a conversation with that socket
                menuCanvas.checkPrevConvReceiver(dataPackReceived);

                EntrySocket.close();


            }

        } catch (IOException | ClassNotFoundException e) {

            if (ListenSocketNum < 20000){

                //if the set socket is invalid, it will try for a different value.
                ListenSocketNum++;
                run();

            }
            else{
                //if it doesn't find a valid socket, it prints an error
                e.printStackTrace();

            }

        }


    }

    private JTextArea MessageBox;

    private MenuCanvas menuCanvas;

    public void setMenuCanvas(MenuCanvas menuCanvas) {
        this.menuCanvas = menuCanvas;
    }

    //Displays the entered conversation:
    public void displayConversation(Conversation conversation) {

        this.removeAll();

        //Gets a list of all messages in the conversation
        ArrayList<DataPack> DataPackList = conversation.getDataPackList();

        //Y position of the message
        int YPosition = 0;

        //for loop that displays all messages
        for (DataPack dataPack : DataPackList) {

            MessageBox = new JTextArea();

            MessageBox.setEditable(false);

            MessageBox.setLineWrap(true);

            MessageBox.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

            JScrollPane jScrollPane = new JScrollPane(MessageBox);

            //check if the message is from the receiver or the sender, and display it so
            if (dataPack.isSideFlag()) {

                MessageBox.setText("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket() + "\n" + dataPack.getMessage());
                jScrollPane.setBounds(0, YPosition, 350, 75);

            } else {

                MessageBox.setText("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket() + "\n" + dataPack.getMessage());
                jScrollPane.setBounds(65, YPosition, 350, 75);

            }

            //So the next message is displayed on the next row
            YPosition = YPosition + 75;

            this.add(jScrollPane);

        }

        //Repainted and validated so it's displayed correctly to the user
        this.validate();
        this.repaint();

    }
}
