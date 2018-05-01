package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHello2 {

	@Test
	void test() {
		TestSum ts = new TestSum();
		assertEquals(ts.Sum(1, 2),3);
		assertEquals(ts.Sum(2, 2),4);
		//fail("Not yet implemented");
	}

}
