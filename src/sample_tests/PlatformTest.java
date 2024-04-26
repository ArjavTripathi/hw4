package sample_tests;

import hw4.PlatformElement;
import static org.junit.Assert.assertEquals;

public class PlatformTest {

	public static void main(String[] args) {
		// left side at x = 50, width 10, right side at 60
		PlatformElement p = new PlatformElement(50, 200, 10, 10);
		p.setBounds(40, 70);
		p.setVelocity(6, 0);

		p.update();
		assertEquals("Check updated position after first update", 56, p.getXReal(), 0.001);
		assertEquals("Check right boundary after first update", 66, p.getXReal() + 10, 0.001);
		assertEquals("Check velocity after first update", 6.0, p.getDeltaX(), 0.001);

		p.update();
		assertEquals("Check updated position after second update", 60, p.getXReal(), 0.001);
		assertEquals("Check right boundary after second update", 70, p.getXReal() + 10, 0.001);
		assertEquals("Check velocity after second update", -6.0, p.getDeltaX(), 0.001);

		p.update();
		assertEquals("Check updated position after third update", 54, p.getXReal(), 0.001);
		assertEquals("Check right boundary after third update", 64, p.getXReal() + 10, 0.001);
		assertEquals("Check velocity after third update", -6.0, p.getDeltaX(), 0.001);

		p.update();
		assertEquals("Check updated position after fourth update", 48, p.getXReal(), 0.001);
		assertEquals("Check right boundary after fourth update", 58, p.getXReal() + 10, 0.001);
		assertEquals("Check velocity after fourth update", -6.0, p.getDeltaX(), 0.001);

		p.update();
		assertEquals("Check updated position after fifth update", 42, p.getXReal(), 0.001);
		assertEquals("Check right boundary after fifth update", 52, p.getXReal() + 10, 0.001);
		assertEquals("Check velocity after fifth update", -6.0, p.getDeltaX(), 0.001);

		p.update();
		assertEquals("Check updated position after sixth update", 40, p.getXReal(), 0.001);
		assertEquals("Check right boundary after sixth update", 50, p.getXReal() + 10, 0.001);
		assertEquals("Check velocity after sixth update", 6.0, p.getDeltaX(), 0.001);
	}

}
