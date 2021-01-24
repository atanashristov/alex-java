package com.hristov.alex.javaLessons.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest_V1 {

	Object[][] _data;
	
	@BeforeEach
	void setUp() throws Exception {
		_data = new Object[][] {
			new Object[] {92800393, "LINNIE GILMAN"},
			new Object[] {86770985, "DUSTY CONFER"},
			new Object[] {31850991, "WANETA DEWEES"},
			new Object[] {46531276, "BRADLY BOMBACI"},
			new Object[] {25428367, "DUSTY BANNON"},
			new Object[] {68682774, "MALIK TULLER"},
			new Object[] {20316453, "TOMASA POWANDA"},
			new Object[] {98698743, "MALIA HOGSTRUM"},
			new Object[] {81528001, "NEAL HOLSTEGE"},
			new Object[] {24248685, "FRANCE COELLO"},
			new Object[] {79430806, "MELVINA CORNEJO"},
			new Object[] {39977566, "CHONG MCOWEN"}
		};
	}

	@AfterEach
	void tearDown() throws Exception {
		_data = null;
	}

	@Test
	void add_shouldAddEntry() {

		HashTable_V1 hashTable = new HashTable_V1(17);
		
		for (int i=0; i < _data.length; i++) {
			hashTable.put(_data[i][0], _data[i][1]);
		}

		for (int i=0; i < _data.length; i++) {
			Object value = hashTable.get(_data[i][0]);
			assertEquals(_data[i][1], value);
		}
	}

	
	@Test
	void add_shouldOverrideEntry() {

		HashTable_V1 hashTable = new HashTable_V1(17);
		
		for (int i=0; i < _data.length; i++) {
			hashTable.put(_data[i][0], _data[i][1]);
		}

		for (int i=0; i < _data.length; i++) {
			hashTable.put(_data[i][0], _data[i][1] + "-1");
		}

		for (int i=0; i < _data.length; i++) {
			Object value = hashTable.get(_data[i][0]);
			assertEquals(_data[i][1] + "-1", value);
		}
	}
	
	@Test
	void toString_returnsNonemptyString() {
		
		HashTable_V1 hashTable = new HashTable_V1(17);
		
		for (int i=0; i < _data.length; i++) {
			hashTable.put(_data[i][0], _data[i][1]);
		}
		
		String s = hashTable.toString();
		
		System.out.println(s);
		
		assertTrue(s != null);
		assertTrue(s.length() > 0);
	}
	
}
