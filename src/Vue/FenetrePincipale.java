package Vue;

import Controller.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FenetrePincipale extends JFrame {

    Main monProgramme;
    JPanel east;
    JPanel west;
    JPanel south;
    JPanel center;
    JLabel monTexte;
    ActionCarre monActionCarre;
    ActionRectangle monActionRectangle;
    ActionCerfVolant monActionCerfVolant;
    ActionTrapeze monActionTrapeze;
    ActionLosange monActionLosange;
    ActionParallelogramme monActionParallelogramme;
    JTextArea maZoneDeTexte;
    public JCanvas monJCanvas;

    public FenetrePincipale(Main monProgramme) {
        this.monProgramme = monProgramme;

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        //CENTER
        this.center = new JPanel();
        center.setLayout(new BorderLayout());
        this.monJCanvas = new JCanvas(this.monProgramme);
        this.monJCanvas.setBackground(Color.WHITE);
        new SimpleMouseListener(this.monJCanvas);
        center.add(this.monJCanvas, BorderLayout.CENTER);

        JPanel pointDefinition = new JPanel();
        pointDefinition.setLayout(new BoxLayout(pointDefinition, BoxLayout.X_AXIS));
        JLabel lPoint1 = new JLabel("Point 1 :");
        JLabel lPoint2 = new JLabel("Point 2 :");
        JLabel lPoint3 = new JLabel("Point 3 :");
        JLabel lPoint4 = new JLabel("Point 4 :");
        JTextField point1 = new JTextField(4);
        JTextField point2 = new JTextField(4);
        JTextField point3 = new JTextField(4);
        JTextField point4 = new JTextField(4);
        pointDefinition.add(lPoint1);
        pointDefinition.add(point1);
        pointDefinition.add(lPoint2);
        pointDefinition.add(point2);
        pointDefinition.add(lPoint3);
        pointDefinition.add(point3);
        pointDefinition.add(lPoint4);
        pointDefinition.add(point4);
        center.add(pointDefinition, BorderLayout.NORTH);

        content.add(center, BorderLayout.CENTER);
        //

        //WEST
        this.east = new JPanel();
        //String subject[] = {"Math", "Computer", "Phisics", "Chemestry"};
        east.setLayout(new BorderLayout());
        JList poly_list = new JList();
        poly_list.setPreferredSize(new Dimension(120,400));
        poly_list.setBackground(Color.lightGray);
        poly_list.setForeground(Color.BLACK);
        east.add(poly_list, BorderLayout.CENTER);
        east.add(poly_list);
        JButton Sauvegarder = new JButton("Sauvegarder");
        JButton Charger = new JButton("Charger");

        JPanel buttons = new JPanel();
                buttons.add(Sauvegarder);
        buttons.add(Charger);

        east.add(buttons, BorderLayout.SOUTH);
        content.add(east, BorderLayout.EAST);
        //

        //WEST
        this.west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));

        this.monActionCarre = new ActionCarre("Créer un carré", monProgramme);
        JButton carre = new JButton(this.monActionCarre);

        this.monActionRectangle = new ActionRectangle("Créer un rectangle", monProgramme);
        JButton rectangle = new JButton(this.monActionRectangle);

        this.monActionCerfVolant = new ActionCerfVolant("Créer un Cerf Volant", monProgramme);
        JButton cerfVolant = new JButton(this.monActionCerfVolant);

        this.monActionLosange = new ActionLosange("Créer un losange", monProgramme);
        JButton losange = new JButton(this.monActionLosange);

        this.monActionTrapeze = new ActionTrapeze("Créer un trapèze", monProgramme);
        JButton trapeze = new JButton(this.monActionTrapeze);

        this.monActionParallelogramme = new ActionParallelogramme("Créer un parallelogramme", monProgramme);
        JButton parallelogramme = new JButton(this.monActionParallelogramme);

        west.add(carre);
        west.add(rectangle);
        west.add(cerfVolant);
        west.add(losange);
        west.add(trapeze);
        west.add(parallelogramme);

        content.add(west, BorderLayout.WEST);
        //

        //SOUTH
        this.south = new JPanel();
        this.maZoneDeTexte = new JTextArea(15, 80);
        south.add(this.maZoneDeTexte);
        content.add(south, BorderLayout.SOUTH);
        //

        //... Set window characteristics.
        setContentPane(content);
        setTitle("BorderTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setResizable(false);
        setVisible(true);
    }

    public void affiche(String toString) {
        this.maZoneDeTexte.setText(toString);
    }
}
