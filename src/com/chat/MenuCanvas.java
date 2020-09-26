package com.chat;

import javax.swing.*;

import java.awt.*;
import java.util.*;

public class MenuCanvas extends JPanel {

    int ListenSocket;

    DefaultListModel listModel;

    HashMap<String, Conversation> AllConversations = new HashMap<String, Conversation>();

    public MenuCanvas(){

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbCons = new GridBagConstraints();

        JMenuBar InfoBar = new JMenuBar();

        JMenu IpInfo = new JMenu("MyInfo");

        JMenuItem EmptySpace = new JMenu();

        JMenuItem IpItem = new JMenuItem("IP: 127.0.0.1");

        SocketItem = new JMenuItem("Socket: ");

        //InfoBar

        IpInfo.add(IpItem);
        IpInfo.add(SocketItem);

        InfoBar.add(IpInfo);

        gbCons.anchor = GridBagConstraints.NORTHWEST;
        gbCons.gridy = 0;
        gbCons.gridx = 0;
        gbCons.weightx = 1;
        gbCons.weighty = 1;

        this.add(InfoBar,gbCons);

        //ConvList

        listModel = new DefaultListModel();

        JList<String> ConvList = new JList<String>(listModel);

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

    public void setListenSocket(int listenSocket) {

        ListenSocket = listenSocket;
        SocketItem.setText("Socket: " + ListenSocket);

    }

    public void setConversation(MyConversation conversation){

        listModel.addElement("Ip: " + conversation.ConvIp + "/ Socket: " + conversation.ConvSocket );

    }

    public DefaultListModel getConversationList(){

        return listModel;

    }

    private JMenuItem SocketItem;

    public void checkPrevConvReceiver(DataPack dataPack) {

        if (listModel.contains("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket())){

            Conversation conversation = AllConversations.get("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket());

            conversation.addDataPack(dataPack);

            messagesCanvas.displayConversation(conversation);
        }

        else {

            listModel.addElement("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket());

            Conversation newConversation = new Conversation();

            AllConversations.put("Ip: " + dataPack.getSenderIP() + "/ Socket: " + dataPack.getSenderSocket(), newConversation);

            newConversation.addDataPack(dataPack);

            messagesCanvas.displayConversation(newConversation);
        }


    }

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


    MessagesCanvas messagesCanvas = new MessagesCanvas();

    public MessagesCanvas getMessagesCanvas() {
        return messagesCanvas;
    }

    public void setMessagesCanvas(MessagesCanvas messagesCanvas) {
        this.messagesCanvas = messagesCanvas;
    }

}
