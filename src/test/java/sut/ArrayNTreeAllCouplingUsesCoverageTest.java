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

	// ACUC: compact a)
	@Test
	void testArrayNTreeDeleteRootWithChildren() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,2);
		ant.insert(2);
		ant.insert(3);

		ArrayNTree<Integer> expected = new ArrayNTree<Integer>(2,2);
		expected.insert(3);

		ant.delete(1);
		assertEquals(expected, ant);
	}

}
