package Controller;

import Interface.IDrawable;
import Model.Carre;
import Model.CerfVolant;
import Model.Losange;
import Model.Parallelogramme;
import Model.Polygone;
import Model.Quelconque;
import Model.Rectangle;
import Model.Trapeze;
import Vue.FenetrePincipale;
import java.awt.Cursor;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * la classe principale du programme. C'est le controleur central
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
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
        this.window.getMonJCanvas().addForme(poly);
    }

    /**
     * Permet de modifier une forme donnée de la liste du canvas
     *
     * @param poly
     * @param i
     */
    public void setForme(Polygone poly, int i) {
        this.window.getMonJCanvas().setForme(i, poly);
    }

    /**
     * Permet de montrer les coordonnées de la forme qui est activé
     *
     * @param p
     */
    public void activeElement(Polygone p) {
        this.displayText(p.toString() + "\n\n");//Affichera toujours le dernier élément selectionné dans la liste !
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
     * Permet de vider les textboxs
     */
    public void desactiveElement() {
        int selected[] = this.window.getJl_Polygones().getSelectedIndices();
        if (selected.length == 0) {
            this.window.setjTF_Point1_Text("");
            this.window.setjTF_Point2_Text("");
            this.window.setjTF_Point3_Text("");
            this.window.setjTF_Point4_Text("");
            this.window.affiche("");
        } else {
            this.activeElement(this.window.getMonJCanvas().getCollection().get(selected[selected.length - 1]));
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
        List collection = this.window.getMonJCanvas().getCollection();
        try {
            FileOutputStream out = new FileOutputStream(Main.NOMFICHIERSERIALIZATION);
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
            FileInputStream in = new FileInputStream(Main.NOMFICHIERSERIALIZATION);
            ObjectInputStream ois = new ObjectInputStream(in);
            collection = (List) (ois.readObject());
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
        }
        this.window.getMonJCanvas().setCollection(collection);
        this.rafraichitListePolygones();
    }

    public void rafraichitListePolygones() {
        List collection = this.window.getMonJCanvas().getCollection();
        DefaultListModel model = new DefaultListModel();
        for (Iterator iter = collection.iterator(); iter.hasNext();) {
            Polygone poly = (Polygone) iter.next();
            String name = poly.getType();
            model.addElement(name);
        }
        this.window.jl_PolygonesSetModel(model);
    }

    public void valider() {
        int selected[] = this.window.getJl_Polygones().getSelectedIndices();
        List<Point> points = new LinkedList<Point>();
        for (int i = 0; i < 4; i++) {
            String[] splited = null;
            int x = -1;
            int y = -1;
            switch (i) {
                case 0:
                    if (null != this.window.getjTF_Point1_Text()) {
                        splited = this.window.getjTF_Point1_Text().split(",");
                        if (splited.length > 1) {
                            x = Integer.parseInt(splited[0]);
                            y = Integer.parseInt(splited[1]);
                            points.add(new Point(x, y));
                        }
                    }
                    break;
                case 1:
                    if (null != this.window.getjTF_Point2_Text()) {
                        splited = this.window.getjTF_Point2_Text().split(",");
                        if (splited.length > 1) {
                            x = Integer.parseInt(splited[0]);
                            y = Integer.parseInt(splited[1]);
                            points.add(new Point(x, y));
                        }
                    }
                    break;
                case 2:
                    if (null != this.window.getjTF_Point3_Text()) {
                        splited = this.window.getjTF_Point3_Text().split(",");
                        if (splited.length > 1) {
                            x = Integer.parseInt(splited[0]);
                            y = Integer.parseInt(splited[1]);
                            points.add(new Point(x, y));
                        }
                    }
                    break;
                case 3:
                    if (null != this.window.getjTF_Point4_Text()) {
                        splited = this.window.getjTF_Point4_Text().split(",");
                        if (splited.length > 1) {
                            x = Integer.parseInt(splited[0]);
                            y = Integer.parseInt(splited[1]);
                            points.add(new Point(x, y));
                        }
                    }

                    break;
            }
        }

        if (selected.length != 0) {
            Boolean erreur = true;
            Polygone polyg = this.window.getMonJCanvas().getCollection().get(selected[selected.length - 1]);
            Polygone poly = null;
            if (polyg.getType().equals(Carre.class.toString().toLowerCase().substring(12))) {
                poly = new Carre(points.get(0),points.get(1),points.get(2),points.get(3));
                if (poly.estCorrect()) {
                    erreur = false;
                }
            } else if (polyg.getType().equals(Rectangle.class.toString().toLowerCase().substring(12))) {
                poly = new Rectangle(points.get(0),points.get(1),points.get(2),points.get(3));
                if (poly.estCorrect()) {
                    erreur = false;
                }
            } else if (polyg.getType().equals(CerfVolant.class.toString().toLowerCase().substring(12))) {
                poly = new CerfVolant(points.get(0),points.get(1),points.get(2),points.get(3));
                if (poly.estCorrect()) {
                    erreur = false;
                }
            } else if (polyg.getType().equals(Losange.class.toString().toLowerCase().substring(12))) {
                poly = new Losange(points.get(0),points.get(1),points.get(2),points.get(3));
                if (poly.estCorrect()) {
                    erreur = false;
                }
            } else if (polyg.getType().equals(Parallelogramme.class.toString().toLowerCase().substring(12))) {
                poly = new Parallelogramme(points.get(0),points.get(1),points.get(2),points.get(3));
                if (poly.estCorrect()) {
                    erreur = false;
                }
            } else if (polyg.getType().equals(Trapeze.class.toString().toLowerCase().substring(12))) {
                poly = new Trapeze(points.get(0),points.get(1),points.get(2),points.get(3));
                if (poly.estCorrect()) {
                    erreur = false;
                }
            } else {
                erreur = false;//Polygone quelquonque
                if (points.size() == 1) {
                    poly = new Quelconque(points.get(0));
                } else if (points.size() == 2) {
                    poly = new Quelconque(points.get(0),points.get(1));
                } else if (points.size() == 3) {
                    poly = new Quelconque(points.get(0),points.get(1),points.get(2));
                } else if (points.size() == 4) {
                    poly = new Quelconque(points.get(0),points.get(1),points.get(2),points.get(3));
                }
            }

            if (erreur) {
                JOptionPane.showMessageDialog(this.window.getComponent(0),
                    "Le polygone ne respecte pas les conditions de son type, il n'a pas été modifié.",
                    "Erreur !",
                    JOptionPane.ERROR_MESSAGE);
                            } else {
                poly.setBaseColor(polyg.getBaseColor());//Recolor polygones with previous color.
                poly.setCurrentColor(polyg.getCurrentColor());//Recolor polygon with active color (pink for now)
                this.window.getMonJCanvas().setForme(selected[selected.length - 1], poly);
            }
        } else {
            if (points.size() == 1) {
                Quelconque poly = new Quelconque(points.get(0));
                this.window.getMonJCanvas().addForme(poly);
            } else if (points.size() == 2) {
                Quelconque poly = new Quelconque(points.get(0),points.get(1));
                this.window.getMonJCanvas().addForme(poly);
            } else if (points.size() == 3) {
                Quelconque poly = new Quelconque(points.get(0),points.get(1),points.get(2));
                this.window.getMonJCanvas().addForme(poly);
            } else if (points.size() == 4) {
                Quelconque poly = new Quelconque(points.get(0),points.get(1),points.get(2),points.get(3));
                this.window.getMonJCanvas().addForme(poly);
            }
        }
    }
}
