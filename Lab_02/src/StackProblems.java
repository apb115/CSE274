
// Andrew Boothe
// Lab-02

import java.util.Arrays;

public class StackProblems {

	public static void main(String[] args) {

		// Do initial testing here.
		// For example, here is a basic test of the sum method:
		ArrayStack<Integer> stk;
		ArrayStack<Integer> stk2;

		stk2 = new ArrayStack<>();
		stk2.push(3);
		stk2.push(4);
		stk2.push(5);
		stk2.push(6);
		
		
		stk = new ArrayStack<>();
		stk.push(4);
		stk.push(1);
		stk.push(2);
		stk.push(2);
		stk.push(7);
		stk.push(2);
		stk.push(8);
		stk.push(8);
		stk.push(8);
		stk.push(4);

		//================================================================ Tests
		//System.out.println("46? " + sum(stk));
		//System.out.print("28?" + sumSkipDuplicates(stk));
		//System.out.println(stringToStack("41aa22728884"));		

		//pushUnder(stk2, 7);
		//System.out.println(stk2);
		//System.out.println(copyStack(stk));
		//System.out.println(stk);
		//reverseStack(stk);
		//System.out.println(stk);

		//transfer(stk, stk2);
		//System.out.println(stk);
		//System.out.println(stk2);

		//System.out.println(isPalindrome("1451"));

	}

	/*
	 * Computes the sum of all the numbers in the ArrayStack. 
	 * It's okay to destroy the ArrayStack in the process.
	 */
	public static int sum(ArrayStack<Integer> data) {
		int sum = 0;
		while (!data.isEmpty()) {
			sum += data.pop();
		}
		return sum;
	}

	/*
	 * Puts an integer under the top item in an ArrayStack. 
	 * If the ArrayStack is empty, just put the item on the top. 
	 * For example: if 		stk starting at the top is: 7, 8, 5, 11, 
	 * 				then 	pushUnder(stk, 20) would result in: 7, 20, 8, 5, 11
	 * 
	 * For example: if 		stk is empty,  
	 * 				then 	pushUnder(stk, 20) would result in: 20
	 */
	public static void pushUnder(ArrayStack<Integer> data, int value) {
		if(data.isEmpty()) data.push(value);
		else {
			int top = data.pop();
			data.push(value);
			data.push(top);
		}
	}


	/*
	 * Computes the sum of all the numbers in the ArrayStack. However, if two or
	 * more numbers in a row are equal, only add one of them. So, for example, if the
	 * ArrayStack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(ArrayStack<Integer> data) {
		int sum = 0;
		int lastRead = 0, newRead = 0;
		if (!(data.isEmpty())) {
			lastRead = data.pop();
			sum += lastRead;
		}
		while (!(data.isEmpty())) {
			newRead = data.pop();
			sum += (newRead == lastRead ? 0 : newRead);
			lastRead = newRead;

		}
		return sum;
	}

	/*
	 * Puts all of the characters of a string into an ArrayStack, with the first
	 * character of the string at the bottom of the ArrayStack and the last character
	 * of the string at the top of the ArrayStack.
	 */
	public static ArrayStack<Character> stringToStack(String s) {
		ArrayStack<Character> stk = new ArrayStack<>();
		for (int i = 0; i < s.length(); i++) {
			stk.push(s.charAt(i));
		}
		return stk;
	}

	/*
	 * Returns an exact copy of the given ArrayStack.  At the end of this method
	 * the original stack should be the same as when it started, and a new copy
	 * of that ArrayStack should be returned.  YOU MAY USE ADDITIONAL ArrayStacks AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static ArrayStack<Integer> copyStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> result = new ArrayStack<>();
		ArrayStack<Integer> temp = new ArrayStack<>();
		reverseStack(s);
		temp = s;
		reverseStack(temp);
		result = temp;
		
		return result;


	}

	/*
	 * Reverses a given ArrayStack, so that the top of the ArrayStack becomes the bottom
	 * and the bottom becomes the top. YOU MAY USE ADDITIONAL ArrayStack AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static void reverseStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> rev = new ArrayStack<>();
		ArrayStack<Integer> fwd = new ArrayStack<>();
		// pop from fwd, push to rev
		transfer(s, rev);
		transfer(rev, fwd);
		transfer(fwd, s);

	}

	private static void transfer(ArrayStack<Integer> rev, ArrayStack<Integer> fwd) {
		while(!(rev.isEmpty())) {
			fwd.push(rev.pop());
		}

	}

	/*
	 * A palindrome reads the same forward and backward. Use an ArrayStack to
	 * determine if a given string is a palindrome. Challenge: try not to use
	 * any additional variables (except a counter for any loop). Just the given
	 * string and an ArrayStack of Characters.
	 */
	public static boolean isPalindrome(String s) {
		ArrayStack<Character> ltrs = new ArrayStack<>();
		for (int i = 0; i < s.length(); i++) {
			ltrs.push(s.charAt(i));
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ltrs.pop()) return false;
		}

		return true;
	}

}
