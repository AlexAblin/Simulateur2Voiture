package AppliSimu;

import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandeVoiture extends JPanel implements ActionListener {

    private JButton boutonAccelerer;
    private JButton boutonInverserDirection;
    private JButton boutonTournerDroite;
	private JButton boutonTournerGauche;
    private JButton boutonArreter;
	private Voiture maVoiture;

	
	public CommandeVoiture(final JFrame fenetre,final Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
 
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

        boutonTournerDroite = new JButton("Tourner à droite");
        boutonTournerDroite.addActionListener(this);
        this.add(boutonTournerDroite);

		boutonTournerGauche = new JButton("Tourner à gauche");
		boutonTournerGauche.addActionListener(this);
		this.add(boutonTournerGauche);

		boutonArreter = new JButton("Arreter");
		boutonArreter.addActionListener(this);
		this.add(boutonArreter);

        fenetre.add(this);
		this.maVoiture = maVoiture;
       }


        @Override
	public void actionPerformed(ActionEvent event) {
        Object bouton = event.getSource();
        if (bouton == boutonAccelerer) {
            maVoiture.accelerer();
        }   else if (bouton == boutonInverserDirection) {
            maVoiture.inverserDirection();
        }   else if (bouton == boutonTournerDroite) {
            maVoiture.tournerADroite();
		}   else if (bouton == boutonTournerGauche) {
			maVoiture.tournerAGauche();
        }   else if (bouton == boutonArreter) {
            maVoiture.arreter();
        }

    }
}
