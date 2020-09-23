package com.chat;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        MyWindow mainWindow = new MyWindow();

        MyCanvas mainCanvas = new MyCanvas();

        mainWindow.add(mainCanvas);

        // Messages Canvas, Left Side

        MenuCanvas menuCanvas = new MenuCanvas();

        mainCanvas.setMenuCanvas(menuCanvas);

        mainCanvas.add(menuCanvas);

        // Chat Canvas, Right side

        ChatCanvas cCanvas = new ChatCanvas();

        mainCanvas.setcCanvas(cCanvas);

        mainCanvas.add(cCanvas);

        //MessagesCanvas in ChatCanvas

        MessagesCanvas MsgCanvas = new MessagesCanvas();

        cCanvas.setMsgCanvas(MsgCanvas);

        //tCanvas in ChatCanvas

        TextCanvas tCanvas = new TextCanvas();

        cCanvas.settCanvas(tCanvas);

        //SendButton in tCanvas
        JButton SendButton = new JButton("Send");

        //Button ActionListener and popup creation
        class CreatePopup implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                PopupWindow popupWindow = new PopupWindow();

                popupWindow.setText(tCanvas.getTextBox().getText());

            }
        }

        CreatePopup PopupEvent = new CreatePopup();
        SendButton.addActionListener(PopupEvent);

        tCanvas.setSendButton(SendButton);



        // So main Canvas updates:
        mainCanvas.validate();
        mainCanvas.repaint();


        // Sets the sockets everywhere
        mainCanvas.setSockets();











    }
}
