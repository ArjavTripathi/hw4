package sample_tests;

import hw4.FlyingElement;

import static org.junit.Assert.assertEquals;

public class FlyingElementTest {
    public static void main(String[] args) {
        FlyingElement p = new FlyingElement(0, 0, 0, 0);
        p.setGrounded(false);
        p.setVelocity(2, 3);
        p.update();
        assertEquals(3, p.getYReal(), 0.001);
        assertEquals(3, p.getDeltaY(), 0.001);

        p.update();
        assertEquals(6, p.getYReal(), 0.001);
        assertEquals(3, p.getDeltaY(), 0.001);

        p.setGravity(5);
        p.update();
        assertEquals(9, p.getYReal(), 0.001);
        assertEquals(8, p.getDeltaY(), 0.001);

        p.setGrounded(true);
        p.update();
        assertEquals(17, p.getYReal(), 0.001);
        assertEquals(8, p.getDeltaY(), 0.001);

        p.update();
        assertEquals(25, p.getYReal(), 0.001);
        assertEquals(8, p.getDeltaY(), 0.001);
    }
}
