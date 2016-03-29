package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
    private Route rH,rV;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}

	public IHMVoiture(Voiture maVoiture) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
        rH = new Route(10,300);
		rV = new Route(300,100);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}

	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.black);
		dessinerRouteHorizontale(contexteGraphique);
        dessinerRouteVerticale(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int yMetres = maVoiture.getY();
		int xPixel = calculerPositionPixels(xMetres);
		int yPixel = calculerPositionPixels(yMetres);
		if(maVoiture.getDirection()==0 || maVoiture.getDirection()==180 ) {
			contexteGraphique.fillRect(xPixel, 300 + yPixel, 30, 15);
		}
		else{
			contexteGraphique.fillRect(xPixel, 300 + yPixel, 15, 30);
		}
	}

	public void dessinerRouteHorizontale(Graphics contexteGraphique){
		contexteGraphique.fillRect(rH.getX(), rH.getY(), this.getWidth(), 30);
		contexteGraphique.setColor(Color.white);
		contexteGraphique.drawLine(rH.getX(), rH.getY()+15,this.getWidth(),rH.getY()+15);
	}

	public void dessinerRouteVerticale(Graphics contexteGraphique){
		contexteGraphique.setColor(Color.black);
		contexteGraphique.fillRect(rV.getX(), rV.getY(), 30, this.getHeight());
		contexteGraphique.setColor(Color.white);
		contexteGraphique.drawLine(rV.getX()+15,rV.getY(),rV.getX()+15,this.getHeight());
	}


}
