package Model;

import java.awt.Point;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public abstract class Quadrilatere extends Polygone {

    public Quadrilatere(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType("quelconque");
    }

    @Override
    public String toString() {
        String result = "";
        result += "Je suis un quadrilatère " + super.type() + ".\n\n";
        result += "Mes sommets ont pour coordonnées :\n" + super.coordonnees() + ".\n";
        return result;
    }
}