package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	private int x;
	private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;


	public Voiture(int x, int y, int vitesse) {
		this.x = x;
		this.y = y;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;

	}

	public void miseAJourPosition() {
		miseAJourPositionX();
		miseAJourPositionY();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
		if (directionEnDegres == 0){
			x += vitesseMetreSeconde;

		}
		else if(directionEnDegres==180) {
			x -= vitesseMetreSeconde;

		}
		if (x > 3000)
			x = 3000;
		else if (x < 0)
			x = 0;
	}

	private void miseAJourPositionY() {
		if (directionEnDegres == 90) {
			y += vitesseMetreSeconde;

		}
		else if(directionEnDegres==270) {
			y -= vitesseMetreSeconde;

		}
		if (y > 3000)
			y = 3000;
	}

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}


	public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

	public int getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;
		
	}

	public void inverserDirection() {
		directionEnDegres +=180 ;
		directionEnDegres = directionEnDegres % 360;
	}

    public void tournerADroite() {
        directionEnDegres += 90  ;
        directionEnDegres = directionEnDegres % 360;
    }

	public void tournerAGauche() {
		directionEnDegres += 270  ;
		directionEnDegres = directionEnDegres % 360;
	}

	public void arreter(){
		vitesseMetreSeconde=0;
	}

	public int getDirection() {
	return directionEnDegres;
	}

	
}
