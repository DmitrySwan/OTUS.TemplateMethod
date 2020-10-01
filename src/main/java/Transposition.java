class Transposition extends Operation {
    void process() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        this.result = matrix;
    }

    @Override
    String dataToOutputFormat() {
        return matrixToString((int[][]) result);
    }
}
