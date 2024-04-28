package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeAllCouplingUsesCoverageTest {

	// ACUC proposePoisition a)
	@Test
	void testArrayNTreeDeleteFirstChild() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ant.insert(2);

		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(1,1);


		ant.delete(2);

		assertEquals(expected, ant);
		// Kill 56 replaced with return true
		assertTrue(ant.contains(1));
	}

	// ACUC proposePoisition b)
	@Test
	void testArrayNTreeDeleteElemSmallerThanFirstChild() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ant.insert(3);

		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(1,1);
		expected.insert(3);

		ant.delete(2);
		assertEquals(expected, ant);
	}

	// ACUC proposePoisition c)
	@Test
	void testArrayNTreeDeleteElemGraterThanFirstChild() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ant.insert(2);

		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(1,1);
		expected.insert(2);

		ant.delete(3);
		assertEquals(expected, ant);
	}

	/////////////////////////////////////////////////////////////////////////////

	// ACUC: compact a)
	@Test
	void testArrayNTreeDeleteRootWithChildren() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2);
		ant.insert(2);
		ant.insert(3);
		// kill 131 neg cond
		ant.insert(1);

		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(2,2);
		expected.insert(3);

		ant.delete(1);

		assertEquals(expected, ant);
		// kill 132 replace true
		assertFalse(ant.contains(1));
		// kill 152 neg cond
		assertTrue(ant.contains(3));
	}

	// ACUC: compact b)
	@Test
	void testArrayNTreeDeleteGreatestElement() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,2);
		ant.insert(2);
		ant.insert(3);

		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(1,2);
		expected.insert(2);

		ant.delete(3);
		assertEquals(expected, ant);
	}
	
	////////////////////////////////////////////////////////////////
	/////////////////// Juts tests to kill mutations ///////////////
	
	// explore child shift
	// kill 255 change cond boundary
	// 156, 177, 185, 271, 276 unkillable bcs equal case is prev verified
	@Test
	void testArrayNTreeDeleteGreatestElement2() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,3);
		// add more depth to the tree to kill
		// 185 change first cound boundary
		ant.insert(5);
		ant.insert(7);
		ant.insert(4);
		ant.insert(5);
		ant.insert(2);
		ant.insert(5);
		ant.insert(7);
		
		
		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(1,3);
		expected.insert(2);
		expected.insert(4);
		expected.insert(5);
		
		// kill 300 neg cond
		assertNotEquals(ant,expected);

		ant.delete(7);
		assertEquals(expected, ant);
		
		// Kill 292 neg cond
		assertNotEquals(ant, 1);
	}



}
