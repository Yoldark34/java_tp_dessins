package Vue;

import Controller.Main;
import Interface.IDrawable;
import Model.Polygone;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class JCanvas extends Canvas {

    Main monProgramme;
    List quadCol = new LinkedList();

    public JCanvas(Main monProgramme) {
        super();
        this.monProgramme = monProgramme;
    }

    public List findDrawables(Point p) {
        this.monProgramme.displayText(p.toString());
        List l = new ArrayList();
        for (Iterator iter = quadCol.iterator(); iter.hasNext();) {

            Polygone element = (Polygone) iter.next();
            if (element.contient(p)) {
                l.add(element);
            }
        }
        return l;
    }

    public List findNotSelectedDrawablesWithColor(Point p, Color col) {
        List l = new ArrayList();
        for (Iterator iter = quadCol.iterator(); iter.hasNext();) {
            Polygone element = (Polygone) iter.next();
            if (!element.contient(p) && element.getColor() == Color.BLUE) {
                l.add(element);
            }
        }
        return l;
    }

    public void removeDrawable(Polygone quad) {
        this.quadCol.remove(quad);
        repaint();
        this.monProgramme.raffraichiListePolygones();
    }

    public void addForme(Polygone quad) {
        this.quadCol.add(quad);
        repaint();
        this.monProgramme.raffraichiListePolygones();
    }

    public void setForme(int i, Polygone quad) {
        this.quadCol.set(i, quad);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 800);

        g.setColor(Color.RED);
        for (Iterator iter = quadCol.iterator(); iter.hasNext();) {
            IDrawable d = (IDrawable) iter.next();
            d.draw(g);
        }

        g.setColor(c);
    }

    public void refresh() {
        repaint();
    }

    public void setCollection(List quadCol) {
        this.quadCol = quadCol;
        repaint();
    }

    public List getCollection() {
        return this.quadCol;
    }

    public void active(Polygone p) {
        this.monProgramme.activeElement(p);

    }

    public void changeCursor(int cursorType) {
        this.monProgramme.changeCursor(cursorType);
    }

    public void reColor(Polygone drawable, Color newColor) {
        drawable.setColor(newColor);
        repaint();
    }

    public Point resizeDrawable(Polygone polygoneToResize, Point pointStart, Point pointEnd) {
        Point newPoint = polygoneToResize.resize(pointStart, pointEnd);
        this.monProgramme.displayText(polygoneToResize.toString() + "\n\n");
        if (polygoneToResize.estCorrect()) {
            polygoneToResize.setColor(Color.GREEN);
        } else {
            polygoneToResize.setColor(Color.RED);
        }
        repaint();
        return newPoint;
    }


    /**
     *Demande au programmer de désactiver l'élément car le canvas à fini son action
     */
    public void desactiveElement() {
        this.monProgramme.desactiveElement();
    }
}
