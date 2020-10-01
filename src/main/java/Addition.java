import org.apache.log4j.Logger;

class Addition extends Operation {
    private int[][] firstMatrix, secondMatrix;

    @Override
    public void process() {
        int length = firstMatrix.length;
        int[][] result = new int[length][length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        this.result = result;
    }

    @Override
    String dataToOutputFormat() {
        return matrixToString((int[][]) result);
    }

    void getDataFromFile() {
        super.getDataFromFile();
        this.firstMatrix = matrix;
        super.getDataFromFile();
        this.secondMatrix = matrix;
    }
}
