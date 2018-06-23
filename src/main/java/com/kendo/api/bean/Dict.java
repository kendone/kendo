package com.kendo.api.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class Dict implements Serializable {

    private static final long serialVersionUID = 1527282338404702200L;
    private Integer value;
    private String text;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
