/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vue.JCanvas;
import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class listSelectionModel extends DefaultListSelectionModel {

    protected JCanvas canvas;
    private static final long serialVersionUID = 1L;
    boolean gestureStarted = false;

    public listSelectionModel(JCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void setSelectionInterval(int index0, int index1) {
        if (!gestureStarted) {
            if (isSelectedIndex(index0)) {
                super.removeSelectionInterval(index0, index1);
                this.canvas.getCollection().get(index0).resetColor();
                this.canvas.desactiveElement();
                this.canvas.repaint();
            } else {
                super.addSelectionInterval(index0, index1);
            }
        }
        gestureStarted = true;
    }

    @Override
    public void setValueIsAdjusting(boolean isAdjusting) {
        if (isAdjusting == false) {
            gestureStarted = false;
        }
    }
}
