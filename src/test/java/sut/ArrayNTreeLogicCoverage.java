package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeLogicCoverage {
	
	// CACC: 2
	@Test
	public void testArrayNTreeEqualsOtherNotNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertFalse(ant.equals(1));
	}
	
	// CACC: 3, 5, 8, 11, 13, 15, 17, 19, 21
	@Test
	public void testArrayNTreeEqualsDiffRefEqualNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,2);
		ant.insert(2);
		ant.insert(3);
		// kill 132 replace return with true
		ant.insert(1);
		
		ant2.insert(3);
		ant2.insert(2);
		// kill 123 neg cond
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
	
	/////////////////////////////////////////////////////////////////////////
	/////////////////// Just tests to kill mutations ////////////////////////
	
	// kill 177 neg cond and 179 remove call mutation
	// 156,177,185,271,276 boudnary change unkillable bcs equals case is verified earleir
	@Test
	public void testArrayNTreeEqualsDiffRefEqualNTrees2() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(3);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,3);
		ant.insert(1);
		
		ant.insert(3);
		ant.insert(4);
		ant.insert(5);
		
		ant.insert(6);
		
		
		ant2.insert(5);
		ant2.insert(4);
		
		ant2.insert(5);
		ant2.insert(6);
		ant2.insert(3);
		
		assertTrue(ant.equals(ant2));
	}
	
	// more ways to shift children
	// kill 185 neg cond
	@Test
	public void testArrayNTreeEqualsDiffRefEqualNTrees3() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(3);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,3);
		ant.insert(1);
		
		// shuffled inert order to occurr shift in the middle
		ant.insert(5);
		ant.insert(3);
		ant.insert(4);
		
		ant.insert(6);
		
		
		ant2.insert(5);
		ant2.insert(4);
		
		ant2.insert(5);
		ant2.insert(6);
		ant2.insert(3);
		
		assertTrue(ant.equals(ant2));
	}
	

	
	// kill 161 remove call
	@Test
	public void testArrayNTreeEqualsDiffTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		
		ant.insert(2);
		
		ant2.insert(3);
		
		assertFalse(ant.equals(ant2));
	}
	
	// kill 139 neg conditions
	@Test
	public void testArrayNTreeEqualsDiffTrees2() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,3);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,3);
		
		ant.insert(2);
		ant.insert(3);
		
		ant2.insert(4);
		ant2.insert(5);
		ant2.insert(2);
		
		
		assertFalse(ant.equals(ant2));
	}
	
	

}
