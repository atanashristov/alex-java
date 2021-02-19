package com.hristov.alex.javaLessons.dataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HashTable_Lab2_UnitTests {

	private List<String> getExpected() {
		List<String> list = new ArrayList<String>();
		list.add("---- ARRAY STATE AFTER PUTS ----");
		list.add("");
		list.add("000 : 20316453 TOMASA POWANDA");
		list.add("001 : 25428367 DUSTY BANNON");
		list.add("002 : 84936051 DEONNA STRAZZA");
		list.add("003 : 84018568 SEE AHSING");
		list.add("004 : 67765348 VESTA DEWEESE");
		list.add("005 : 88475094 SUSANNE CORROW");
		list.add("006 : 88999386 ISMAEL ELKAN");
		list.add("007 : 80872518 AL WILLIVER");
		list.add("008 : 36569784 CHARLOTTE WHISENAND");
		list.add("009 : 89392483 SCOTTY BREINING");
		list.add("010");
		list.add("011 : 44040859 JOLYNN TULLEY");
		list.add("012 : 32375158 EMILIO VANDERHORST");
		list.add("013");
		list.add("014");
		list.add("015");
		list.add("016 : 90572271 ELIJAH METEVIER");
		list.add("017");
		list.add("018");
		list.add("019");
		list.add("020 : 36045405 KEVIN GUNKELMAN");
		list.add("021");
		list.add("022");
		list.add("023");
		list.add("024");
		list.add("025 : 59245514 LESLEE PHIFER");
		list.add("026");
		list.add("027");
		list.add("028 : 18088219 PENNY JOTBLAD");
		list.add("029 : 98698743 MALIA HOGSTRUM");
		list.add("030 : 30540107 MALIKA BELLIVEAU");
		list.add("031");
		list.add("032");
		list.add("033 : 96077293 MURRAY STAGNO");
		list.add("034");
		list.add("035 : 31850991 WANETA DEWEES");
		list.add("036 : 59376623 TODD MALICOAT");
		list.add("037 : 10747952 TOBY PRUCHNIK");
		list.add("038");
		list.add("039");
		list.add("040");
		list.add("041");
		list.add("042 : 23331143 JUSTIN ADKIN");
		list.add("043 : 54657809 MARTY ENOCHS");
		list.add("044");
		list.add("045");
		list.add("046");
		list.add("047 : 68682774 MALIK TULLER");
		list.add("048 : 22806858 LAVERNE WOLNIK");
		list.add("049 : 39977566 CHONG MCOWEN");
		list.add("050");
		list.add("051");
		list.add("052 : 28311867 ROGELIO KINGFISHER");
		list.add("053");
		list.add("054");
		list.add("055");
		list.add("056");
		list.add("057");
		list.add("058 : 25559522 MOISES FELGENHAUER");
		list.add("059 : 54920021 TYSON COLBETH");
		list.add("060");
		list.add("061");
		list.add("062");
		list.add("063 : 79430806 MELVINA CORNEJO");
		list.add("064 : 37487223 EASTER HENNIGAN");
		list.add("065 : 32244214 SHEMEKA HALLOWAY");
		list.add("066 : 28967368 ERWIN GALLMAN");
		list.add("067 : 86770985 DUSTY CONFER");
		list.add("068");
		list.add("069 : 52298576 AUDIE UNCAPHER");
		list.add("070 : 50725704 GENARO QUIDER");
		list.add("071 : 46531276 BRADLY BOMBACI");
		list.add("072 : 48235144 DEBROAH FUTTER");
		list.add("073 : 47186566 FONDA KUBSCH");
		list.add("074 : 48235250 KENNITH GRASSMYER");
		list.add("075");
		list.add("076 : 64357276 SCOT PARREIRA");
		list.add("077");
		list.add("078");
		list.add("079");
		list.add("080");
		list.add("081 : 54526749 TOBI HEATLEY");
		list.add("082");
		list.add("083");
		list.add("084");
		list.add("085");
		list.add("086 : 20971827 SUSANNA CORNEIL");
		list.add("087");
		list.add("088");
		list.add("089");
		list.add("090 : 79037640 DUSTI MOSQUERA");
		list.add("091");
		list.add("092 : 24903965 ALONSO GILSTAD");
		list.add("093");
		list.add("094 : 81528001 NEAL HOLSTEGE");
		list.add("095 : 62522327 AHMAD THAYER");
		list.add("096");
		list.add("097 : 89785663 FLORENCE RYBICKI");
		list.add("098");
		list.add("099");
		list.add("100 : 24248685 FRANCE COELLO");
		list.add("");
		list.add("---- ARRAY STATE AFTER REMOVES ----");
		list.add("");
		list.add("000 : 20316453 TOMASA POWANDA");
		list.add("001 : 25428367 DUSTY BANNON");
		list.add("002 : 84936051 DEONNA STRAZZA");
		list.add("003 : 84018568 SEE AHSING");
		list.add("004 : dummy");
		list.add("005 : 88475094 SUSANNE CORROW");
		list.add("006 : dummy");
		list.add("007 : 80872518 AL WILLIVER");
		list.add("008 : 36569784 CHARLOTTE WHISENAND");
		list.add("009 : 89392483 SCOTTY BREINING");
		list.add("010");
		list.add("011 : dummy");
		list.add("012 : 32375158 EMILIO VANDERHORST");
		list.add("013");
		list.add("014");
		list.add("015");
		list.add("016 : 90572271 ELIJAH METEVIER");
		list.add("017");
		list.add("018");
		list.add("019");
		list.add("020 : 36045405 KEVIN GUNKELMAN");
		list.add("021");
		list.add("022");
		list.add("023");
		list.add("024");
		list.add("025 : 59245514 LESLEE PHIFER");
		list.add("026");
		list.add("027");
		list.add("028 : 18088219 PENNY JOTBLAD");
		list.add("029 : dummy");
		list.add("030 : dummy");
		list.add("031");
		list.add("032");
		list.add("033 : 96077293 MURRAY STAGNO");
		list.add("034");
		list.add("035 : 31850991 WANETA DEWEES");
		list.add("036 : 59376623 TODD MALICOAT");
		list.add("037 : 10747952 TOBY PRUCHNIK");
		list.add("038");
		list.add("039");
		list.add("040");
		list.add("041");
		list.add("042 : 23331143 JUSTIN ADKIN");
		list.add("043 : 54657809 MARTY ENOCHS");
		list.add("044");
		list.add("045");
		list.add("046");
		list.add("047 : 68682774 MALIK TULLER");
		list.add("048 : 22806858 LAVERNE WOLNIK");
		list.add("049 : 39977566 CHONG MCOWEN");
		list.add("050");
		list.add("051");
		list.add("052 : 28311867 ROGELIO KINGFISHER");
		list.add("053");
		list.add("054");
		list.add("055");
		list.add("056");
		list.add("057");
		list.add("058 : 25559522 MOISES FELGENHAUER");
		list.add("059 : 54920021 TYSON COLBETH");
		list.add("060");
		list.add("061");
		list.add("062");
		list.add("063 : 79430806 MELVINA CORNEJO");
		list.add("064 : 37487223 EASTER HENNIGAN");
		list.add("065 : dummy");
		list.add("066 : dummy");
		list.add("067 : 86770985 DUSTY CONFER");
		list.add("068");
		list.add("069 : 52298576 AUDIE UNCAPHER");
		list.add("070 : dummy");
		list.add("071 : 46531276 BRADLY BOMBACI");
		list.add("072 : 48235144 DEBROAH FUTTER");
		list.add("073 : 47186566 FONDA KUBSCH");
		list.add("074 : 48235250 KENNITH GRASSMYER");
		list.add("075");
		list.add("076 : 64357276 SCOT PARREIRA");
		list.add("077");
		list.add("078");
		list.add("079");
		list.add("080");
		list.add("081 : 54526749 TOBI HEATLEY");
		list.add("082");
		list.add("083");
		list.add("084");
		list.add("085");
		list.add("086 : dummy");
		list.add("087");
		list.add("088");
		list.add("089");
		list.add("090 : 79037640 DUSTI MOSQUERA");
		list.add("091");
		list.add("092 : 24903965 ALONSO GILSTAD");
		list.add("093");
		list.add("094 : dummy");
		list.add("095 : 62522327 AHMAD THAYER");
		list.add("096");
		list.add("097 : 89785663 FLORENCE RYBICKI");
		list.add("098");
		list.add("099");
		list.add("100 : 24248685 FRANCE COELLO");
		list.add("");
		list.add("---- ARRAY STATE AFTER OVERWRITING PUTS ----");
		list.add("");
		list.add("000 : 20316453 TOMASA POWANDA");
		list.add("001 : 25428367 DUSTY BANNON");
		list.add("002 : 84936051 DEONNA STRAZZA");
		list.add("003 : 84018568 SEE AHSING");
		list.add("004 : 88475094 JANET TYTLER");
		list.add("005 : dummy");
		list.add("006 : dummy");
		list.add("007 : 80872518 AL WILLIVER");
		list.add("008 : 36569784 THURMAN TULLOS");
		list.add("009 : 89392483 SCOTTY BREINING");
		list.add("010");
		list.add("011 : dummy");
		list.add("012 : 32375158 EMILIO VANDERHORST");
		list.add("013");
		list.add("014");
		list.add("015");
		list.add("016 : 90572271 EVAN CLASBY");
		list.add("017");
		list.add("018");
		list.add("019");
		list.add("020 : 36045405 KEVIN GUNKELMAN");
		list.add("021");
		list.add("022");
		list.add("023");
		list.add("024");
		list.add("025 : 59245514 LESLEE PHIFER");
		list.add("026");
		list.add("027");
		list.add("028 : 18088219 PENNY JOTBLAD");
		list.add("029 : dummy");
		list.add("030 : dummy");
		list.add("031");
		list.add("032");
		list.add("033 : 96077293 MURRAY STAGNO");
		list.add("034");
		list.add("035 : 31850991 RANDAL SIPTAK");
		list.add("036 : 59376623 TODD MALICOAT");
		list.add("037 : 10747952 TOBY PRUCHNIK");
		list.add("038");
		list.add("039");
		list.add("040");
		list.add("041");
		list.add("042 : 23331143 JUSTIN ADKIN");
		list.add("043 : 54657809 MARTY ENOCHS");
		list.add("044");
		list.add("045");
		list.add("046");
		list.add("047 : 68682774 MALIK TULLER");
		list.add("048 : 22806858 LAVERNE WOLNIK");
		list.add("049 : 39977566 CHONG MCOWEN");
		list.add("050");
		list.add("051");
		list.add("052 : 28311867 ROGELIO KINGFISHER");
		list.add("053");
		list.add("054");
		list.add("055");
		list.add("056");
		list.add("057");
		list.add("058 : 25559522 MOISES FELGENHAUER");
		list.add("059 : 54920021 TYSON COLBETH");
		list.add("060");
		list.add("061");
		list.add("062");
		list.add("063 : 79430806 MELVINA CORNEJO");
		list.add("064 : 37487223 OWEN IWAOKA");
		list.add("065 : dummy");
		list.add("066 : dummy");
		list.add("067 : 86770985 DUSTY CONFER");
		list.add("068");
		list.add("069 : 52298576 AUDIE UNCAPHER");
		list.add("070 : dummy");
		list.add("071 : 46531276 BRADLY BOMBACI");
		list.add("072 : 48235144 DEBROAH FUTTER");
		list.add("073 : 47186566 FONDA KUBSCH");
		list.add("074 : 48235250 KENNITH GRASSMYER");
		list.add("075");
		list.add("076 : 64357276 SCOT PARREIRA");
		list.add("077");
		list.add("078");
		list.add("079");
		list.add("080");
		list.add("081 : 54526749 TOBI HEATLEY");
		list.add("082");
		list.add("083");
		list.add("084");
		list.add("085");
		list.add("086 : dummy");
		list.add("087");
		list.add("088");
		list.add("089");
		list.add("090 : 79037640 DUSTI MOSQUERA");
		list.add("091");
		list.add("092 : 24903965 ALONSO GILSTAD");
		list.add("093");
		list.add("094 : dummy");
		list.add("095 : 62522327 AHMAD THAYER");
		list.add("096");
		list.add("097 : 89785663 FLORENCE RYBICKI");
		list.add("098");
		list.add("099");
		list.add("100 : 24248685 FRANCE COELLO");
		list.add("");
		list.add("---- ARRAY STATE AFTER FINAL PUTS ----");
		list.add("");
		list.add("000 : 20316453 TOMASA POWANDA");
		list.add("001 : 25428367 DUSTY BANNON");
		list.add("002 : 84936051 DEONNA STRAZZA");
		list.add("003 : 84018568 SEE AHSING");
		list.add("004 : 88475094 JANET TYTLER");
		list.add("005 : 29360502 EDISON KOHLHOFF");
		list.add("006 : dummy");
		list.add("007 : 80872518 AL WILLIVER");
		list.add("008 : 36569784 THURMAN TULLOS");
		list.add("009 : 89392483 SCOTTY BREINING");
		list.add("010 : 72091080 CAITLIN KLEINKOPF");
		list.add("011 : dummy");
		list.add("012 : 32375158 EMILIO VANDERHORST");
		list.add("013");
		list.add("014");
		list.add("015");
		list.add("016 : 90572271 EVAN CLASBY");
		list.add("017 : 91489755 TOBY ZAMBORSKY");
		list.add("018 : 85984651 GRAHAM GUERRY");
		list.add("019");
		list.add("020 : 36045405 KEVIN GUNKELMAN");
		list.add("021");
		list.add("022");
		list.add("023");
		list.add("024");
		list.add("025 : 59245514 LESLEE PHIFER");
		list.add("026");
		list.add("027 : 23069134 BARRIE KAKANI");
		list.add("028 : 18088219 PENNY JOTBLAD");
		list.add("029 : dummy");
		list.add("030 : dummy");
		list.add("031");
		list.add("032");
		list.add("033 : 96077293 MURRAY STAGNO");
		list.add("034");
		list.add("035 : 31850991 RANDAL SIPTAK");
		list.add("036 : 59376623 TODD MALICOAT");
		list.add("037 : 10747952 TOBY PRUCHNIK");
		list.add("038");
		list.add("039");
		list.add("040");
		list.add("041");
		list.add("042 : 23331143 JUSTIN ADKIN");
		list.add("043 : 54657809 MARTY ENOCHS");
		list.add("044");
		list.add("045");
		list.add("046");
		list.add("047 : 68682774 MALIK TULLER");
		list.add("048 : 22806858 LAVERNE WOLNIK");
		list.add("049 : 39977566 CHONG MCOWEN");
		list.add("050");
		list.add("051");
		list.add("052 : 28311867 ROGELIO KINGFISHER");
		list.add("053 : 98960761 CHRISTOPER BOGGUS");
		list.add("054");
		list.add("055");
		list.add("056");
		list.add("057");
		list.add("058 : 25559522 MOISES FELGENHAUER");
		list.add("059 : 54920021 TYSON COLBETH");
		list.add("060 : 68682886 TRACEY CATAPANO");
		list.add("061");
		list.add("062");
		list.add("063 : 79430806 MELVINA CORNEJO");
		list.add("064 : 37487223 OWEN IWAOKA");
		list.add("065 : dummy");
		list.add("066 : dummy");
		list.add("067 : 86770985 DUSTY CONFER");
		list.add("068");
		list.add("069 : 52298576 AUDIE UNCAPHER");
		list.add("070 : dummy");
		list.add("071 : 46531276 BRADLY BOMBACI");
		list.add("072 : 48235144 DEBROAH FUTTER");
		list.add("073 : 47186566 FONDA KUBSCH");
		list.add("074 : 48235250 KENNITH GRASSMYER");
		list.add("075 : 90834422 CARLIE AMRICH");
		list.add("076 : 64357276 SCOT PARREIRA");
		list.add("077");
		list.add("078");
		list.add("079");
		list.add("080");
		list.add("081 : 54526749 TOBI HEATLEY");
		list.add("082");
		list.add("083");
		list.add("084");
		list.add("085");
		list.add("086 : dummy");
		list.add("087 : 52560790 LORAINE HUMASON");
		list.add("088");
		list.add("089");
		list.add("090 : 79037640 DUSTI MOSQUERA");
		list.add("091");
		list.add("092 : 24903965 ALONSO GILSTAD");
		list.add("093");
		list.add("094 : 93324599 PATRICK CORNELY");
		list.add("095 : 62522327 AHMAD THAYER");
		list.add("096");
		list.add("097 : 89785663 FLORENCE RYBICKI");
		list.add("098");
		list.add("099");
		list.add("100 : 24248685 FRANCE COELLO");
		list.add("");
		list.add("---- GET TESTS ----");
		list.add("");
		list.add("EDISON KOHLHOFF");
		list.add("null");
		list.add("AL WILLIVER");
		list.add("EVAN CLASBY");
		list.add("BARRIE KAKANI");

		return list;
	}

	@Test
	void runTestLabTwo() {

		List<String> expected = getExpected();
		List<String> actual = new ArrayList<String>();

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
		
		actual.add("---- ARRAY STATE AFTER PUTS ----");
		actual.add("");
		actual.addAll(hashTable.toListOfString());
		
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

		actual.add("");
		actual.add("---- ARRAY STATE AFTER REMOVES ----");
		actual.add("");
		actual.addAll(hashTable.toListOfString());
		
		hashTable.put(90572271, "EVAN CLASBY");
		hashTable.put(88475094, "JANET TYTLER");
		hashTable.put(36569784, "THURMAN TULLOS");
		hashTable.put(31850991, "RANDAL SIPTAK");
		hashTable.put(37487223, "OWEN IWAOKA");

		actual.add("");
		actual.add("---- ARRAY STATE AFTER OVERWRITING PUTS ----");
		actual.add("");
		actual.addAll(hashTable.toListOfString());

		hashTable.put(90834422, "CARLIE AMRICH");
		hashTable.put(68682886, "TRACEY CATAPANO");
		hashTable.put(98960761, "CHRISTOPER BOGGUS");
		hashTable.put(93324599, "PATRICK CORNELY");
		hashTable.put(85984651, "GRAHAM GUERRY");
		hashTable.put(23069134, "BARRIE KAKANI");
		hashTable.put(91489755, "TOBY ZAMBORSKY");
		hashTable.put(52560790, "LORAINE HUMASON");
		hashTable.put(29360502, "EDISON KOHLHOFF");
		hashTable.put(72091080, "CAITLIN KLEINKOPF");

		actual.add("");
		actual.add("---- ARRAY STATE AFTER FINAL PUTS ----");
		actual.add("");
		actual.addAll(hashTable.toListOfString());

		actual.add("");
		actual.add("---- GET TESTS ----");
		actual.add("");

		Object obj;

		obj = hashTable.get(29360502);
		actual.add(obj != null ? obj.toString() : "null");

		obj = hashTable.get(88999386);
		actual.add(obj != null ? obj.toString() : "null");

		obj = hashTable.get(80872518);
		actual.add(obj != null ? obj.toString() : "null");

		obj = hashTable.get(90572271);
		actual.add(obj != null ? obj.toString() : "null");

		obj = hashTable.get(23069134);
		actual.add(obj != null ? obj.toString() : "null");

		for(int i=0; i<expected.stream().count(); i++) {
			Assertions.assertEquals(expected.get(i), actual.get((i)));
			System.out.println(actual.get(i));
		}
	}
}
