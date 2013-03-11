package Controller;

import Model.Polygone;
import Model.Quadrilatere;
import Vue.FenetrePincipale;
import java.awt.Cursor;
import java.awt.Polygon;

public class Main {

    FenetrePincipale window;

    public void addForme(Quadrilatere quad) {
        this.window.monJCanvas.addForme(quad);
    }

    public void setForme(Quadrilatere quad, int i) {
        this.window.monJCanvas.setForme(i, quad);
    }
    
    public void activeElement(Polygone p)
    {
        this.window.affiche(p.toString());
    }
    
    public void displayText(String text)
    {
        this.window.affiche(text);
    }
    
    public void changeCursor(int typeCursor)
    {
        this.window.setCursor(Cursor.getPredefinedCursor(typeCursor));
    }

    public Main() {
        /*Quadrilatere[] collection = new Quadrilatere[6];
         collection[0] = new Carre(new Point(0,0), new Point(0,7),new Point(7,7), new Point(7,0));
         collection[1] = new CerfVolant(new Point(0,0), new Point(0,7), new Point(7,0), new Point(7,7));
         collection[2] = new Losange(new Point(0,0), new Point(0,7), new Point(7,0), new Point(7,7));
         collection[3] = new Parallelogramme(new Point(0,0), new Point(0,7), new Point(7,0), new Point(7,7));
         collection[4] = new Rectangle(new Point(0,0), new Point(0,7), new Point(7,0), new Point(7,7));
         collection[5] = new Trapeze(new Point(0,0), new Point(0,7), new Point(7,0), new Point(7,7));
         for(int i=0;i<collection.length;i++){
         collection[i].affiche();
         }
         collection[0].affiche();*/
        this.window = new FenetrePincipale(this);
    }
}
