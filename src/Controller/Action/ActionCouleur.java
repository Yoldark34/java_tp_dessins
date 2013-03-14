package Controller.Action;

import Interface.*;
import Model.Polygone;
import Vue.FenetrePincipale;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

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
        int selected[] = this.window.getJl_Polygones().getSelectedIndices();
        for (int i : selected) {
            Polygone poly = this.window.getMonJCanvas().getCollection().get(i);
            poly.setBaseColor(this.color);
        }
        this.window.getMonJCanvas().repaint();
    }
}
