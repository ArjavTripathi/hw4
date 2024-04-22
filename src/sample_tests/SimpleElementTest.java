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
    }
}
