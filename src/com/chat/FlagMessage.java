package com.chat;

import java.util.Observable;

public class FlagMessage extends Observable {

    public boolean isGetConvListFlag() {
        return getConvListFlag;
    }

    public void setGetConvListFlag(boolean getConvListFlag) {
        this.getConvListFlag = getConvListFlag;
        if (getConvListFlag){
            System.out.println("Oh yeah mr crabs");
            setChanged();
            notifyObservers();
        }
    }

    private boolean getConvListFlag = false;



}
