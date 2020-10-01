public abstract class Operation {
    void run() {
        rawData = getDataFromFile();
        processedData = process(rawData);
        dataToPrint = getOutputData(processedData);
        printToFile(dataToPrint);
    }

    getDataFromFile() {

    }
}
