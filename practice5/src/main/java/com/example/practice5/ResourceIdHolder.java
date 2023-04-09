package com.example.practice5;

public class ResourceIdHolder {
    private int id;

    public ResourceIdHolder(int id) {
        this.id = id;
    }

    public ResourceIdHolder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResourceIdHolder{" +
                "id=" + id +
                '}';
    }
}
