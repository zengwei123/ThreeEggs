package com.example.z_home.Model;

import java.util.List;

public class CategoryList {
    private String Parent;
    private List<String> Child;

    public CategoryList(String parent, List<String> child) {
        Parent = parent;
        Child = child;
    }

    public String getParent() {
        return Parent;
    }

    public void setParent(String parent) {
        Parent = parent;
    }

    public List<String> getChild() {
        return Child;
    }

    public void setChild(List<String> child) {
        Child = child;
    }
}
