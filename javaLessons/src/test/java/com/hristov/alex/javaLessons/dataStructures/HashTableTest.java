package com.hristov.alex.javaLessons.dataStructures;

import org.junit.jupiter.api.Test;

public class HashTableTest {

	@Test
	void runTestLab() {

		Object[][] data = new Object[][] {
			new Object[] {92800393, "LINNIE GILMAN"},
			new Object[] {86770985, "DUSTY CONFER"},
			new Object[] {48235250, "KENNITH GRASSMYER"},
			new Object[] {31850991, "WANETA DEWEES"},
			new Object[] {25428367, "DUSTY BANNON"},
			new Object[] {24248685, "FRANCE COELLO"},
			new Object[] {23331143, "JUSTIN ADKIN"},
			new Object[] {68682774, "MALIK TULLER"},
			new Object[] {59245514, "LESLEE PHIFER"},
			new Object[] {24248685, "ISAAC GENEY"},
		};

 		HashTable hashTable = new HashTable(17);

		for (int i=0; i < data.length; i++) {
			hashTable.put(data[i][0], data[i][1]);
		}
		
		System.out.println("---- ARRAY STATE AFTER PUTS ----");
		System.out.println();
		System.out.println(hashTable.toString());

		hashTable.remove(25428367);
		hashTable.remove(68682774);
		
		System.out.println("---- ARRAY STATE AFTER REMOVES ----");
		System.out.println();
		System.out.println(hashTable.toString());

		hashTable.put(54657809, "MARTY ENOCHS");
		
		System.out.println("---- ARRAY STATE AFTER PUT ----");
		System.out.println();
		System.out.println(hashTable.toString());

		hashTable.remove(23331143);

		System.out.println("---- ARRAY STATE AFTER REMOVE ----");
		System.out.println();
		System.out.println(hashTable.toString());
		
		hashTable.put(59245514, "GENARO QUIDER");

		System.out.println("---- ARRAY STATE AFTER FINAL ADD ----");
		System.out.println();
		System.out.println(hashTable.toString());

		System.out.println("---- GET TESTS ----");
		System.out.println();
		System.out.println(hashTable.get(24248685));
		System.out.println(hashTable.get(54657809));
		System.out.println(hashTable.get(59245514));
		System.out.println(hashTable.get(23331143));
		System.out.println(hashTable.get(31850991));
	}
}
