package com.chat;

import javax.swing.*;

import java.awt.*;

public class MenuCanvas extends JPanel {

    int ListenSocket;

    public MenuCanvas(){


        this.setLayout(new GridBagLayout());

        GridBagConstraints gbCons = new GridBagConstraints();

        JMenuBar InfoBar = new JMenuBar();

        JMenu IpInfo = new JMenu("Info");

        JMenuItem EmptySpace = new JMenu();

        JMenuItem IpItem = new JMenuItem("IP: 127.0.0.1");

        SocketItem = new JMenuItem("Socket: ");

        IpInfo.add(IpItem);
        IpInfo.add(SocketItem);

        InfoBar.add(IpInfo);

        gbCons.anchor = GridBagConstraints.NORTHWEST;
        gbCons.weightx = 1;
        gbCons.weighty = 1;

        this.add(InfoBar,gbCons);






    }

    public void setListenSocket(int listenSocket) {

        ListenSocket = listenSocket;
        SocketItem.setText("Socket: " + ListenSocket);

    }

    private JMenuItem SocketItem;
}
