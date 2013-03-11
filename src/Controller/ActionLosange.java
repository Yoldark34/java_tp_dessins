package Controller;

import Interface.*;
import Model.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ActionLosange extends AbstractAction implements ActionObjet {

    Main maFenetre;
    Losange monObjet;

    public ActionLosange(String texte, Main fenetre) {
        super(texte);
        this.maFenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        this.monObjet = new Losange(new Point(0, 30), new Point(40, 60), new Point(80, 30), new Point(40, 0));
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
