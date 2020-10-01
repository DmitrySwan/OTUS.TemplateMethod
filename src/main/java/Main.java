import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    static final String ADDITION = "addition";
    static final String DETERMINANT = "determinant";
    static final String TRANSPOSITION = "transposition";

    /**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     */
    private static Operation configureApplication(CommandLine cl) {
        String operationType = getOptionValue(cl, OperationCommandLineParser.OPERATION);
        Operation operation;
        if (ADDITION.equalsIgnoreCase(operationType)) {
            operation = new Addition();
        } else if (DETERMINANT.equalsIgnoreCase(operationType)) {
            operation = new Determinant();
        } else {
            operation = new Transposition();
        }
        operation.setInputFile(getFile(cl, OperationCommandLineParser.INPUT));
        operation.setOutputFile(getFile(cl, OperationCommandLineParser.OUTPUT));
        return operation;
    }

    private static File getFile(CommandLine cl, String operation) {
        return new File(getOptionValue(cl, operation));
    }

    private static String getOptionValue(CommandLine cl, String operation) {
        return cl.getOptionValue(operation);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Operation operation = configureApplication(OperationCommandLineParser.parseCMDArgs(args));
        operation.run();
    }
}
