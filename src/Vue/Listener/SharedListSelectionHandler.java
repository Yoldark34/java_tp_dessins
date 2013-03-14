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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
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
    }
}