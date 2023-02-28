package com.java;

public class Test {
	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 5, 4 };
		int temp = 0;

		System.out.println("The Original Array is : ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n");

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("The Sorted Array is : ");
		for (int b : a) {
			System.out.print(b + " ");
		}
	}
}
