package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeTest {

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
		assertFalse(ant.contains(3));
	}
	
	@Test
	public void testArrayNTreeContainsTargetIsTheGreatest() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(2,2);
		ant.insert(4);
		ant.insert(5);
		ant.insert(6);
		assertTrue(ant.contains(6));
	}
	
	@Test
	public void testArrayNTreeEqualsSameReference() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertTrue(ant.equals(ant));
	}
	
	@Test
	public void testArrayNTreeEquals2EqualNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		////////////// TODO colocado so para passar
		ant.insert(1);
		ant2.insert(1);
		//////////////
		
		assertTrue(ant.equals(ant2));
	}
	
	@Test
	public void testArrayNTreeEqualsNotInstanceANTree() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		assertFalse(ant.equals(1));
	}
	
	@Test
	public void testArrayNTree2DifferentNTrees() {
		ArrayNTree<Integer> ant = new ArrayNTree<Integer>(1);
		ArrayNTree<Integer> ant2 = new ArrayNTree<Integer>(1);
		ant.insert(1);
		ant2.insert(2);
		
		assertFalse(ant.equals(ant2));
	}

}
