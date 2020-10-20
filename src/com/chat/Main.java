package com.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Main Window creation

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

        MsgCanvas.setMenuCanvas(menuCanvas);

        cCanvas.setMsgCanvas(MsgCanvas);

        menuCanvas.setMessagesCanvas(MsgCanvas);

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

                PopupCanvas popupCanvas = new PopupCanvas();

                popupWindow.setPopupCanvas(popupCanvas);

                popupWindow.setText(tCanvas.getTextBox().getText());

                // Send Button in the popup window

                JButton PopupSendButton = new JButton("Send");
                PopupSendButton.setBounds(80,60,90,40);
                popupCanvas.add(PopupSendButton);

                class SendTextEvent implements ActionListener {

                    @Override
                    public void actionPerformed(ActionEvent i) {

                        try {

                            if (popupCanvas.getIPText().getText() == "127.0.0.1"){

                                log.error("The IP number must be 127.0.0.1 (Beta Version only works with multiple instances on the same computer)");

                            }

                            try{

                                Integer.parseInt(popupCanvas.getSocketText().getText());

                            } catch (NumberFormatException numberFormatException) {

                                log.error("The entered socket number must be an Integer",numberFormatException);
                                return;

                            }


                            if (Integer.parseInt(popupCanvas.getSocketText().getText()) < 10000) {

                                log.error("Entered socket number must be lower than 10000");
                                return;

                            }

                            Socket ClientSocket = new Socket(popupCanvas.getIPText().getText(), Integer.parseInt(popupCanvas.getSocketText().getText()));

                            DataPack dataPack = new DataPack();

                            dataPack.setMessage(popupCanvas.getTextMessage());

                            dataPack.setSenderIP(popupCanvas.getIPText().getText());

                            dataPack.setSenderSocket(String.valueOf(MsgCanvas.getListenSocket()));

                            dataPack.setReceiverSocket(popupCanvas.getSocketText().getText());

                            dataPack.setSideFlag(false);

                            ObjectOutputStream StreamOutput = new ObjectOutputStream(ClientSocket.getOutputStream());

                            StreamOutput.writeObject(dataPack);

                            StreamOutput.close();

                            JComponent component = (JComponent) i.getSource();
                            Window window = SwingUtilities.getWindowAncestor(component);
                            window.dispose();

                            menuCanvas.checkPrevConvSender(dataPack);


                        } catch (IOException ioException) {


                            log.error("oh oh");
                            System.out.println(ioException.getMessage());

                            JComponent component = (JComponent) i.getSource();
                            Window window = SwingUtilities.getWindowAncestor(component);
                            window.dispose();

                        }

                    }
                }

                SendTextEvent sendTextEvent = new SendTextEvent();

                PopupSendButton.addActionListener(sendTextEvent);



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
