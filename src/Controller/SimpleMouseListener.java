package Controller;

import Interface.IDrawable;
import Model.Polygone;
import Vue.JCanvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

public class SimpleMouseListener extends JCanvasMouseListener {

    Point pointStart;
    Polygone polygoneToResize;
    boolean resizeMode;
    
    public SimpleMouseListener(JCanvas canvas) {
        super(canvas);
    }

    @Override
    protected void rightClickAction(MouseEvent e) {
        List selectedDrawables = super.canvas.findDrawables(e.getPoint());
        if (!selectedDrawables.isEmpty()) {
            Polygone drawable = (Polygone) selectedDrawables.get(0);
            canvas.removeDrawable(drawable);
        }
    }

    @Override
    protected void mouseReleasedAction(MouseEvent e) {
        if (this.resizeMode) {
            canvas.resizeDrawable(this.polygoneToResize, this.pointStart, e.getPoint());
            this.resizeMode = false;
        }  
        else
        {
            this.pointStart = null;
            this.resizeMode = false;
        }
    }

    @Override
    protected void mousePressedAction(MouseEvent e) {
        List selectedDrawables = super.canvas.findDrawables(e.getPoint());
        if (!selectedDrawables.isEmpty()) {
            this.polygoneToResize = (Polygone)selectedDrawables.get(0);
            this.pointStart = e.getPoint();
            this.resizeMode = true;
        }
    }
    
    @Override
    protected void leftClickAction(MouseEvent e) {
        /*List selectedDrawables = super.canvas.findDrawables(e.getPoint());
        if (!selectedDrawables.isEmpty()) {
            /*Polygone drawable = (Polygone) selectedDrawables.get(0);
            canvas.active(drawable);
        }
        Point p = e.getPoint();
        /*IDrawable rect = createDrawable(e);
         if (canvas.isFree(rect.getRectangle())) {
         canvas.addDrawable(rect);
         }*/
    }
    
    @Override
    protected void mouseMoveAction(MouseEvent e) {
        List selectedDrawables = super.canvas.findDrawables(e.getPoint());
        List notSelectedDrawables = super.canvas.findNotSelectedDrawablesWithColor(e.getPoint(), Color.BLUE);
        if (!selectedDrawables.isEmpty()) {
            Polygone drawable = (Polygone) selectedDrawables.get(0);
            canvas.reColor(drawable, Color.BLUE);
            canvas.changeCursor(Cursor.CROSSHAIR_CURSOR);
        }
        else
        {
            canvas.changeCursor(Cursor.DEFAULT_CURSOR);
        }
        if (!notSelectedDrawables.isEmpty()) {
            for (Iterator iter = notSelectedDrawables.iterator(); iter.hasNext();) {
                Polygone drawable = (Polygone) iter.next();
                canvas.reColor(drawable, Color.BLACK);
            }
            
        }
        
        if (this.resizeMode)
        {
            this.pointStart = canvas.resizeDrawable(this.polygoneToResize, this.pointStart, e.getPoint());
            /*boolean resized = canvas.resizeDrawable(this.polygoneToResize, this.pointStart, e.getPoint());
            if (resized)
            {
                this.pointStart = e.getPoint();
            }*/
        }
    }

    /*private IDrawable createDrawable(MouseEvent e) {
     Point p = e.getPoint();
     Dimension dim = new Dimension(40, 40);
     return new RectangleDrawable(Color.RED, p, dim);

     }*/
}