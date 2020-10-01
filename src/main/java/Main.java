import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    static final String INSERTION = "insertion";
    static final String MERGE = "merge";
    static final String SELECTION = "selection";

    /**
     * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
     * из конфигурации или окружения.
     */
    private static SortApplication configureApplication(CommandLine cl) {
        String sortType = cl.getOptionValue(SortCommandLineParser.SORT);
        SortApplication app;
        if (INSERTION.equalsIgnoreCase(sortType)) {
            app = new SortApplication(new InsertionSortFactory());
        } else if (MERGE.equalsIgnoreCase(sortType)) {
            app = new SortApplication(new MergeSortFactory());
        } else {
            app = new SortApplication(new SelectionSortFactory());
        }
        app.setInputFile(new File(cl.getOptionValue(SortCommandLineParser.INPUT)));
        app.setOutputFile(new File(cl.getOptionValue(SortCommandLineParser.OUTPUT)));
        return app;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SortApplication app = configureApplication(SortCommandLineParser.parseCMDArgs(args));
        app.sort();
    }
}
