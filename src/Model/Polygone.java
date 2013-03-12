package Model;

import Interface.IDrawable;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public abstract class Polygone implements IDrawable, Serializable {

    protected Color color = Color.BLACK;
    private List<Point> sommets = new ArrayList();
    private String type = "non défini";
    private int nombreSommets;

    public int getNombreSommets() {
        return nombreSommets;
    }

    public Polygone(Point... points) {
        this.nombreSommets = 0;
        //Ajout des points dans l'ensemble des sommets de la forme géométrique
        for (Point point : points) {
            this.sommets.add(point);
            this.nombreSommets++;
        }
    }

    public boolean contient(Point p) {
        for (int i = 0; i <= this.nombreSommets - 1; i++) {
            double x = this.getSommet(i).getX();
            double y = this.getSommet(i).getY();
            if (x == p.getX() && y == p.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de determiner si le polygone est correct
     *
     * @return Boolean
     */
    public abstract Boolean estCorrect();

    @Override
    public abstract String toString();

    /**
     * Retourne une chaine contenant la liste des coordonées sous la forme (x,y)
     *
     * @return String
     */
    public String coordonnees() {
        String result = "";
        for (int i = 0; i <= this.nombreSommets - 1; i++) {
            result += "(" + this.getSommet(i).x + "," + this.getSommet(i).y + "),\n";
        }
        return result;
    }

    /**
     * Retourne le sommet sous la forme x,y pour un sommet donné.
     *
     * @param i indice du sommet
     * @return
     */
    public String getSommetString(int i) {
        //TODO tester si le sommer existe
        return this.getSommet(i).x + "," + this.getSommet(i).y;
    }

    /**
     * Retourne le type du Polygone.
     *
     * @return
     */
    public String type() {
        return this.type;
    }

    /**
     * Set le type du polygone
     *
     * @param type
     */
    protected void setType(String type) {
        this.type = type;
    }

    /**
     * Permet de changer le point d'un sommet voulu
     *
     * @param indice numéro du sommet à changer
     * @param point
     */
    public void setSommet(int indice, Point point) {
        //TODO tester sir le sommet existe
        sommets.set(indice, point);
    }

    /**
     * Retourne le point d'un sommet
     *
     * @param indice numéro du sommet pour lequel on veut les coordonées
     * @return
     */
    public Point getSommet(int indice) {
        //TODO tester sir le sommet existe
        return this.sommets.get(indice);
    }

    /**
     * Defini si un point p appartien au polygone
     *
     * @param p sommet à tester
     * @return
     */
    public int findSommet(java.awt.Point p) {
        for (int i = 0; i <= this.nombreSommets - 1; i++) {
            if (this.getSommet(i).getX() == p.getX() && this.getSommet(i).getY() == p.getY()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Permet de calculer la longueur entre deux points
     *
     * @param a Point quelconque a
     * @param b Point quelconque b
     * @return la longueur en type double.
     */
    protected double calculCote(Point a, Point b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
    }

    /**
     * Effectu un produit scalaire de 4 points
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    protected double produitScalaire(Point a, Point b, Point c, Point d) {
        double vecteur1X = b.getX() - a.getX();
        double vecteur1Y = b.getY() - a.getY();
        double vecteur2X = d.getX() - c.getX();
        double vecteur2Y = d.getY() - c.getY();
        return vecteur1X * vecteur2X + vecteur1Y * vecteur2Y;
    }

    /**
     * Change la couleur du polygone
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Retourne la couleur actuelle du polygone
     *
     * @return
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * permey d'étirer le polygone en partant du sommet pointStart jusqu'à
     * pointEnd
     *
     * @param pointStart
     * @param pointEnd
     * @return
     */
    public abstract Point resize(Point pointStart, Point pointEnd);
}
