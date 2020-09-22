package com.chat;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        MyWindow mainWindow = new MyWindow();

        MyCanvas mainCanvas = new MyCanvas();

        mainWindow.add(mainCanvas);

        // Messages Canvas, Left Side

        MenuCanvas menuCanvas = new MenuCanvas();

        mainCanvas.add(menuCanvas);

        // Chat Canvas, Right side
        ChatCanvas cCanvas = new ChatCanvas();

        mainCanvas.add(cCanvas);










    }
}
