package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeEdgePairPrimePathCoverageTest {

	// Best effort EPC: [0,1]
	// Best effort PPC: [0,1]
	@Test
	public void testArrayNTreeSameRefTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertTrue(ant.equals(ant));
	}
	
	// Best effort EPC: [0,2,9]
	// Best effort PPC: [0,2,9]
	@Test
	public void testArrayNTreeEquals2EmptyNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = null;

		assertFalse(ant.equals(ant2));
	}
	
	// EPC: [0,2,3] [2,3,4] [3,4,5] [4,5,4] [5,4,5] [4,5,6]
	@Test
	public void testArrayNTreeEqualsFirstChildDiff() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		ant.insert(2);
		ant2.insert(3);
		
		assertFalse(ant.equals(ant2));
	}
	
	// EPC: [0,2,3] [2,3,4] [3,4,7] [4,7,8]
	// PPC: [0,2,3,4,7,8]
	@Test
	public void testArrayNTreeEqualsEmptyTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		
		assertTrue(ant.equals(ant2));
	}
	
	// EPC: [0,2,3] [2,3,4][3,4,5] [4,5,4] [5,4,7] [4,7,8]
	@Test
	public void testArrayNTreeEqualsSingleEqualRoots() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		
		assertTrue(ant.equals(ant2));
	}
	
	// EPC: [0,2,3] [2,3,4]	[3,4,7] [4,7,9]
	// PPC: [0,2,3,4,7,9]
	@Test
	public void testArrayNTreeEqualsOneEmptyTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		
		assertFalse(ant.equals(ant2));
	}
	
	
	// PPC: [0,2,3,4,5,6]
	@Test
	public void testArrayNTreeEqualsRootDifferent() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2,1);
		
		assertFalse(ant.equals(ant2));
	}
	
	//PPC: [4,5,4] [5,4,5] [5,4,7,8]
	@Test
	public void testArrayNTreeEquals2EqualTreesWith2Elems() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2);
		ant.insert(2);
		ant.insert(1);
		ant.insert(1);
		
		ant2.insert(2);
		ant2.insert(1);
		
		assertTrue(ant.equals(ant2));
		
		
		// 156 cond bound unkillable cause the equals case is
		// previously verified
		// ASSERT NOT RELATED TO THE OBJECTIVE OF THE TEST SET!
		// Necessary to kill 156 cond negation
		assertTrue(ant.min() == 1);
	}
	
	//PPC: [4,5,4] [5,4,7,9]
	@Test
	public void testArrayNTreeEqualsEqualRootsOnlyRootTreeAndRootWithChildTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		
		ant.insert(2);
		
		assertFalse(ant.equals(ant2));
	}




}
