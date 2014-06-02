package inlämningsuppgift2;

import java.util.ArrayList;

abstract public class Prylar {

    private String namn;
    protected double värde;

    abstract public double värde();

    Prylar(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public double getVärde() {
        return värde;
    }
}
