package Model;

import java.awt.Point;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class Rectangle extends Quadrilatere {

    public Rectangle(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType(this.getClass().toString().toLowerCase().substring(12));
    }

    @Override
    public Boolean estCorrect() {
        double angle1, angle2, angle3;
        angle1 = produitScalaire(super.getSommet(0), super.getSommet(1), super.getSommet(1), super.getSommet(2));
        angle2 = produitScalaire(super.getSommet(1), super.getSommet(2), super.getSommet(2), super.getSommet(3));
        angle3 = produitScalaire(super.getSommet(2), super.getSommet(3), super.getSommet(3), super.getSommet(0));
        if (angle1 == angle2 && angle2 == angle3 && angle3 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "Je suis un quadrilatère et mes 4 angles sont des angles droits.";
        if (this.estCorrect()) {
            result += "I am a real rectangle.";
        }
        return result;
    }

    @Override
    public Point resize(java.awt.Point pointStart, java.awt.Point pointEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
