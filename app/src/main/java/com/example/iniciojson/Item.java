package com.example.iniciojson;

public class Item {

    private int icon;
    private String title;
    private Item(String dad){
        super();
    }

    public Item(int icon, String title){
        super();
        this.icon=icon;
        this.title=title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
