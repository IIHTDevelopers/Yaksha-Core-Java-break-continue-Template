package com.yaksha.assignment;

public class BreakContinueAssignment {

	public static void main(String[] args) {

		// Task 1: Print Numbers until a Specific Condition is Met (Break Keyword)
		System.out.println("Task 1: Print Numbers until a Specific Condition is Met (Break)");
		for (int i = 1; i <= 10; i++) {
			if (i > 5) {
				break;
			}
			System.out.println(i);
		}

		// Task 2: Skip Even Numbers (Continue Keyword)
		System.out.println("\nTask 2: Skip Even Numbers (Continue)");
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}

		// Task 3: Find First Odd Number Greater than a Given Value (Break Keyword)
		System.out.println("\nTask 3: Find First Odd Number Greater than a Given Value (Break)");
		for (int i = 1; i <= 20; i++) {
			if (i > 15 && i % 2 != 0) {
				System.out.println(i);
				break;
			}
		}

		// Task 4: Skip Specific Number (Continue Keyword)
		System.out.println("\nTask 4: Skip Specific Number (Continue)");
		for (int i = 1; i <= 10; i++) {
			if (i == 7) {
				continue;
			}
			System.out.println(i);
		}

		// Task 5: Print Numbers and Skip Multiples of 3 (Continue Keyword)
		System.out.println("\nTask 5: Print Numbers and Skip Multiples of 3 (Continue)");
		for (int i = 1; i <= 20; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
