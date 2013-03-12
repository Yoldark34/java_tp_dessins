package Model;

import java.awt.Point;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class Losange extends Quadrilatere {

    public Losange(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType(this.getClass().toString().toLowerCase().substring(12));
    }

    @Override
    public Boolean estCorrect() {
        double cote1, cote2, cote3, cote4, angleDiagonales;
        cote1 = calculCote(super.getSommet(0), super.getSommet(1));
        cote2 = calculCote(super.getSommet(1), super.getSommet(2));
        cote3 = calculCote(super.getSommet(2), super.getSommet(3));
        cote4 = calculCote(super.getSommet(3), super.getSommet(0));
        angleDiagonales = produitScalaire(super.getSommet(0), super.getSommet(2), super.getSommet(1), super.getSommet(3));
        if (angleDiagonales == 0 && cote1 == cote2 && cote2 == cote3 && cote3 == cote4) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "Je suis un parallélogramme dont deux de mes côtés adjacents sont de même longueur.";
        if (this.estCorrect()) {
            result += "I am a real losange.";
        }
        return result;
    }

    @Override
    public Point resize(java.awt.Point pointStart, java.awt.Point pointEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
