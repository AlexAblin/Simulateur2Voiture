package DomaineVoiture;

import AppliSimu.IHMVoiture;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class RouteTest {

    Route r;
    IHMVoiture i;

    @Before
    public void setUp() throws Exception {
        i = new IHMVoiture();
        r = new Route(i);
    }

    @Test
    public void testRoute() throws Exception {
        assertEquals(r.getF(), i);
    }


}