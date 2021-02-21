package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Test driver - Hash tables Lab 4
 *
 * Changes:
 * - 1.0: Initial
 *
 * @author Alex Hristov
 * @version 1.0
 * @since 2/20/2021
 */
public class HashTable_Lab4_TestDriver {

    static final String DIR="src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\hashTableLP";

    public static void main(String[] args) {
        ArrayList<String> dataSet = readFile(500000,
                DIR + "\\HashTable_Lab4_CarsDataSet.txt");
        ArrayList<String> successfulSearch = readFile(15000,
                DIR + "\\HashTable_Lab4_SuccessfulSearch.txt");
        ArrayList<String> unsuccessfulSearch = readFile(15000,
                DIR + "\\HashTable_Lab4_UnsuccessfulSearch.txt");

        ArrayList<Object[]> report = new ArrayList<Object[]>();
        report.add(new String[] {
                "HASH_TYPE", // 1
                "HASH_FUNC", // 2
                "DATA_COUNT", // 3
                "CAPACITY", // 4
                "LOAD_FACTOR", // 5

                "PUT_MS", // 6
                "PUT_MS_AVG", // 7
                "PUT_PROBE", // 8
                "PUT_PROBE_AVG", // 9

                "GET_MS", // 10
                "GET_MS_AVG", // 11
                "GET_PROBE", // 12
                "GET_PROBE_AVG", // 13

                "GET_MS2", // 14
                "GET_MS2", // 15
                "GET_PROBE2", // 16
                "GET_PROBE2_AVG" // 17
        });

        double[] loadFactors = new double[] {
                0.1,
                0.5,
                0.8,
                0.9,
                1.0
        };

        for (int i=0; i<loadFactors.length; i++) {
            double loadFactor = loadFactors[i];
            int capacity = (int) (dataSet.stream().count() / loadFactor);

            System.out.println("Running loadFactor=" + loadFactor + ", capacity:=" + capacity + "...");

            HashTable hashTable = new HashTable(capacity);

            long start, stop;

            // --- Measure table insertion performance ---
            hashTable.resetStats();
            ;
            start = System.currentTimeMillis();
            doHashTableInserts(hashTable, dataSet);
            stop = System.currentTimeMillis();

            long putMs = stop - start;
            long putMsAvg = putMs / dataSet.stream().count();
            long putProbes = hashTable.get_statsProbesPut();
            long putProbesAvg = Math.round(putProbes / dataSet.stream().count());

            // --- Measure performance for finding items in table ---

            hashTable.resetStats();
            start = System.currentTimeMillis();
            doHashTableSearch(hashTable, successfulSearch);
            stop = System.currentTimeMillis();

            long getMs = stop - start;
            long getMsAvg = getMs / successfulSearch.stream().count();
            long getProbes = hashTable.get_statsProbesGet();
            long getProbesAvg = Math.round(getProbes / successfulSearch.stream().count());

            // --- Measure search performance for items NOT in table ---

            hashTable.resetStats();
            start = System.currentTimeMillis();
            doHashTableSearch(hashTable, unsuccessfulSearch);
            stop = System.currentTimeMillis();

            long getMs2 = stop - start;
            long getMs2Avg = getMs2 / unsuccessfulSearch.stream().count();
            long getProbes2 = hashTable.get_statsProbesGet();
            long getProbesAvg2 = Math.round(getProbes2 / unsuccessfulSearch.stream().count());

            // --- Print numbers

            report.add(new Object[]{
                    "Linear probing", // 1
                    "Integer value", // 2
                    dataSet.stream().count(), // 3
                    capacity, // 4
                    loadFactor, // 5

                    putMs, // 6
                    putMsAvg, // 7
                    putProbes, // 8
                    putProbesAvg, // 9

                    getMs, // 10
                    getMsAvg, // 11
                    getProbes, // 12
                    getProbesAvg, // 13

                    getMs2, // 14
                    getMs2Avg, // 15
                    getProbes2, // 16
                    getProbesAvg2 // 17
            });
        }

        writeReportToConsole(report);
        writeReportToFile(report,
                DIR + "\\HashTable_Lab4_Report.csv");
    }

    private static void doHashTableInserts(HashTable hashTable, ArrayList<String> data) {
        for(int i = 0; i < data.stream().count(); i++) {
            String rec = data.get(i);

            String vin = rec.substring(0, 17);
            int year = Integer.parseInt(rec.substring(18, 22).trim());
            String make = rec.substring(23, 66);
            String country = rec.substring(67);

            Car car = new Car(vin, year, make, country);
            hashTable.put(vin, car);
        }
    }

    private static void doHashTableSearch(HashTable hashTable, ArrayList<String> data) {
        for(int i = 0; i < data.stream().count(); i++) {
            String rec = data.get(i);
            String vin = rec.substring(0, 16);
            Object storedVal = hashTable.get(vin);
        }
    }

    private static String createLineForReport(Object[] data) {
        String res = String.format(
                "%1$-14s | %2$-14s | %3$-12s | %4$-12s | %5$-12s | %6$-12s | %7$-12s | %8$-12s | %9$-14s | %10$-12s | %11$-12s | %12$-12s | %13$-14s | %14$-12s | %15$-12s | %16$-12s | %17$-12s",
                data);
        return res;
    }

    private static String createCommaSeparatedLine(Object[] data) {
        StringJoiner joiner = new StringJoiner(",");
        for (int j=0; j<data.length; j++) {
            joiner.add(data[j].toString());
        }
        return joiner.toString();
    }

    private static void writeReportToConsole(ArrayList<Object[]> report) {
        for(int i=0; i<report.stream().count(); i++) {
            System.out.println(createLineForReport(report.get(i)));
        }
    }
    private static void writeReportToFile(ArrayList<Object[]> report, String filename) {
        PrintWriter writer;

        try {
            Path testsDirectory = Paths.get(filename);
            String absolutePath = testsDirectory.toFile().getAbsolutePath();
            writer = new PrintWriter(absolutePath);

            for (int i = 0; i < report.stream().count(); i++) {
                Object[] row = report.get(i);
                String line = createCommaSeparatedLine(row);
                writer.println(line);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    private static ArrayList<String> readFile(int initialCapacity, String filename) {
        ArrayList<String> res = new ArrayList<String>(initialCapacity);
        BufferedReader reader;

        try {
            Path testsDirectory = Paths.get(filename);
            String absolutePath = testsDirectory.toFile().getAbsolutePath();

            reader = new BufferedReader(new FileReader(absolutePath));
            String line = reader.readLine();

            while(line != null) {
                res.add(line);
                line = reader.readLine();
            }

            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }

        return res;
    }

}
