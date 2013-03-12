package Controller.Action;

import Controller.Main;
import Interface.IActionButton;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class ActionChargement extends AbstractAction implements IActionButton {

    Main main;

    public ActionChargement(String texte, Main main) {
        super(texte);
        this.main = main;
    }

    public void actionPerformed(ActionEvent e) {
        this.main.chargement();
    }
}
