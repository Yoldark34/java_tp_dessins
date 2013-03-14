/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class Quelconque extends Polygone {

    public Quelconque(Point... points) {
        super(points);
    }

    @Override
    public Boolean estCorrect() {
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Je suis un polygone " + super.getType() + ".\n\n";
        result += "Mes sommets ont pour coordonnées :\n" + super.coordonnees() + ".\n";
        return result;
    }

    @Override
    public Point resize(Point pointStart, Point pointEnd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
