package com.example.iniciojson;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Items {

    private ArrayList<Item> itemsList;

    public Items() {
        this.itemsList = new ArrayList<>();
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public String toJSON(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Items fromJSON(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Items.class);
    }

    public void addItem(Item item) {
        itemsList.add(item);
    }

    public void removeItem(Item item) {
        itemsList.remove(item);
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemsList=" + itemsList +
                '}';
    }
}
