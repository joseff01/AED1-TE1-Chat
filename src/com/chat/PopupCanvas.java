package com.chat;

import javax.swing.*;

public class PopupCanvas extends JPanel{

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

    private JTextArea IPText;

    public JTextArea getSocketText() {
        return SocketText;
    }

    private JTextArea SocketText;

    private DataPack dataPack;

    public void setTextMessage(String ChatText){

        Text = ChatText;

    }

    public String getTextMessage() {
        return Text;
    }

    private String Text;


}
