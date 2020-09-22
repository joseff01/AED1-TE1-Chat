package com.chat;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel {

    public MyCanvas(){

        this.setLayout(new GridLayout(1,2));

        menuCanvas.setListenSocket(cCanvas.getListenSocket());

        // Sending the Socket number to the chat so it can be sent
        cCanvas.setMySocket(String.valueOf(cCanvas.getListenSocket()));

    }

    private MenuCanvas menuCanvas;

    private ChatCanvas cCanvas;


}

