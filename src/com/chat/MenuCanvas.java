package com.chat;

import javax.swing.*;

import java.awt.*;

public class MenuCanvas extends JPanel {

    public MenuCanvas(){

        this.setBackground(Color.RED);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbCons = new GridBagConstraints();

        JMenuBar InfoBar = new JMenuBar();

        JMenu IpInfo = new JMenu("Info");

        JMenuItem IpItem = new JMenuItem("IP: 127.0.0.1");
        JMenuItem SocketItem = new JMenuItem("Socket:");

        IpInfo.add(IpItem);
        IpInfo.add(SocketItem);

        InfoBar.add(IpInfo);

        gbCons.anchor = GridBagConstraints.NORTHWEST;
        gbCons.weightx = 1;
        gbCons.weighty = 1;

        this.add(InfoBar,gbCons);





    }

}
