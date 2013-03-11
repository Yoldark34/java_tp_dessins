package Controller;

import Interface.*;
import Model.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ActionRectangle extends AbstractAction implements ActionObjet {

    Main maFenetre;
    Rectangle monObjet;

    public ActionRectangle(String texte, Main maFenetre) {
        super(texte);
        this.maFenetre = maFenetre;
    }

    public void actionPerformed(ActionEvent e) {
        this.monObjet = new Rectangle(new Point(0, 0), new Point(0, 70), new Point(30, 70), new Point(30, 0));
        this.maFenetre.addForme(this.monObjet);
    }

    @Override
    public void agrandir() {
        // TODO Auto-generated method stub
    }

    @Override
    public void reduire() {
        // TODO Auto-generated method stub
    }
}
