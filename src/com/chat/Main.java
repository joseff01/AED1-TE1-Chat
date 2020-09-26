package com.chat;

import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

        MsgCanvas.setMenuCanvas(menuCanvas);

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

                PopupCanvas popupCanvas = new PopupCanvas();

                popupWindow.setPopupCanvas(popupCanvas);

                popupWindow.setText(tCanvas.getTextBox().getText());

                JButton PopupSendButton = new JButton("Send");
                PopupSendButton.setBounds(80,60,90,40);
                popupCanvas.add(PopupSendButton);

                class SendTextEvent implements ActionListener {

                    @Override
                    public void actionPerformed(ActionEvent i) {

                        try {

                            Socket ClientSocket = new Socket(popupCanvas.getIPText().getText(), Integer.parseInt(popupCanvas.getSocketText().getText()));

                            DataPack dataPack = new DataPack();

                            dataPack.setMessage(popupCanvas.getTextMessage());

                            dataPack.setSenderIP(popupCanvas.getIPText().getText());

                            dataPack.setSenderSocket(String.valueOf(MsgCanvas.getListenSocket()));

                            dataPack.setReceiverSocket(popupCanvas.getSocketText().getText());

                            ObjectOutputStream StreamOutput = new ObjectOutputStream(ClientSocket.getOutputStream());

                            StreamOutput.writeObject(dataPack);

                            StreamOutput.close();

                            JComponent component = (JComponent) i.getSource();
                            Window window = SwingUtilities.getWindowAncestor(component);
                            window.dispose();

                            menuCanvas.checkPrevConvSender(dataPack);

                            JTextArea MessageBox = new JTextArea();

                            MessageBox.setEditable(false);

                            MessageBox.setLineWrap(true);

                            MessageBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                            MessageBox.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

                            MessageBox.setText("Ip: " + popupCanvas.getIPText().getText() +  "/ Socket: " + MsgCanvas.getListenSocket() + "\n" + popupCanvas.getTextMessage());

                            JScrollPane jScrollPane = new JScrollPane(MessageBox);
                            jScrollPane.setBounds(65,MsgCanvas.YPosition,350,75);

                            MsgCanvas.YPosition = MsgCanvas.YPosition + 75;

                            MsgCanvas.add(jScrollPane);

                            MsgCanvas.validate();
                            MsgCanvas.repaint();




                        } catch (IOException ioException) {

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
