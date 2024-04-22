package sample_tests;
import hw4.SimpleElement;

import static org.junit.Assert.assertEquals;

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
        s1.setPosition(3.1, 3.2);
        assertEquals("new Y Expected 3.2: ", 3.2,  s1.getYReal(), 0.001);
        assertEquals("X Expected 3.1: ", 3.1,  s1.getXReal(), 0.001);
        System.out.println(s1.getRect().getY());
        SimpleElement s2 = new SimpleElement(3.1, 3.5, 4, 5);
        assertEquals("Collide is false", true, s1.collides(s2));
        s2.setPosition(4.5, 4.2);
        assertEquals("Collide is true", false, s1.collides(s2));

    }
}
