package Controller.Action;

import Controller.Main;
import Interface.*;
import Model.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ActionCerfVolant extends AbstractAction implements IActionObjet {

    Main maFenetre;
    CerfVolant monObjet;

    public ActionCerfVolant(String texte, Main fenetre) {
        super(texte);
        this.maFenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        this.monObjet = new CerfVolant(new Point(0, 30), new Point(40, 60), new Point(120, 30), new Point(40, 0));
        this.maFenetre.addForme(this.monObjet);
    }

    @Override
    public void agrandir() {
    }

    @Override
    public void reduire() {
    }
}
