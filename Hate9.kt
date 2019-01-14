import java.util.*;
import java.io.*;
import java.math.*;

fun main(args: Array<String>) {

	val scanner = java.util.Scanner(System.`in`)

	val size : Int = scanner.nextInt();
	val digitArray = LongArray(size);
	//for loop to put digits into array
	for( i in 0 until size) {
		digitArray[i] = scanner.nextLong();
	}
	//for loop to print out items in the array
	for( i in 0 until size) {
		System.out.println(nineChecker(digitArray[i]));
	}
	
}

//function that checks how many 9s are in d digits
fun nineChecker(d : Long) : Long {
	if (d == 1.toLong()) {
		return 8;
	}
	else {
	return (Math.floorMod(8 * modCalc(9,d-1,1000000007), 1000000007));
	}
}
//modified repeated squaring function
fun modCalc(base : Long , exp : Long , mod : Long ) : Long {
	var x : Long = 1;
	var newBase = base
	var newExp = exp
	while(newExp > 0) {
		//odd case
		if (Math.floorMod(newExp, 2) != 0.toLong()) {
			x = Math.floorMod(x * newBase, mod);
		}
		newBase = Math.floorMod(newBase * newBase,mod);
		newExp = Math.floorDiv(newExp, 2);
	}
	return x;
}
/*
public class Hate9 {
	
	
	
	private static Scanner scan;

	//function that checks how many 9s are in d digits
	public static long nineChecker(long d) {
		if (d == 1) {
			return 8;
		}
		else {
		return (Math.floorMod(8 * modCalc(9,d-1,1000000007), 1000000007));
		}
	}
	
	//modified repeated squaring function
	public static long modCalc(long base, long exp, long mod) {
		long x = 1;
		while(exp > 0) {
			//odd case
			if (Math.floorMod(exp, 2) != 0) {
				x = Math.floorMod(x * base, mod);
			}
			base = Math.floorMod(base * base,mod);
			exp = Math.floorDiv(exp, 2);
		}
		return x;
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int size = scan.nextInt();
		long [] digitArray = new long[size];
		//for loop to put digits into array
		for(int i = 0; i<size;i++) {
			digitArray[i] = scan.nextLong();
		}
		//for loop to print out items in the array
		for(int i = 0; i<size;i++) {
			System.out.println(nineChecker(digitArray[i]));
		}
	}
	
}*/