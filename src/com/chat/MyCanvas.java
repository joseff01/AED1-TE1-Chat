package com.chat;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel implements Runnable{

    public MyCanvas(){

        Thread ParallelThread = new Thread(this);

        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(1,2));


        // Messages Canvas, Left Side

        menuCanvas = new MenuCanvas();

        add(menuCanvas);


        // Chat Canvas, Right side
        cCanvas = new ChatCanvas();

        add(cCanvas);

        // Sending the Socket number to the menuCanvas, so it can be displayed
        menuCanvas.setListenSocket(cCanvas.getListenSocket());

        // Sending the Socket number to the chat so it can be sent
        cCanvas.setMySocket(String.valueOf(cCanvas.getListenSocket()));

        ParallelThread.start();


    }

    @Override
    public void run() {
        while (true) {
            try{
                if ((cCanvas.tCanvas.popupWindow.popupCanvas.getConvListFlag) == true) {
                    System.out.println("biatch, oh yeah");
                    DataPack dataPack = cCanvas.getDataPack();
                    cCanvas.setFlagStateFalse();

                    menuCanvas.checkPrevConv(dataPack);
                }

            } catch (Exception e) {
                continue;
            }
        }

    }
    private MenuCanvas menuCanvas;

    private ChatCanvas cCanvas;


}

