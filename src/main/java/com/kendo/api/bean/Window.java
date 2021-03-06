package com.kendo.api.bean;

import java.io.Serializable;

/**
 * @author kendone
 */
public class Window implements Serializable {
    private static final long serialVersionUID = -8066676593205791946L;

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
