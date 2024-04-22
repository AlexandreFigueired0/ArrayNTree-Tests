package sut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;


@RunWith(JUnitQuickcheck.class)
public class ArrayNTreePropertyBasedTest {

	// @InRange for the size of the tree

	//1
	@Property
	public void propShuffledInsertsDontBreakInvariant(@From(ArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
		List<Integer> toInsert = tree.toList();
		Collections.shuffle(toInsert);
		ArrayNTree<Integer> tree2 = new ArrayNTree<Integer>(3); 

		for(int i : toInsert) {
			tree2.insert(i);
		}

		assertTrue(invariant(tree2));
	}

	//2
	@Property
	public void propRemovingAllElementsResultsEmptyTree(@From(ArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
		List<Integer> treeList = tree.toList();

		for(int i : treeList) {
			tree.delete(i);
		}

		assertTrue(tree.isEmpty());
	}

	//3
	@Property
	public void propInsertAndRemoveElemDoesntChangeOtherElems(@From(ArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
		List<Integer> startTreeElems = tree.toList();

		tree.insert(1);
		tree.delete(1);

		List<Integer> afterTreeElems = tree.toList();

		assertEquals(startTreeElems,afterTreeElems);
	}

	//4
	@Property
	public void propInsertItsElemsDoesNothing(@From(ArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
		List<Integer> startTreeElems = tree.toList();

		for(int i : startTreeElems) {
			tree.insert(i);
		}

		List<Integer> afterTreeElems = tree.toList();
		assertEquals(startTreeElems,afterTreeElems);
	}

	//5
	@Property
	public void propInsertElemSeveralTimesDoesNothing(@From(ArrayNTreeGenerator.class) ArrayNTree<Integer> tree) {
		// Guarantee 1 is there
		tree.insert(1);
		List<Integer> startTreeElems = tree.toList();

		for(int i = 0; i<15; i++) {
			tree.insert(1);
		}

		List<Integer> afterTreeElems = tree.toList();
		assertEquals(startTreeElems,afterTreeElems);
	}




	private boolean invariant(ArrayNTree<Integer> tree) {
		List<Integer> treeList = tree.toList();
		for (int i = 1; i < treeList.size(); i++) {
			if (treeList.get(i-1) >= treeList.get(i)) {
				return false;
			}
		}

		return true;
	}



}