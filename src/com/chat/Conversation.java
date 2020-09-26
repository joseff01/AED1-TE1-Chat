package com.chat;

import java.util.*;

public class Conversation {

    ArrayList<DataPack> DataPackList = new ArrayList<DataPack>();

    public ArrayList<DataPack> getDataPackList() {

        return DataPackList;

    }


    public Conversation(){

    }

    public void addDataPack(DataPack newDataPack){

        DataPackList.add(newDataPack);

    }
}
