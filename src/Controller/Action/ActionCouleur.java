package Controller.Action;

import Interface.*;
import Model.Polygone;
import Vue.FenetrePincipale;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class ActionCouleur extends AbstractAction implements IActionButton {
    FenetrePincipale window;
    Color color;

    public ActionCouleur(String texte, Color color, FenetrePincipale window) {
        super(texte);
        this.window = window;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ListModel<String> test = this.window.getJl_Polygones().getModel();

        //Polygone poly = this.window.getMonJCanvas().getCollection().get(this.window.getListSelectionModel().getMinSelectionIndex());
        //this.window.getMonJCanvas().active(poly);
    }
}
