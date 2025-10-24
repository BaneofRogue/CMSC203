// William Keller CMSC 204 HashLab

import java.util.Arrays;

public class HashLab {
	

	public static void main(String[] args) {
		
		int[] unfiltered_keys = {27, 53, 13, 10, 138, 109, 49, 174, 26, 24};
		
		System.out.println("Unfiltered Keys:");
		System.out.println(Arrays.toString(unfiltered_keys));
		System.out.println("LQ Hashed Keys: ");
		System.out.println(Arrays.toString(LQHasher(unfiltered_keys)));
		System.out.println("Bucket Hashed Keys: ");
		System.out.println(Arrays.toString(BucketHasher(unfiltered_keys)));
		
	}
	
	public static int[] LQHasher(int[] keys) {
		int N = 13; // Never modified!
		int prime_4k = 19; // I don't know what this is but...
		
		int[] sorted_keys = new int[N];
		
		for(int key : keys) {
			int index_position = key % N;
			int q = key / N;
			int offset = 0;
			if(q%N != 0) {
				offset = q;
			} else {
				offset = prime_4k;
			}
			while(sorted_keys[index_position] != 0) { // while occupied
				index_position = (index_position + offset) % N;
			}
			sorted_keys[index_position] = key; // set it
		}
		return sorted_keys;
	}
	
	public static int[] BucketHasher(int[] keys) {
		int N = 10;
		
		int[] sorted_keys = new int[N];
		
		for(int key : keys) {
			sorted_keys[key % N] = key;
		}
		
		return sorted_keys;
	}
}
