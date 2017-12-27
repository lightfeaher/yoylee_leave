package com.qihang.model;

public class System {
    private int id;
    private String system;

    public System(){}
    public System(int id, String system) {
        this.id = id;
        this.system = system;
    }

    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", system='" + system + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
