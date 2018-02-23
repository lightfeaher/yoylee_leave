package com.qihang.model;

public class User2 {
    private int id;
    private String name;
    private String password;
    private String right;
    private String system;

    public User2(){}

    public User2(int id, String name, String password, String right, String system) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.right = right;
        this.system = system;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", right='" + right + '\'' +
                ", system='" + system + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
