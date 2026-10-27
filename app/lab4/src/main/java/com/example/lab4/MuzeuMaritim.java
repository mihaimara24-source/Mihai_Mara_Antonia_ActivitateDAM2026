package com.example.lab4;

import java.io.Serializable;

public class MuzeuMaritim implements Serializable {
    private String denumire;
    private int anInfiintare;
    private String categorieBilet;
    private boolean areGhid;

    public String getDenumire() { return denumire; }
    public void setDenumire(String denumire) { this.denumire = denumire; }

    public int getAnInfiintare() { return anInfiintare; }
    public void setAnInfiintare(int anInfiintare) { this.anInfiintare = anInfiintare; }

    public String getCategorieBilet() { return categorieBilet; }
    public void setCategorieBilet(String categorieBilet) { this.categorieBilet = categorieBilet; }

    public boolean isAreGhid() { return areGhid; }
    public void setAreGhid(boolean areGhid) { this.areGhid = areGhid; }

    @Override
    public String toString() {
        return "Muzeu: " + denumire + "\n" +
               "An: " + anInfiintare + "\n" +
               "Ghid: " + (areGhid ? "Da" : "Nu") + "\n" +
               "Categorie: " + categorieBilet;
    }
}