package Controller;

import Model.Polygone;
import Vue.FenetrePincipale;
import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
//la classe principale du programme. C'est le controleur central

public class Main {

    FenetrePincipale window;
    public static final String NOMFICHIERSERIALIZATION = "collection.out";

    public Main() {
        this.window = new FenetrePincipale(this);
    }

    /**
     * Ajoute une forme de typle polygone dans la liste du canvas
     *
     * @param poly
     */
    public void addForme(Polygone poly) {
        this.window.monJCanvas.addForme(poly);
    }

    /**
     * Permet de modifier une forme donnée de la liste du canvas
     *
     * @param poly
     * @param i
     */
    public void setForme(Polygone poly, int i) {
        this.window.monJCanvas.setForme(i, poly);
    }

    /**
     * Permet de montrer les coordonnées de la forme qui est activé
     *
     * @param p
     */
    public void activeElement(Polygone p) {
        this.window.setjTF_Point1_Text(null);
        this.window.setjTF_Point2_Text(null);
        this.window.setjTF_Point3_Text(null);
        this.window.setjTF_Point4_Text(null);
        for (int i = 0; i <= p.getNombreSommets() - 1; i++) {
            switch (i) {
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
    }

    /**
     * Permet d'afficher du texte dans la zone de texte de la vue
     *
     * @param text
     */
    public void displayText(String text) {
        this.window.affiche(text);
    }

    /**
     * Permet de changer le type de curseur de la souris
     *
     * @param typeCursor
     */
    public void changeCursor(int typeCursor) {
        this.window.setCursor(Cursor.getPredefinedCursor(typeCursor));
    }

    /**
     * Serialise la collection pour la sauvegarder
     */
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

    /**
     * Charge la collection précédement sauvegardé
     */
    public void chargement() {
        List collection = new LinkedList();
        try {
            FileInputStream in = new FileInputStream(new java.io.File("").getAbsolutePath() + Main.NOMFICHIERSERIALIZATION);
            ObjectInputStream ois = new ObjectInputStream(in);
            collection = (List) (ois.readObject());
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
        }
        this.window.monJCanvas.setCollection(collection);
    }
}
