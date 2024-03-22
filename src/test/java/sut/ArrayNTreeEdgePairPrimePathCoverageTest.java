package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeEdgePairPrimePathCoverageTest {

	@Test
	public void testArrayNTreeEqualsSameRef() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(0);
		assertTrue(ant.equals(ant));
	}
	
	
	@Test
	public void testArrayNTreeEqualsOtherNotNTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		assertFalse(ant.equals(1));
	}
	
	@Test
	public void testArrayNTreeEqualsEqualNTreesDiffRef() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1,1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1,1);
		
		assertTrue(ant.equals(ant2));
		
	}

}
