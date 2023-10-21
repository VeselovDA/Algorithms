package org.example.search;

public class BreadthFirstNode {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BreadthFirstNode that = (BreadthFirstNode) o;

        if (i != that.i) return false;
        if (j != that.j) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + i;
        result = 31 * result + j;
        return result;
    }

    private Integer value;
    private int i;
    private int j;

    public BreadthFirstNode(Integer value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
