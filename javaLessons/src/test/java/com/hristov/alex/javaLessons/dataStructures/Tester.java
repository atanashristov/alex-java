package com.hristov.alex.javaLessons.dataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester
{

public static void main(String[] args)
{
try
{
HashTable hash;

File file = new File("C:\\Users\\Atanas Hristov\\eclipse-workspace\\alex-java\\javaLessons\\src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\hash02.txt");
Scanner scanner = new Scanner(file);

// Part 1: get capacity
scanner.next();
hash = new HashTable(scanner.nextInt());

// Part 2: add data to hash and save order, then print
scanner.next();
int size = scanner.nextInt();
for(int i = 0; i < size; i++)
{
hash.put(scanner.nextInt(), scanner.next() + " " + scanner.next());
}
System.out.println("---- ARRAY STATE AFTER PUTS ----" + "\n");
System.out.println(hash.toString());

// Part 3: remove and print
scanner.next();
size = scanner.nextInt();
for(int i = 0; i < size; i++)
{
hash.remove(scanner.nextInt());
}
System.out.println("---- ARRAY STATE AFTER REMOVES ----" + "\n");
System.out.println(hash.toString());

// Part 4: put/overwrite and print
scanner.next();
size = scanner.nextInt();
for(int i = 0; i < size; i++)
{
hash.put(scanner.nextInt(), scanner.next() + " " + scanner.next());
}
System.out.println("---- ARRAY STATE AFTER OVERWRITING PUTS ----" + "\n");
System.out.println(hash.toString());

// Part 5: put and print
scanner.next();
size = scanner.nextInt();
for(int i = 0; i < size; i++)
{
hash.put(scanner.nextInt(), scanner.next() + " " + scanner.next());
}
System.out.println("---- ARRAY STATE AFTER FINAL PUTS ----" + "\n");
System.out.println(hash.toString());

// Part 6: get values and print
scanner.next();
size = scanner.nextInt();
System.out.println("---- GET TESTS ----" + "\n");
for(int i = 0; i < size; i++)
{
System.out.println(hash.get(scanner.nextInt()));
}

scanner.close();
}
catch (FileNotFoundException e)
{
e.printStackTrace();
}

}

}