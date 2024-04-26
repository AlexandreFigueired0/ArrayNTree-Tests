package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeLineBranchCoverageTest {

	@Test
	public void testArrayNTreeContainsEmptyTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertFalse(ant.contains(1));
	}

	@Test
	public void testArrayNTreeContainsTargetIsRoot() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,1);
		assertTrue(ant.contains(2));
	}

	@Test
	public void testArrayNTreeContainsTargetNotIn2Levels() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,1);
		ant.insert(4);
		assertFalse(ant.contains(3));
	}

	@Test
	public void testArrayNTreeContainsTargetNotIn3Levels() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,1);
		ant.insert(4);
		ant.insert(5);
		// searched for 3, but after PIT, concluded 7 is better
		assertFalse(ant.contains(7));
	}

	@Test
	public void testArrayNTreeContainsTargetIsTheGreatest() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2);
		ant.insert(2);
		ant.insert(5);
		ant.insert(4); // put this down to kill mutations in insert
		ant.insert(6);
		assertTrue(ant.contains(6));
	}
	
	

	@Test
	public void testArrayNTreeContainsTargetIsSecondLowestInThirdLevel() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,2);
		ant.insert(10);
		ant.insert(11);
		ant.insert(12);
		ant.insert(3);
		assertTrue(ant.contains(3));
	}

	////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// Equals ///////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testArrayNTreeEqualsSameReference() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertTrue(ant.equals(ant));
	}

	@Test
	public void testArrayNTreeEquals2EmptyNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);

		assertTrue(ant.equals(ant2));
	}

	// Added after mutation testing (swap sub-tree roots)
	// 156,177,185,271,276 
	// boundary mutation are unkillable bcs the equals case is dealt with
	// previously
	@Test
	public void testArrayNTreeEqualsThisEqualsOther() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2,2);
		ant.insert(5);
		ant.insert(6);
		ant.insert(4);
		ant2.insert(5);
		ant2.insert(4);
		ant2.insert(6);

		assertTrue(ant.equals(ant2));
	}

	///////////////////////////////////////////
	// Added for mutation testing
	// shift children
	@Test
	public void testArrayNTreeEqualsThisEqualsOther2() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,3);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2,3);
		ant.insert(5);
		ant.insert(6);
		ant.insert(4);
		ant2.insert(4);
		ant2.insert(5);
		ant2.insert(6);

		assertTrue(ant.equals(ant2));
	}

	@Test
	public void testArrayNTreeEqualsNotInstanceANTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertFalse(ant.equals(1));
	}

	@Test
	public void testArrayNTreeEqualsDifferentContentSameStructure() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		ant.insert(1);
		ant2.insert(2);

		assertFalse(ant.equals(ant2));
	}

	@Test
	public void testArrayNTreeEqualsThisLargerThanOther() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		ant.insert(1);
		ant.insert(2);
		ant2.insert(1);

		assertFalse(ant.equals(ant2));
	}

	@Test
	public void testArrayNTreeEqualsOtherLargerThanThis() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		ant.insert(1);
		ant2.insert(1);
		ant2.insert(2);

		assertFalse(ant.equals(ant2));
	}



}
