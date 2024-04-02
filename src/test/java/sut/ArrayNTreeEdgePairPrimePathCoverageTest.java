package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeEdgePairPrimePathCoverageTest {

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
	
	////////////////////////////////////////////////////////////////
	
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
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		
		ant.insert(2);
		ant2.insert(2);
		
		assertTrue(ant.equals(ant2));
	}
	
	//PPC: [4,5,4] [5,4,7,9]
	@Test
	public void testArrayNTreeEqualsEqualRootsOnlyRootTreeAndRootWithChildTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		
		ant.insert(2);
		
		assertFalse(ant.equals(ant2));
	}



	/////////////////////////////////////////////
}
