package com.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Observable;

public class PopupCanvas extends JPanel{

    DefaultListModel ConvList;

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

    }

    public DataPack getDataPack() {

        return dataPack;

    }

    public JTextArea getIPText() {
        return IPText;
    }

    public void setIPText(JTextArea IPText) {
        this.IPText = IPText;
    }

    private JTextArea IPText;

    public JTextArea getSocketText() {
        return SocketText;
    }

    public void setSocketText(JTextArea socketText) {
        SocketText = socketText;
    }

    private JTextArea SocketText;

    public void setDataPack(DataPack dataPack) {
        this.dataPack = dataPack;
    }

    private DataPack dataPack;

    public JButton getPopupSendButton() {
        return PopupSendButton;
    }

    public void setPopupSendButton(JButton popupSendButton) {
        PopupSendButton = popupSendButton;
    }

    private JButton PopupSendButton;

    public void setMySocket(String mySocket) {

        MySocket = mySocket;

    }

    public String getMySocket() {
        return MySocket;
    }

    private String MySocket;

    public void setTextMessage(String ChatText){

        Text = ChatText;

    }

    public String getTextMessage() {
        return Text;
    }

    private String Text;


}
