package Vue;


import Controller.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FenetrePincipale extends JFrame {

    Main monProgramme;
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
        this.monJCanvas = new JCanvas(this.monProgramme);
        this.monJCanvas.setBackground(Color.WHITE);
        new SimpleMouseListener(this.monJCanvas);
        content.add(this.monJCanvas, BorderLayout.CENTER);
        //
        
        //WEST
        this.west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        this.center = new JPanel();

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
        this.maZoneDeTexte = new JTextArea(15, 65);
        south.add(this.maZoneDeTexte);
        content.add(south, BorderLayout.SOUTH);
        //
        
        //... Set window characteristics.
        setContentPane(content);
        setTitle("BorderTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setSize(new Dimension(750, 800));
        this.setResizable(false);
        setVisible(true);
    }

    public void affiche(String toString) {
        this.maZoneDeTexte.setText(toString);
    }
}
