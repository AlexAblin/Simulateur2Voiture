package AppliSimu;

import DomaineVoiture.Voiture;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class CommandeVoitureTest {
    CommandeVoiture c;
    Voiture maVoiture;
    @Before
    public void setUp() throws Exception {
        maVoiture=new Voiture(50,100,0);
       c=new CommandeVoiture(new JFrame(),maVoiture);
    }

    @Test
    public void testActionPerformed() throws Exception {
        maVoiture.accelerer();
        assertTrue(maVoiture.getVitesse()>0);
        maVoiture.inverserDirection();
        assertEquals(maVoiture.getDirection(),180);
        maVoiture.tournerADroite();
        assertEquals(maVoiture.getDirection(),270);
        maVoiture.tournerAGauche();
        assertEquals(maVoiture.getDirection(),180);
        maVoiture.arreter();
        assertEquals(maVoiture.getVitesse(),0);

    }
}