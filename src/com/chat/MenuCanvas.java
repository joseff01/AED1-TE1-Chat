package com.chat;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.util.*;

public class MenuCanvas extends JPanel {

    private DefaultListModel listModel;

    private JList<String> ConvList;

    //Hash map that connects the strings of the Jlist with the corresponding conversation
    private HashMap<String, Conversation> AllConversations = new HashMap<String, Conversation>();

    private JMenuItem SocketItem;

    public MenuCanvas(){

        //Basic Config

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbCons = new GridBagConstraints();

        JMenuBar InfoBar = new JMenuBar();

        JMenu IpInfo = new JMenu("MyInfo");

        JMenuItem EmptySpace = new JMenu();

        JMenuItem IpItem = new JMenuItem("IP: 127.0.0.1");

        SocketItem = new JMenuItem("Socket: ");

        //InfoBar with ip and socket

        IpInfo.add(IpItem);
        IpInfo.add(SocketItem);

        InfoBar.add(IpInfo);

        gbCons.anchor = GridBagConstraints.NORTHWEST;
        gbCons.gridy = 0;
        gbCons.gridx = 0;
        gbCons.weightx = 1;
        gbCons.weighty = 1;

        this.add(InfoBar,gbCons);

        //ConvList with all conversations

        listModel = new DefaultListModel();

        ConvList = new JList<String>(listModel);

        ConvList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                String SelectedElement = ConvList.getSelectedValue();

                Conversation conversation = AllConversations.get(SelectedElement);

                messagesCanvas.displayConversation(conversation);

            }
        });

        ConvList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(ConvList);

        gbCons.anchor = GridBagConstraints.SOUTH;
        gbCons.gridy = 1;
        gbCons.gridx = 0;
        gbCons.weightx = 1;
        gbCons.weighty = 400;
        gbCons.fill = GridBagConstraints.BOTH;

        this.add(listScrollPane,gbCons);


    }


    //Checks if the RECEIVED message comes from someone with an ongoing conversation,
    // to see if it needs to create a new one

    public void checkPrevConvReceiver(DataPack dataPack) {

        if (listModel.contains("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket())){

            if (Integer.parseInt(dataPack.getSenderSocket()) != ListenSocket) {

                Conversation conversation = AllConversations.get("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket());

                conversation.addDataPack(dataPack);

                messagesCanvas.displayConversation(conversation);
            }

        }

        else {

            if (Integer.parseInt(dataPack.getSenderSocket()) != ListenSocket) {

                listModel.addElement("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket());

                Conversation newConversation = new Conversation();

                AllConversations.put("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket(), newConversation);

                newConversation.addDataPack(dataPack);

                messagesCanvas.displayConversation(newConversation);

            }
        }


    }


    //Checks if the SENT message comes from someone with an ongoing conversation,
    // to see if it needs to create a new one

    public void checkPrevConvSender(DataPack dataPack) {

        if (listModel.contains("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getReceiverSocket())){

            Conversation conversation = AllConversations.get("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getReceiverSocket());

            conversation.addDataPack(dataPack);

            messagesCanvas.displayConversation(conversation);
        }

        else{

            listModel.addElement("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getReceiverSocket());

            Conversation newConversation = new Conversation();

            AllConversations.put("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getReceiverSocket(), newConversation);

            newConversation.addDataPack(dataPack);

            messagesCanvas.displayConversation(newConversation);

        }


    }


    MessagesCanvas messagesCanvas;


    public void setMessagesCanvas(MessagesCanvas messagesCanvas) {
        this.messagesCanvas = messagesCanvas;
    }

    int ListenSocket;

    public void setListenSocket(int listenSocket) {

        ListenSocket = listenSocket;
        SocketItem.setText("Socket: " + ListenSocket);

    }

}
