package sample_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.gen5.api.Assertions.assertFalse;
import static org.junit.gen5.api.Assertions.assertTrue;

import hw4.VanishingElement;
import org.junit.Assert;

public class VanishingElementTest {
    public static void main(String[] args) {
        VanishingElement e = new VanishingElement(1.1, 1.5, 1, 1, 3);
        assertEquals(1, e.getXInt());
        assertEquals(1.1, e.getXReal(), 0.001);
        assertEquals(1.5, e.getYReal(), 0.001);
        assertEquals(2, e.getYInt());
        assertEquals(3, e.getLife()); //TODO change access of getLife() to private after testing
        e.update();
        assertEquals(2, e.getLife());
        e.update();
        e.update();
        assertEquals(0, e.getLife());
        Assert.assertTrue(e.isMarked());
        e.update();
        assertEquals(0, e.getLife());
    }
}
