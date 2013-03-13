package Vue.Listener;

import Model.Polygone;
import Vue.JCanvas;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SharedListSelectionHandler implements ListSelectionListener {

    protected JCanvas canvas;

    public SharedListSelectionHandler(JCanvas canvas) {
        this.canvas = canvas;
    }

    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();

        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean isAdjusting = e.getValueIsAdjusting();
        /*output.append("Event for indexes "
                      + firstIndex + " - " + lastIndex
                      + "; isAdjusting is " + isAdjusting
                      + "; selected indexes:");*/

        if (lsm.isSelectionEmpty()) {
            //output.append(" <none>");
        } else {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = 0; i <= canvas.getCollection().size() - 1; i++) {
                if (lsm.isSelectedIndex(i)) {
                    canvas.active((Polygone)canvas.getCollection().get(i));
                    canvas.reColor((Polygone)canvas.getCollection().get(i), Color.PINK);
                } else
                {
                    canvas.getCollection().get(i).resetColor();
                }
            }
        }
        //output.append(newline);
    }
}