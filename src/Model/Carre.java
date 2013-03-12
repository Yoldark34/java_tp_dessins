package Model;

import java.awt.Point;

public class Carre extends Quadrilatere {

    public Carre(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        super.setType(this.getClass().toString().toLowerCase().substring(12));
    }

    @Override
    public Boolean estCorrect() {
        double cote1, cote2, cote3, cote4, monAngle;
        cote1 = calculCote(super.getSommet(0), super.getSommet(1));
        cote2 = calculCote(super.getSommet(1), super.getSommet(2));
        cote3 = calculCote(super.getSommet(2), super.getSommet(3));
        cote4 = calculCote(super.getSommet(3), super.getSommet(0));
        monAngle = produitScalaire(super.getSommet(0), super.getSommet(1), super.getSommet(1), super.getSommet(2));
        if (cote1 == cote2 && cote2 == cote3 && cote3 == cote4 && monAngle == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "Tous mes côtés sont égaux.";
        if (this.estCorrect()) {
            result += "I am a real square.";
        }
        return result;
    }

    @Override
    public Point resize(java.awt.Point pointStart, java.awt.Point pointEnd) {
        int numSommet = this.findSommet(pointStart);
        if (numSommet != -1) {
            Point pSurSurPrecedent = null;
            Point pSurPrecedent = null;
            Point pCourant = null;
            Point pPrecedent = null;
            Point pSuivant = null;
            Point pSurSuivant = null;
            Point pSurSurSuivant = null;
            switch (numSommet) {
                case 0:
                    int lg = super.getSommet(numSommet).x - super.getSommet(numSommet + 1).x;
                    if (lg < 0) {
                        lg = super.getSommet(numSommet + 1).x - super.getSommet(numSommet).x;
                    }
                    pCourant = new Point(pointEnd.x, pointEnd.y);
                    pSuivant = new Point(pointEnd.x + lg, pointEnd.y);
                    pSurSuivant = new Point(pointEnd.x + lg, pointEnd.y + lg);
                    pSurSurSuivant = new Point(pointEnd.x, pointEnd.y + lg);
                    super.setSommet(numSommet, pCourant);
                    super.setSommet(numSommet + 1, pSuivant);
                    super.setSommet(numSommet + 2, pSurSuivant);
                    super.setSommet(numSommet + 3, pSurSurSuivant);
                    break;
                case 1:
                    pPrecedent = new Point(super.getSommet(numSommet - 1).x, pointEnd.y);
                    pCourant = new Point(pointEnd.x, pointEnd.y);
                    pSuivant = new Point(pointEnd.x, (pointEnd.x - super.getSommet(numSommet - 1).x) + pointEnd.y);
                    pSurSuivant = new Point(super.getSommet(numSommet + 2).x, (pointEnd.x - super.getSommet(numSommet - 1).x) + pointEnd.y);
                    super.setSommet(numSommet - 1, pPrecedent);
                    super.setSommet(numSommet, pCourant);
                    super.setSommet(numSommet + 1, pSuivant);
                    super.setSommet(numSommet + 2, pSurSuivant);
                    break;
                case 2:
                    int max_x = 0;
                    max_x = pointEnd.x - pointStart.x;

                    int max_y = 0;
                    max_y = pointEnd.y - pointStart.y;

                    int max_max = max_x;
                    if (max_x < max_y) {
                        max_max = max_y;
                    }

                    pCourant = new Point(pointStart.x + max_max, pointStart.y + max_max);
                    pPrecedent = new Point(pointStart.x + max_max, super.getSommet(numSommet - 1).y);
                    pSuivant = new Point(super.getSommet(numSommet + 1).x, pointStart.y + max_max);
                    super.setSommet(numSommet - 1, pPrecedent);
                    super.setSommet(numSommet, pCourant);
                    super.setSommet(numSommet + 1, pSuivant);
                    break;
                case 3:
                    pSurSurPrecedent = new Point(pointEnd.x, super.getSommet(numSommet - 3).y);
                    pSurPrecedent = new Point((super.getSommet(numSommet).y - super.getSommet(numSommet - 2).y) + pointEnd.x, super.getSommet(numSommet - 2).y);
                    pPrecedent = new Point((super.getSommet(numSommet).y - super.getSommet(numSommet - 2).y) + pointEnd.x, pointEnd.y);
                    pCourant = new Point(pointEnd.x, pointEnd.y);
                    super.setSommet(numSommet - 3, pSurSurPrecedent);
                    super.setSommet(numSommet - 2, pSurPrecedent);
                    super.setSommet(numSommet - 1, pPrecedent);
                    super.setSommet(numSommet, pCourant);
                    break;
            }
            return pCourant;


        }
        return pointStart;
    }
}
