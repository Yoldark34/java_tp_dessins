package Vue.Listener;

import Vue.JCanvas;
import java.awt.event.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public abstract class JCanvasMouseListener extends MouseAdapter {

    protected JCanvas canvas;

    /**
     * Charge le listener sur le Canvas
     *
     * @param canvas
     */
    public JCanvasMouseListener(JCanvas canvas) {
        super();
        this.canvas = canvas;
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
    }

    public JCanvas getCanvas() {
        return canvas;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoveAction(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMoveAction(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            leftClickAction(e);
        } else {
            rightClickAction(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressedAction(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseReleasedAction(e);
    }

    /**
     * Relachement du clic de la souris
     * @param e
     */
    protected void mouseReleasedAction(MouseEvent e) {
    }

    /**
     * Appuis sur un clic de la souris
     * @param e
     */
    protected void mousePressedAction(MouseEvent e) {
    }

    /**
     * Clic droit de la souris
     * @param e
     */
    protected void rightClickAction(MouseEvent e) {
    }

    /**
     * Clic gauche de la souris
     * @param e
     */
    protected void leftClickAction(MouseEvent e) {
    }

    /**
     * Mouvement de la souris
     * @param e
     */
    protected void mouseMoveAction(MouseEvent e) {
    }
}