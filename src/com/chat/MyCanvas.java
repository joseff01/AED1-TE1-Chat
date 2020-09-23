package com.chat;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel {

    public MyCanvas(){

        this.setLayout(new GridLayout(1,2));

    }

    public void setSockets(){

        menuCanvas.setListenSocket(cCanvas.getListenSocket());

        cCanvas.setMySocket(String.valueOf(cCanvas.getListenSocket()));


    }

    private MenuCanvas menuCanvas;

    private ChatCanvas cCanvas;

    public MenuCanvas getMenuCanvas() {
        return menuCanvas;
    }

    public void setMenuCanvas(MenuCanvas menuCanvas) {
        this.menuCanvas = menuCanvas;
    }

    public ChatCanvas getcCanvas() {
        return cCanvas;
    }

    public void setcCanvas(ChatCanvas cCanvas) {
        this.cCanvas = cCanvas;
    }


}

