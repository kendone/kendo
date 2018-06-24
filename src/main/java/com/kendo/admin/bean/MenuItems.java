package com.kendo.admin.bean;

import java.util.ArrayList;
import java.util.List;

public class MenuItems extends MenuItem {

    private static final long serialVersionUID = -339999134691329994L;
    private List<MenuItems> items = new ArrayList<>();

    public List<MenuItems> getItems() {
        return items;
    }

    public void setItems(List<MenuItems> items) {
        this.items = items;
    }
}
