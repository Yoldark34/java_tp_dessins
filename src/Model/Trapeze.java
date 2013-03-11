package Model;

import java.awt.Point;

public class Trapeze extends Quadrilatere {

    public Trapeze(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType(this.getClass().toString().toLowerCase().substring(6));
    }

    @Override
    public Boolean estCorrect() {
        if (Math.abs(produitScalaire(super.getSommet(0), super.getSommet(1), super.getSommet(3), super.getSommet(2))) == calculCote(this.getSommet(0), this.getSommet(1)) * calculCote(this.getSommet(3), this.getSommet(2))) {
            return true;
        } else if (Math.abs(produitScalaire(super.getSommet(1), super.getSommet(2), super.getSommet(0), super.getSommet(3))) == calculCote(this.getSommet(1), this.getSommet(2)) * calculCote(this.getSommet(0), this.getSommet(3))) {
            return true;
        }
        return false;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Je suis un quadrilatère avec deux côtés parallèles.");
        if (this.estCorrect()) {
            System.out.println("I am a real trapezoïde.");
        }
    }

    @Override
    public Point resize(java.awt.Point pointStart, java.awt.Point pointEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
