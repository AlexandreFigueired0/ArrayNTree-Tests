package sut;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;


public class ArrayNTreeGenerator extends Generator<ArrayNTree<Integer>>{

	
    public ArrayNTreeGenerator(Class<ArrayNTree<Integer>> type) {
		super(type);
	}

	private int min =  0;
    private int max = 20;
    
    // generator respects `@InRange` annotation, defining the size of the tree
    public void configure(InRange range) {
        min = range.minInt();
        max = range.maxInt();
    }

	@Override
	public ArrayNTree<Integer> generate(SourceOfRandomness random, GenerationStatus status) {
		ArrayNTree<Integer> res = new ArrayNTree<Integer>(random.nextInt(1,10));
		
		int size = random.nextInt(min, max);
		
		for(int i = 0; i< size; i++) {
			res.insert(random.nextInt());
		}
		
		return res;
	}

}
