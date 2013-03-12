package Controller.Action;

import Controller.Main;
import Interface.*;
import Model.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class ActionLosange extends AbstractAction implements IActionObjet {

    Main maFenetre;
    Losange monObjet;

    public ActionLosange(String texte, Main fenetre) {
        super(texte);
        this.maFenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.monObjet = new Losange(new Point(0, 30), new Point(40, 60), new Point(80, 30), new Point(40, 0));
        this.maFenetre.addForme(this.monObjet);
    }

    @Override
    public void agrandir() {
    }

    @Override
    public void reduire() {
    }
}
