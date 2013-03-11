package Controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import Interface.*;
import Model.*;
import Vue.*;
import java.awt.Point;

public class ActionCarre extends AbstractAction implements ActionObjet {

    Main maFenetre;
    Carre monObjet;

    public ActionCarre(String texte, Main fenetre) {
        super(texte);
        this.maFenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.monObjet = new Carre(new Point(5, 5), new Point(70, 5), new Point(70, 70), new Point(5, 70));
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
