package sample_tests;

import hw4.AttachedElement;
import hw4.PlatformElement;
import static org.junit.Assert.assertEquals;

public class PlatformWithAttachedTest {

	public static void main(String[] args) {
		PlatformElement p = new PlatformElement(50, 200, 10, 10);
		p.setBounds(40, 70);
		p.setVelocity(6, 0);

		// size 5 x 5, offset 2 units from left of platform, 15 above
		AttachedElement c = new AttachedElement(5, 5, 2, 15);

		// this should automatically make p the base of c
		p.addAssociated(c);

		// Test initial positions after setting base and offset
		assertEquals(52, c.getXReal(), 0.001);
		assertEquals(180, c.getYReal(), 0.001);

		// Update platform position and test attached element's updated position
		p.update();
		assertEquals(58, c.getXReal(), 0.001);
		assertEquals(180, c.getYReal(), 0.001);


		p.update();
		assertEquals(64, c.getXReal(), 0.001);
		assertEquals(180, c.getYReal(), 0.001);

		// Test that frame count was incremented twice
		assertEquals(1, c.getFrameCount(), 0.001);

	}

}
