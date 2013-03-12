package Vue.Listener;

import Vue.JCanvas;
import java.awt.event.*;
import javax.swing.SwingUtilities;

public abstract class JCanvasMouseListener extends MouseAdapter {

    protected JCanvas canvas;

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

    protected void mouseReleasedAction(MouseEvent e) {

    }

    protected void mousePressedAction(MouseEvent e) {

    }

    protected void rightClickAction(MouseEvent e) {
    }

    protected void leftClickAction(MouseEvent e) {
    }

    protected void mouseMoveAction(MouseEvent e) {
    }

    private void mouseExitedAction(MouseEvent e) {
    }
}