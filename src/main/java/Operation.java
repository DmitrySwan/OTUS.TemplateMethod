import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

abstract class Operation {
    private int dimension;
    int[][] matrix;

    private File inputFile;
    private File outputFile;
    private Scanner scanner;

    Object result;

    private static Logger log = Logger.getLogger(Operation.class);

    void run() throws FileNotFoundException {
        initScanner();
        setDimension();
        getDataFromFile();
        process();
        String resultString = dataToOutputFormat();
        printToOutputFile(resultString);
    }

    abstract void process();

    abstract String dataToOutputFormat();

    void getDataFromFile() {
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        this.matrix = matrix;
        log.info("#getDataFromFile \n" + matrixToString(matrix));
    }

    private void initScanner() throws FileNotFoundException {
        scanner = new Scanner(inputFile);
    }

    private void setDimension() {
        this.dimension = scanner.nextInt();
    }

    String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getName()).append("\n");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append(" ").append(anInt);
            }
            result.append("\n");
        }
        return result.toString();
    }

    private void printToOutputFile(String resultString) {
        log.info("#printToOutputFile \n"
                + resultString);

        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(resultString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }
}
