package Model;

import Interface.IDrawable;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Polygone implements IDrawable, Serializable {

    protected Color color = Color.BLACK;
    private List<Point> sommets = new ArrayList();
    private String type = "non défini";
    private int nombreSommets;

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

    public abstract Boolean estCorrect();

    @Override
    public abstract String toString();

    public String coordonnees() {
        String result = "";
        for (int i = 0; i <= this.nombreSommets - 1; i++) {
            result += "(" + this.getSommet(i).x + "," + this.getSommet(i).y + "),\n";
        }
        return result;
    }

    public String type() {
        return this.type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public void setSommet(int indice, Point point) {
        sommets.set(indice, point);
    }

    public Point getSommet(int indice) {
        return this.sommets.get(indice);
    }

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

    protected double produitScalaire(Point a, Point b, Point c, Point d) {
        double vecteur1X = b.getX() - a.getX();
        double vecteur1Y = b.getY() - a.getY();
        double vecteur2X = d.getX() - c.getX();
        double vecteur2Y = d.getY() - c.getY();
        return vecteur1X * vecteur2X + vecteur1Y * vecteur2Y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public abstract Point resize(java.awt.Point pointStart, java.awt.Point pointEnd);
}
