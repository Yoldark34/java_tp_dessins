package Controller;

import Model.Polygone;
import Model.Quadrilatere;
import Vue.FenetrePincipale;
import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class Main {

    FenetrePincipale window;
    public static final String NOMFICHIERSERIALIZATION = "collection.out";

    public void addForme(Quadrilatere quad) {
        this.window.monJCanvas.addForme(quad);
    }

    public void setForme(Quadrilatere quad, int i) {
        this.window.monJCanvas.setForme(i, quad);
    }

    public void activeElement(Polygone p) {
        this.window.setjTF_Point1_Text(null);
        this.window.setjTF_Point2_Text(null);
        this.window.setjTF_Point3_Text(null);
        this.window.setjTF_Point4_Text(null);
        for (int i = 0; i <= p.getNombreSommets() - 1; i++) {
            switch (i)
            {
                case 0:
                    this.window.setjTF_Point1_Text(p.getSommetString(i));
                    break;
                case 1:
                    this.window.setjTF_Point2_Text(p.getSommetString(i));
                    break;
                case 2:
                    this.window.setjTF_Point3_Text(p.getSommetString(i));
                    break;
                case 3:
                    this.window.setjTF_Point4_Text(p.getSommetString(i));
                    break;
            }
        }

        //this.window.affiche(p.toString());
    }

    public void displayText(String text) {
        this.window.affiche(text);
    }

    public void changeCursor(int typeCursor) {
        this.window.setCursor(Cursor.getPredefinedCursor(typeCursor));
    }

    public Main() {
        this.window = new FenetrePincipale(this);
    }

    public void sauvegarde() {
        List collection = this.window.monJCanvas.getCollection();
        try {
            FileOutputStream out = new FileOutputStream(new java.io.File("").getAbsolutePath() + Main.NOMFICHIERSERIALIZATION);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(collection);
            oos.flush();
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
        }
    }

    public void chargement() {
        List collection = new LinkedList();
        try {
            FileInputStream in = new FileInputStream(new java.io.File("").getAbsolutePath() + Main.NOMFICHIERSERIALIZATION);
            ObjectInputStream ois = new ObjectInputStream(in);
            collection = (List) (ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Problem serializing: " + e);
        }
        this.window.monJCanvas.setCollection(collection);
    }
}
