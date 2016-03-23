package DomaineVoiture;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 21102934 on 23/03/2016.
 */
public class Route
{
    JFrame f;

    public Route(JFrame fr) {
        f = fr;
    }

    public void dessinerRouteHorizontale(Graphics contexteGraphique){
        contexteGraphique.fillRect(10, 300, f.getWidth(), 30);
        contexteGraphique.setColor(Color.white);
        contexteGraphique.drawLine(10,315,f.getWidth(),315);
    }

    public void dessinerRouteVerticale(Graphics contexteGraphique){
        contexteGraphique.setColor(Color.black);
        contexteGraphique.fillRect(200, 300, 30, f.getHeight());
        contexteGraphique.setColor(Color.white);
        contexteGraphique.drawLine(215,300,215,f.getHeight());
    }

    public JFrame getF() {
        return f;
    }
}
