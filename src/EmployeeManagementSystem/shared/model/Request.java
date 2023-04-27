package EmployeeManagementSystem.shared.model;

import java.io.Serializable;

public class Request implements Serializable
{
    private String type;
    private String object;

    public Request(String type, String object) {
        this.type = type;
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public String getObject() {
        return object;
    }
}
