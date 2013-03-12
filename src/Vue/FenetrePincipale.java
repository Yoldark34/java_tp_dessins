package Vue;

import Controller.Action.ActionCarre;
import Controller.Action.ActionCerfVolant;
import Controller.Action.ActionChargement;
import Controller.Action.ActionLosange;
import Controller.Action.ActionParallelogramme;
import Controller.Action.ActionRectangle;
import Controller.Action.ActionSauvegarde;
import Controller.Action.ActionTrapeze;
import Controller.Main;
import Vue.Listener.SimpleMouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        ActionSauvegarde ac_sauvegarder = new ActionSauvegarde("Sauvegarder", this.monProgramme);
        JButton bt_sauvegarder = new JButton(ac_sauvegarder);

        ActionChargement ac_charger = new ActionChargement("Charger", this.monProgramme);
        JButton bt_charger = new JButton(ac_charger);

        JPanel boutons = new JPanel();
        boutons.add(bt_sauvegarder);
        boutons.add(bt_charger);

        east.add(boutons, BorderLayout.SOUTH);
        content.add(east, BorderLayout.EAST);
        //

        //WEST
        this.west = new JPanel();
        west.setLayout(new BorderLayout());

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

        JPanel boutons_polygones = new JPanel();
        boutons_polygones.setLayout(new BoxLayout(boutons_polygones, BoxLayout.Y_AXIS));
        boutons_polygones.add(carre);
        boutons_polygones.add(rectangle);
        boutons_polygones.add(cerfVolant);
        boutons_polygones.add(losange);
        boutons_polygones.add(trapeze);
        boutons_polygones.add(parallelogramme);
        west.add(boutons_polygones, BorderLayout.CENTER);

        JPanel boutons_couleurs = new JPanel();

        JButton rouge = new JButton();
        rouge.setBackground(Color.RED);
        rouge.setPreferredSize(new Dimension(25, 25));
        JButton bleu = new JButton();
        bleu.setBackground(Color.BLUE);
        bleu.setPreferredSize(new Dimension(25, 25));
        JButton jaune = new JButton();
        jaune.setBackground(Color.YELLOW);
        jaune.setPreferredSize(new Dimension(25, 25));
        JButton vert = new JButton();
        vert.setBackground(Color.GREEN);
        vert.setPreferredSize(new Dimension(25, 25));
        JButton orange = new JButton();
        orange.setBackground(Color.ORANGE);
        orange.setPreferredSize(new Dimension(25, 25));
        JButton gris = new JButton();
        gris.setBackground(Color.GRAY);
        gris.setPreferredSize(new Dimension(25, 25));
        JButton noir = new JButton();
        noir.setBackground(Color.BLACK);
        noir.setPreferredSize(new Dimension(25, 25));

        boutons_couleurs.add(rouge);
        boutons_couleurs.add(bleu);
        boutons_couleurs.add(jaune);
        boutons_couleurs.add(vert);
        boutons_couleurs.add(orange);
        boutons_couleurs.add(gris);
        boutons_couleurs.add(noir);

        west.add(boutons_couleurs, BorderLayout.SOUTH);

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
