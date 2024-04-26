package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeBaseChoiceCoverageTest {

	// (1)
	@Test
	public void testArrayNTreeEqualsDiffNotNullTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2);
		ant.insert(2);
		ant.insert(1);
		
		ant2.insert(5);
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
		
		// NOT THE OBJECTIVE FOR THE TEST SET
		// kill mutation 156 neg condition
		assertTrue(ant2.min()== 1);
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
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(2);
		ant.insert(4);
		ant.insert(5);
		//lowest val added last to kill
		// 172 remove call
		ant.insert(3);
		
		
		ant2.insert(5);
		ant2.insert(4);
		ant2.insert(3);
		ant2.insert(4);
		// kill -> 123 neg condition
		ant2.insert(5);
		
		
		assertTrue(ant.equals(ant2));
	}
	
	// (6)
	@Test
	public void testArrayNTreeEqualsThisSubsetOther() {
		// Put same root to kill 126 neg condition
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,2);
		ant.insert(3);
		
		// add 5 early and again later to kill 131 neg condtion
		// 131 conditional boundary is unkillable bcs the equal case is alredy checked
		ant2.insert(5);
		ant2.insert(4);
		
		ant2.insert(3);
		ant2.insert(5);
		ant2.insert(6);
		
		assertFalse(ant.equals(ant2));
	}
	
	/////////////////////////////////////////////////////////////////////////
	/////////////////// Just tests to kill mutations ////////////////////////
	
	// kill 177 neg cond and 179 remove call mutation
	// 177,185,271,276 boudnary change unkillable bcs equals case is verified earleir
	@Test
	public void testArrayNTreeEqualsThisEqualsOther2() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,2);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,2);
		ant.insert(3);
		ant.insert(4);
		ant.insert(5);
		ant.insert(6);
		
		ant2.insert(5);
		ant2.insert(4);
		
		ant2.insert(3);
		ant2.insert(5);
		ant2.insert(6);
		
		
		assertTrue(ant.equals(ant2));
	}
	
	// Test for more depth testing of children shifting
	// kill 273 dec to inc mutations
	@Test
	public void testArrayNTreeEqualsThisEqualsOther3() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,3);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,3);
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
	
}
