import static java.lang.System.arraycopy;

class Determinant extends Operation {
    @Override
    public void process() {
        result = findDeterminant(this.matrix);
    }

    @Override
    String dataToOutputFormat() {
        return this.getClass().getName() + " " + result;
    }

    private int findDeterminant(int[][] matrix) {
        int dim = matrix.length;

        if (dim == 1) {
            return matrix[0][0];
        } else if (dim == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int result = 0;
            int[][] minor = new int[dim - 1][dim - 1];
            for (int i = 0; i < dim; i++) {
                for (int j = 1; j < dim; j++) {
                    arraycopy(matrix[j], 0, minor[j - 1], 0, i);
                    arraycopy(matrix[j], i + 1, minor[j - 1], i, dim - (i + 1));
                }
                result += Math.pow(-1, i) * matrix[0][i] * findDeterminant(minor);
            }
            return result;
        }
    }
}
