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
	
	@Test
	void runTestLabTwo() {

		Object[][] data = new Object[][] {
			new Object[] {86770985, "DUSTY CONFER"},
			new Object[] {31850991, "WANETA DEWEES"},
			new Object[] {46531276, "BRADLY BOMBACI"},
			new Object[] {25428367, "DUSTY BANNON"},
			new Object[] {68682774, "MALIK TULLER"},
			new Object[] {18088219, "PENNY JOTBLAD"},
			new Object[] {48235250, "KENNITH GRASSMYER"},
			new Object[] {20316453, "TOMASA POWANDA"},
			new Object[] {54920021, "TYSON COLBETH"},
			new Object[] {98698743, "MALIA HOGSTRUM"},
			new Object[] {22806858, "LAVERNE WOLNIK"},
			new Object[] {32244214, "SHEMEKA HALLOWAY"},
			new Object[] {81528001, "NEAL HOLSTEGE"},
			new Object[] {24248685, "FRANCE COELLO"},
			new Object[] {23331143, "JUSTIN ADKIN"},
			new Object[] {79430806, "MELVINA CORNEJO"},
			new Object[] {89392483, "SCOTTY BREINING"},
			new Object[] {44040859, "JOLYNN TULLEY"},
			new Object[] {39977566, "CHONG MCOWEN"},
			new Object[] {59245514, "LESLEE PHIFER"},
			new Object[] {64357276, "SCOT PARREIRA"},
			new Object[] {37487223, "EASTER HENNIGAN"},
			new Object[] {50725704, "GENARO QUIDER"},
			new Object[] {52298576, "AUDIE UNCAPHER"},
			new Object[] {54657809, "MARTY ENOCHS"},
			new Object[] {47186566, "FONDA KUBSCH"},
			new Object[] {96077293, "MURRAY STAGNO"},
			new Object[] {54526749, "TOBI HEATLEY"},
			new Object[] {24903965, "ALONSO GILSTAD"},
			new Object[] {84936051, "DEONNA STRAZZA"},
			new Object[] {25559522, "MOISES FELGENHAUER"},
			new Object[] {89785663, "FLORENCE RYBICKI"},
			new Object[] {59376623, "TODD MALICOAT"},
			new Object[] {48235144, "DEBROAH FUTTER"},
			new Object[] {62522327, "AHMAD THAYER"},
			new Object[] {67765348, "VESTA DEWEESE"},
			new Object[] {28967368, "ERWIN GALLMAN"},
			new Object[] {20971827, "SUSANNA CORNEIL"},
			new Object[] {36045405, "KEVIN GUNKELMAN"},
			new Object[] {79037640, "DUSTI MOSQUERA"},
			new Object[] {90572271, "ELIJAH METEVIER"},
			new Object[] {84018568, "SEE AHSING"},
			new Object[] {28311867, "ROGELIO KINGFISHER"},
			new Object[] {88475094, "SUSANNE CORROW"},
			new Object[] {88999386, "ISMAEL ELKAN"},
			new Object[] {10747952, "TOBY PRUCHNIK"},
			new Object[] {80872518, "AL WILLIVER"},
			new Object[] {36569784, "CHARLOTTE WHISENAND"},
			new Object[] {32375158, "EMILIO VANDERHORST"},
			new Object[] {30540107, "MALIKA BELLIVEAU"}			
		};

 		HashTable hashTable = new HashTable(101);

		for (int i=0; i < data.length; i++) {
			hashTable.put(data[i][0], data[i][1]);
		}
		
		System.out.println("---- ARRAY STATE AFTER PUTS ----");
		System.out.println();
		System.out.println(hashTable.toString());
		
		hashTable.remove(67765348);
		hashTable.remove(88999386);
		hashTable.remove(44040859);
		hashTable.remove(30540107);
		hashTable.remove(98698743);
		hashTable.remove(50725704);
		hashTable.remove(20971827);
		hashTable.remove(81528001);
		hashTable.remove(32244214);
		hashTable.remove(28967368);			
		
		System.out.println("---- ARRAY STATE AFTER REMOVES ----");
		System.out.println();
		System.out.println(hashTable.toString());
		
		hashTable.put(90572271, "EVAN CLASBY");
		hashTable.put(88475094, "JANET TYTLER");
		hashTable.put(36569784, "THURMAN TULLOS");
		hashTable.put(31850991, "RANDAL SIPTAK");
		hashTable.put(37487223, "OWEN IWAOKA");

		System.out.println("---- ARRAY STATE AFTER OVERWRITING PUTS ----");
		System.out.println();
		System.out.println(hashTable.toString());
		
	}
	
}
