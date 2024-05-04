package sample_tests;

import hw4.FollowerElement;
import hw4.PlatformElement;

import static org.junit.Assert.assertEquals;

public class PlatformWithFollowerTest {

	public static void main(String[] args) {
		PlatformElement b = new PlatformElement(50, 200, 10, 10);
		b.setBounds(40, 70);
		FollowerElement e = new FollowerElement(5, 5, 2);
		e.setVelocity(2, 0);
		b.addAssociated(e);

		assertEquals(50, e.getMin(), 0.001);
		assertEquals(60, e.getMax(), 0.001);
		assertEquals(52, e.getXReal(), 0.001);
		assertEquals(195, e.getYReal(), 0.001);

		b.update();
		assertEquals(54, e.getXReal(), 0.001);
		assertEquals(59, e.getXReal() + 5, 0.001);
		assertEquals(2.0, e.getDeltaX(), 0.0);

		b.update();
		assertEquals(55, e.getXReal(), 0.001);
		assertEquals(60, e.getXReal() + 5, 0.001);
		assertEquals(-2.0, e.getDeltaX(), 0.0);

		b = new PlatformElement(50, 200, 10, 10);
		b.setBounds(40, 70);
		b.setVelocity(3, 0);
		e = new FollowerElement(5, 5, 2);
		b.addAssociated(e);

		assertEquals(52, e.getXReal(), 0.001);
		assertEquals(57, e.getXReal() + 5, 0.001);

		b.update();
		assertEquals(53, e.getMin(), 0.001);
		assertEquals(63, e.getMax(), 0.001);
		assertEquals(55, e.getXReal(), 0.001);
		assertEquals(60, e.getXReal() + 5, 0.001);

		b = new PlatformElement(50, 200, 10, 10);
		b.setBounds(40, 70);
		b.setVelocity(3, 0);
		e = new FollowerElement(5, 5, 2);
		e.setVelocity(2, 0);
		b.addAssociated(e);

		assertEquals(52, e.getXReal(), 0.001);
		assertEquals(57, e.getXReal() + 5, 0.001);

		b.update();
		assertEquals(53, e.getMin(), 0.001);
		assertEquals(63, e.getMax(), 0.001);
		assertEquals(57, e.getXReal(), 0.001);
		assertEquals(62, e.getXReal() + 5, 0.001);

		b.update();
		assertEquals(56, e.getMin(), 0.001);
		assertEquals(66, e.getMax(), 0.001);
		assertEquals(61, e.getXReal(), 0.001);
		assertEquals(66, e.getXReal() + 5, 0.001);
		assertEquals(-2.0, e.getDeltaX(), 0.0);
	}

}
