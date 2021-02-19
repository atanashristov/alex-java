package com.hristov.alex.javaLessons.dataStructures;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringJoiner;

public class HashTable_Lab3_TestDriver {

    public static void main(String[] args) {
        ArrayList<String> dataSet = readFile(500000,
            "src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\HashTable_Lab3_LargeDataSet.txt");
        ArrayList<String> successfulSearch = readFile(15000,
            "src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\HashTable_Lab3_SuccessfulSearch.txt");
        ArrayList<String> unsuccessfulSearch = readFile(15000,
            "src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\HashTable_Lab3_UnsuccessfulSearch.txt");

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

            System.out.println("Running loadFactor="+loadFactor+", capacity:="+capacity+"...");

            HashTable hashTable = new HashTable(capacity);

            long start, stop;

            // --- Measure table insertion performance ---
            hashTable.resetStats();;
            start = System.currentTimeMillis();
            doHashTableInserts(hashTable, dataSet);
            stop = System.currentTimeMillis();

            long putMs = stop - start;
            long putMsAvg = putMs / dataSet.stream().count();
            long putProbes = hashTable.get_statsProbesPut();
            long putProbesAvg = Math.round(putProbes / dataSet.stream().count());

            // --- Measure performance for finding items in table ---

            hashTable.resetStats();;
            start = System.currentTimeMillis();
            doHashTableFinds(hashTable, successfulSearch);
            stop = System.currentTimeMillis();

            long getMs = stop - start;
            long getMsAvg = getMs / successfulSearch.stream().count();
            long getProbes = hashTable.get_statsProbesGet();
            long getProbesAvg = Math.round(getProbes / successfulSearch.stream().count());

            // --- Measure search performance for items NOT in table ---

            hashTable.resetStats();;
            start = System.currentTimeMillis();
            doHashTableFinds(hashTable, unsuccessfulSearch);
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
    "src\\test\\java\\com\\hristov\\alex\\javaLessons\\dataStructures\\HashTable_Lab3_Report.csv");
    }

    private static void doHashTableInserts(HashTable hashTable, ArrayList<String> search) {
        for(int i = 0; i < search.stream().count(); i++) {
            String rec = search.get(i);
            int idx = rec.indexOf(" ");
            String key = rec.substring(0, idx);
            String val = rec.substring(idx + 1);
            hashTable.put(key, val);
        }
    }

    private static void doHashTableFinds(HashTable hashTable, ArrayList<String> search) {
        for(int i = 0; i < search.stream().count(); i++) {
            String rec = search.get(i);
            int idx = rec.indexOf(" ");
            String key = rec.substring(0, idx);
            Object storedVal = hashTable.get(key);
        }
    }

    private static String getFormattedLine(Object[] data) {
        String res = String.format(
                "%1$-15s | %2$-15s | %3$-15s | %4$-15s | %5$-15s | %6$-15s | %7$-15s | %8$-15s | %9$-15s | %10$-15s | %11$-15s | %12$-15s | %13$-15s | %14$-15s | %15$-15s | %16$-15s | %17$-15s",
                data);
        return res;
    }

    private static String getCommaDelimitedLine(Object[] data) {
        StringJoiner joiner = new StringJoiner(",");
        for (int j=0; j<data.length; j++) {
            joiner.add(data[j].toString());
        }
        return joiner.toString();
    }

    private static void writeReportToConsole(ArrayList<Object[]> report) {
        for(int i=0; i<report.stream().count(); i++) {
            System.out.println(getFormattedLine(report.get(i)));
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
                String line = getCommaDelimitedLine(row);
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
