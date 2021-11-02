package org.example.search;

public class MyObjForWidthSearch {
    private String name;
    private boolean status;
    private MyObjForWidthSearch[] subArray;

    public MyObjForWidthSearch(String name, boolean status, MyObjForWidthSearch[] subArray) {
        this.name = name;
        this.status = status;
        this.subArray = subArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MyObjForWidthSearch[] getSubArray() {
        return subArray;
    }

    public void setSubArray(MyObjForWidthSearch[] subArray) {
        this.subArray = subArray;
    }
}
