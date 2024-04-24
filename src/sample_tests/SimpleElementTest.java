package sample_tests;
import hw4.SimpleElement;

import static org.junit.Assert.assertEquals;
import static org.junit.gen5.api.Assertions.assertFalse;
import static org.junit.gen5.api.Assertions.assertTrue;

public class SimpleElementTest {
    public static void main(String[] args) {
        SimpleElement s1 = new SimpleElement(3, 2, 4, 5);
        assertEquals("Y Expected 2: ", 2,  s1.getYInt());
        assertEquals("X Expected 3: ", 3, s1.getXInt());
        assertEquals("Width Expected 4: ", 4, s1.getWidth());
        assertEquals("Height expected 5: ", 5, s1.getHeight());
        assertEquals("s1 incorrectly marked for deletion: ", false, s1.isMarked());
        s1.markForDeletion();
        assertEquals("s1 not marked for deletion after marking: ", true, s1.isMarked());
        assertEquals("fps counter incorrect after 0 updates: ", 0, s1.getFrameCount());
        s1.update();
        s1.update();
        s1.update();
        assertEquals("fps counter incorrect after 3 updates: ", 3, s1.getFrameCount());
        s1.setPosition(6, 6);
        assertEquals("new Y Expected 6: ", 6,  s1.getYReal(), 0.001);
        assertEquals("X Expected 6: ", 6,  s1.getXReal(), 0.001);
        SimpleElement s2 = new SimpleElement(6, 6, 3, 3);
        SimpleElement s3 = new SimpleElement(6, 6, 1, 1);
        assertEquals("Collide is false", true, s3.collides(s2));
        s2.setPosition(1, 1);
        assertEquals("Collide is true", false, s2.collides(s3));

        SimpleElement e = new SimpleElement(2.3, 4.5, 10, 20);

        assertEquals(2.3, e.getXReal(), 0.001);
        assertEquals(2, e.getXInt());
        assertEquals(4.5, e.getYReal(), 0.001);
        assertEquals(5, e.getYInt());
        assertEquals(10, e.getWidth());
        assertEquals(20, e.getHeight());
        assertEquals("[x=2,y=5,width=10,height=20]", e.getRect());
        assertFalse(e.isMarked(), "Element should not be marked initially");

        // Setting position
        e.setPosition(42, 137);
        assertEquals(42, e.getXReal());
        assertEquals(137, e.getYReal());

        // Update should increment the frame count
        e.update();
        e.update();
        assertEquals(2, e.getFrameCount());

        // Mark for deletion
        e.markForDeletion();
        assertTrue(e.isMarked());

        // Test collisions
        e = new SimpleElement(10, 0, 10, 10);
        SimpleElement e2 = new SimpleElement(1, 5, 10, 10);
        assertTrue(e.collides(e2), "Elements should collide");

        e2.setPosition(0, 5);
        assertFalse(e.collides(e2), "Elements should not collide after reposition");

    }
}
