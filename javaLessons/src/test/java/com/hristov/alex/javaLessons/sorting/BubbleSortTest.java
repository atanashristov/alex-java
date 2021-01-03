package com.hristov.alex.javaLessons.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

	static int[] sortedNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] numbers;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		numbers = new int[] { 1, 2, 9, 8, 6, 7, 4, 5, 3 };
	}

	@AfterEach
	void tearDown() throws Exception {
		numbers = new int[] {};
	}

	@Test
	void sort_testNumbersAreSorted() {
		
		new BubbleSort().sort(numbers);
		
		assertEquals(sortedNumbers.length, numbers.length);
		for (int i=0; i < sortedNumbers.length; i++) {
			assertEquals(sortedNumbers[i], numbers[i]);
		}
	}

	@Test
	void sortImproved_testNumbersAreSorted() {
		
		new BubbleSort().sortImproved(numbers);
		
		assertEquals(sortedNumbers.length, numbers.length);
		for (int i=0; i < sortedNumbers.length; i++) {
			assertEquals(sortedNumbers[i], numbers[i]);
		}
	}

}
