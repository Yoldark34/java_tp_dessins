package Controller.Action;

import Controller.Main;
import Interface.IActionButton;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ActionSauvegarde extends AbstractAction implements IActionButton {

    Main main;

    public ActionSauvegarde(String texte, Main main) {
        super(texte);
        this.main = main;
    }

    public void actionPerformed(ActionEvent e) {
        this.main.sauvegarde();
    }
}
