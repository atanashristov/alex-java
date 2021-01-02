package com.hristov.alex.javaLessons.sorting;

/*
 * Bubble sorting
 * 
 * Involves three tasks:
 * - repeatedly stepping through the list to sort
 * - compare adjacent elements
 * - swap them around if the first element is bigger  
 * 
 */
public class BubbleSort {

	public void sort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

}
