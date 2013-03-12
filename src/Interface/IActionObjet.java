package Interface;

import java.awt.event.ActionEvent;

/**
 *
 * @author Yohan Sanchez et Forian Haller-Cassandre
 */
public interface IActionObjet {

    public abstract void actionPerformed(ActionEvent e);

    public abstract void agrandir();

    public abstract void reduire();
}
