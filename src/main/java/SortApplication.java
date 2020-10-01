import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class SortApplication {

    private static Logger log = Logger.getLogger(SortApplication.class);

    private static final int ARRAY_SIZE = 50;

    private Sort sort;
    private File inputFile;
    private File outputFile;

    void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    SortApplication(SortAbstractFactory factory) {
        this.sort = factory.createSort();
    }

    void sort() throws FileNotFoundException {
        int[] array = readArrayFromInputFile();
        String className = sort.getClass().getName();
        log.info(className + " #Array: " + Arrays.toString(array));
        int[] sortedArray = sort.sort(array);
        log.info(className + " #Sorted array: " + Arrays.toString(sortedArray));
        printToOutputFile(sortedArray);
    }

    private int[] readArrayFromInputFile() throws FileNotFoundException {
        Scanner b = new Scanner(inputFile);
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = b.nextInt();
        }
        return array;
    }

    private void printToOutputFile(int[] array) {
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(sort.sortType());
            for (int element : array) {
                out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
