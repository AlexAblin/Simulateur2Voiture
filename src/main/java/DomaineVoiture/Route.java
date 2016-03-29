package DomaineVoiture;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 21102934 on 23/03/2016.
 */
public class Route
{
    int x;
    int y;

    public Route(int xpos,int ypos) {

        this.x=xpos;
        this.y=ypos;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
