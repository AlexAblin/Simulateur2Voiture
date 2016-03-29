package DomaineVoiture;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteTest {

    Route r;

    @Before
    public void setUp() throws Exception {
        r = new Route(40, 60);
    }

    @Test
    public void testGetY() throws Exception {
        assertEquals(r.getY(), 60);
    }

    @Test
    public void testGetX() throws Exception {
        assertEquals(r.getX(), 40);
    }
}