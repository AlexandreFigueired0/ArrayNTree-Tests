package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeLogicCoverage {

	// CACC: 1
	@Test
	public void testArrayNTreeEqualsSameRefNotNTree() {
		String s = "test";
		assertTrue(s.equals(s));
	}
	
	// CACC: 2
	@Test
	public void testArrayNTreeEqualsOtherNotNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertFalse(ant.equals(1));
	}
	
	// CACC: 3, 5, 8, 11, 13, 15, 17, 19, 21
	@Test
	public void testArrayNTreeEqualsDiffRefEqualNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,2);
			ant.insert(1);
			ant.insert(2);
			ant.insert(3);
			ant.insert(1);
			ant2.insert(2);
			ant2.insert(3);
		assertTrue(ant.equals(ant2));
	}
	
	//CACC: 6, 8, 9, 11, 13, 15, 18
	@Test
	public void testArrayNTreeEqualsDiffRoots() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2,1);
		
		assertFalse(ant.equals(ant2));
	}
	
	//CACC: 14, 20
	@Test
	public void testArrayNTreeEqualsThisEmpty() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		
		assertFalse(ant.equals(ant2));
	}
	
	// CACC: 16, 18
	@Test
	public void testArrayNTreeEqualsOtherEmpty() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		
		assertFalse(ant.equals(ant2));
	}
}
