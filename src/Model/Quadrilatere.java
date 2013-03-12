package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Quadrilatere extends Polygone {

    public Quadrilatere(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType("quelconque");
    }

    /**
     * //TODO le mettre dans le polygone et le faire dynamiquement selon le
     * nombre de sommets Dessine le quadilatere
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(this.color);
        g.drawLine((int) super.getSommet(0).getX(), (int) super.getSommet(0).getY(), (int) super.getSommet(1).getX(), (int) super.getSommet(1).getY());
        g.drawLine((int) super.getSommet(1).getX(), (int) super.getSommet(1).getY(), (int) super.getSommet(2).getX(), (int) super.getSommet(2).getY());
        g.drawLine((int) super.getSommet(2).getX(), (int) super.getSommet(2).getY(), (int) super.getSommet(3).getX(), (int) super.getSommet(3).getY());
        g.drawLine((int) super.getSommet(3).getX(), (int) super.getSommet(3).getY(), (int) super.getSommet(0).getX(), (int) super.getSommet(0).getY());
        g.setColor(c);
    }

    @Override
    public String toString() {
        String result = "";
        result += "Je suis un quadrilatère " + super.type() + ".\n\n";
        result += "Mes sommets ont pour coordonnées :\n" + super.coordonnees() + ".\n";
        return result;
    }
}