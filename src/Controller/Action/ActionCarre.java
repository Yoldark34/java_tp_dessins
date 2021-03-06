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
public class ActionCarre extends AbstractAction implements IActionObjet {

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
    }

    @Override
    public void reduire() {
    }
}
