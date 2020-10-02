import static org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class OperationTest {
    private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";

    @DataProvider
    public Object[][] operationTestData() {
        return new Object[][]{
                {Main.ADDITION, "inputFileAddition.txt", "outputFileAdditionExpected.txt", "outputFileAdditionExpected.txt"},
                {Main.DETERMINANT, "inputFileDeterminant.txt", "outputFileDeterminant.txt", "outputFileDeterminantExpected.txt"},
                {Main.TRANSPOSITION, "inputFileTransposition.txt", "outputFileTranspositionExpected.txt", "outputFileTranspositionExpected.txt"},
        };
    }

    @Test(description = "", dataProvider = "operationTestData")
    public void operationTest(String operationType, String inputFilePath,
                         String outputFilePath, String outputFileExpectedPath) throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + outputFilePath;
        Main.main(
                new String[]{
                        "-i",  TARGET_TEST_RESOURCES_PATH + inputFilePath,
                        "-o",  targetOutputFilePath,
                        "-op", operationType
                });
         Assert.assertTrue(contentEqualsIgnoreEOL(
                 new File(targetOutputFilePath),
                 new File(TARGET_TEST_RESOURCES_PATH + outputFileExpectedPath),
                 "UTF-8"
         ));
    }
}
