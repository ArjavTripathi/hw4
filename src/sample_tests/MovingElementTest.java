package sample_tests;

import hw4.MovingElement;
import static org.junit.Assert.assertEquals;

public class MovingElementTest {
    public static void main(String[] args) {
        MovingElement e = new MovingElement(1.1, 1.1, 1, 1);
        e.setVelocity(2, 2);
        e.update();
        assertEquals(3.1, e.getXReal(), 0.001);
        assertEquals(3.1, e.getYReal(), 0.001);
        e.update();
        assertEquals(5, e.getXInt());
        assertEquals(5, e.getYInt());
        assertEquals(2, e.getFrameCount());
    }
}
