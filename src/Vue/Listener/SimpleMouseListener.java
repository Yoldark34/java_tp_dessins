package Vue.Listener;

import Model.Polygone;
import Vue.JCanvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public class SimpleMouseListener extends JCanvasMouseListener {

    Point pointStart;
    Polygone polygoneToResize;
    boolean resizeMode;

    public SimpleMouseListener(JCanvas canvas) {
        super(canvas);
    }

    /**
     * Supprime le polygone du canvas
     *
     * @param e
     */
    @Override
    protected void rightClickAction(MouseEvent e) {
        List selectedDrawables = super.canvas.findDrawables(e.getPoint());
        if (!selectedDrawables.isEmpty()) {
            Polygone drawable = (Polygone) selectedDrawables.get(0);
            canvas.removeDrawable(drawable);
        }
    }

    /**
     * fini de redimentionner le polygone
     *
     * @param e
     */
    @Override
    protected void mouseReleasedAction(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (this.resizeMode) {
                canvas.resizeDrawable(this.polygoneToResize, this.pointStart, e.getPoint());
                this.resizeMode = false;
                canvas.reColor(this.polygoneToResize, Color.BLACK);
                this.canvas.desactiveElement();
            } else {
                this.pointStart = null;
                this.resizeMode = false;
            }
        }
    }

    /**
     * Passage en mode redimentionnement pour le premier polygone contenant le
     * sommet pointé
     *
     * @param e
     */
    @Override
    protected void mousePressedAction(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            List selectedDrawables = super.canvas.findDrawables(e.getPoint());
            if (!selectedDrawables.isEmpty()) {
                this.polygoneToResize = (Polygone) selectedDrawables.get(0);
                this.pointStart = e.getPoint();
                this.resizeMode = true;
                canvas.active((Polygone) selectedDrawables.get(0));
            }
        }
    }

    @Override
    protected void leftClickAction(MouseEvent e) {
    }

    /**
     * Redimmentionne à ma volée le polygone pendant le déplacement de la souris
     *
     * @param e
     */
    @Override
    protected void mouseMoveAction(MouseEvent e) {
        List selectedDrawables = super.canvas.findDrawables(e.getPoint());
        List notSelectedDrawables = super.canvas.findNotSelectedDrawablesWithColor(e.getPoint(), Color.BLUE);
        if (!selectedDrawables.isEmpty()) {
            Polygone drawable = (Polygone) selectedDrawables.get(0);
            canvas.reColor(drawable, Color.BLUE);
            canvas.changeCursor(Cursor.CROSSHAIR_CURSOR);
        } else {
            canvas.changeCursor(Cursor.DEFAULT_CURSOR);
        }
        if (!notSelectedDrawables.isEmpty()) {
            for (Iterator iter = notSelectedDrawables.iterator(); iter.hasNext();) {
                Polygone drawable = (Polygone) iter.next();
                canvas.reColor(drawable, Color.BLACK);
            }
        }

        if (this.resizeMode) {
            this.pointStart = canvas.resizeDrawable(this.polygoneToResize, this.pointStart, e.getPoint());
            canvas.active(this.polygoneToResize);
        }
    }
}