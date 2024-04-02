package sut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayNTreeAllCouplingUsesCoverageTest {

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
