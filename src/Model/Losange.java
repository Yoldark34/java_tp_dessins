package Model;

import java.awt.Point;

public class Losange extends Quadrilatere {

    public Losange(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType(this.getClass().toString().toLowerCase().substring(6));
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
    public void affiche() {
        super.affiche();
        System.out.println("Je suis un parallélogramme dont deux de mes côtés adjacents sont de même longueur.");
        if (this.estCorrect()) {
            System.out.println("I am a real losange.");
        }
    }

    @Override
    public Point resize(java.awt.Point pointStart, java.awt.Point pointEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
