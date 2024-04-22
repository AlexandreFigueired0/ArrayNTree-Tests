package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeBaseChoiceCoverageTest {

	// (1)
	@Test
	public void testArrayNTreeEqualsDiffNotNullTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(5,2);
		ant.insert(2);
		ant2.insert(8);
		ant2.insert(11);

		assertFalse(ant.equals(ant2));
	}

	// (2)
	@Test
	public void testArrayNTreeEqualsThisEmpty() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		ant2.insert(3);
		
		assertFalse(ant.equals(ant2));
	}
	
	// (3)
	@Test
	public void testArrayNTreeEqualsOtherEmpty() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		ant.insert(5);
		ant.insert(6);
		
		assertFalse(ant.equals(ant2));
	}
	
	// (5)
	@Test
	public void testArrayNTreeEqualsThisEqualsOther() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(3,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(3,2);
		ant.insert(4);
		ant.insert(5);
		ant2.insert(4);
		ant2.insert(5);
		
		assertTrue(ant.equals(ant2));
	}
	
	// (6)
	@Test
	public void testArrayNTreeEqualsThisSubsetOther() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(3,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,2);
		ant.insert(4);
		ant2.insert(3);
		ant2.insert(4);
		ant2.insert(5);
		ant2.insert(6);
		System.out.println(ant2);
		
		assertFalse(ant.equals(ant2));
	}
}
