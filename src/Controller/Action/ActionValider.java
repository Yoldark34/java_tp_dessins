/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Action;

import Controller.Main;
import Interface.IActionButton;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class ActionValider extends AbstractAction implements IActionButton  {
    Main main;

    public ActionValider(String texte, Main main) {
        super(texte);
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.main.valider();
    }
}
