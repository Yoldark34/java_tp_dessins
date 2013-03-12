package Controller.Action;

import Controller.Main;
import Interface.*;
import Model.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ActionTrapeze extends AbstractAction implements IActionObjet {

    Main maFenetre;
    Trapeze monObjet;

    public ActionTrapeze(String texte, Main fenetre) {
        super(texte);
        this.maFenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        this.monObjet = new Trapeze(new Point(0, 40), new Point(0, 110), new Point(60, 150), new Point(60, 0));
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
