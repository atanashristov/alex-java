package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import com.hristov.alex.javaLessons.dataStructures.hashTableLP.HashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class HashTable_Lab2_TestDriver {

    public static void main(String[] args) {
        try {
            Path testsDirectory = Paths.get("src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\HashTable_Lab2_DataSet.txt");
            String absolutePath = testsDirectory.toFile().getAbsolutePath();

            File file = new File(absolutePath);
            Scanner scanner = new Scanner(file);

// Part 1: get capacity
            scanner.next();
            HashTable hash = new HashTable(scanner.nextInt());

// Part 2: add data to hash and save order, then print
            scanner.next();
            int size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                hash.put(scanner.nextInt(), scanner.next() + " " + scanner.next());
            }
            System.out.println("---- ARRAY STATE AFTER PUTS ----" + "\n");
            System.out.println(hash.toString());

// Part 3: remove and print
            scanner.next();
            size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                hash.remove(scanner.nextInt());
            }
            System.out.println("---- ARRAY STATE AFTER REMOVES ----" + "\n");
            System.out.println(hash.toString());

// Part 4: put/overwrite and print
            scanner.next();
            size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                hash.put(scanner.nextInt(), scanner.next() + " " + scanner.next());
            }
            System.out.println("---- ARRAY STATE AFTER OVERWRITING PUTS ----" + "\n");
            System.out.println(hash.toString());

// Part 5: put and print
            scanner.next();
            size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                hash.put(scanner.nextInt(), scanner.next() + " " + scanner.next());
            }
            System.out.println("---- ARRAY STATE AFTER FINAL PUTS ----" + "\n");
            System.out.println(hash.toString());

// Part 6: get values and print
            scanner.next();
            size = scanner.nextInt();
            System.out.println("---- GET TESTS ----" + "\n");
            for (int i = 0; i < size; i++) {
                System.out.println(hash.get(scanner.nextInt()));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}