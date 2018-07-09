package com.kendo.admin.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kendone
 */
public class MenuWindows extends MenuWindow {
    private static final long serialVersionUID = -339999134691329994L;

    private List<MenuWindows> items = new ArrayList<>();

    public List<MenuWindows> getItems() {
        return items;
    }

    public void setItems(List<MenuWindows> items) {
        this.items = items;
    }
}
