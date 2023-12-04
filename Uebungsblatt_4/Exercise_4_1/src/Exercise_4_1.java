import java.util.Scanner;

/**
 * Gegeben ist eine ganzzahlige Matrix A einer beliebigen Größe.
 * Finden Sie:
 * a) die Summe der Elemente der Hauptdiagonale;
 * b) das arithmetische Mittel der Elemente der Matrix;
 * c) das arithmetische Mittel der Elemente der einzelnen Spalten;
 * d) ihre transponierte Matrix.
 * Ersetzen Sie:
 * e) alle negativen Elemente der Matrix durch 0 und alle positiven Elemente der Matrix durch 1;
 * f) die Elemente der Hauptdiagonale durch 1 und alle anderen Elemente durch 0.
 */
public class Exercise_4_1 {
    public static void main(String[] args) {
        int[][] matrix;
        float[] middleOfColumns;
        int[][] transposedMatrix;
        int[][] binaryMatrix;
        int[][] binaryMatrixWithMainDiagonal;

        matrix = getMatrix();

        // a) die Summe der Elemente der Hauptdiagonale;
        System.out.println("\nDie Summe der Elemente der Hauptdiagonale lautet: " + sumMainDiagonal(matrix));

        // b) das arithmetische Mittel der Elemente der Matrix;
        System.out.println("\nDas arithmetische Mittel der Elemente der Matrix lautet: " + arithmeticMiddleInTotal(matrix));

        // c) das arithmetische Mittel der Elemente der einzelnen Spalten;
        middleOfColumns = arithmeticMiddleOfColumn(matrix);
        System.out.println("\nDas arithmetische Mittel der Elemente der Spalten lautet lautet: ");
        for(int i = 0; i < middleOfColumns.length; i++) {
            System.out.println("\nFür Spalte " + i + ": " + middleOfColumns[i]);
        }

        // d) ihre transponierte Matrix
        transposedMatrix = transposeMatrix(matrix);
        System.out.println("\nDie transponierte Matrix lautet wie folgt:");
        for(int k = 0; k < transposedMatrix.length; k++) {
            System.out.print(" | ");
            for (int l = 0; l < transposedMatrix[k].length; l++) {
                System.out.print(transposedMatrix[k][l] + " | ");
            }
            System.out.print("\n");
        }

        // e) alle negativen Elemente der Matrix durch 0 und alle positiven Elemente der Matrix durch 1;
        binaryMatrix = changeToBinaryMatrix(matrix);
        System.out.println("\nDie binäre Matrix lautet wie folgt:");
        for(int k = 0; k < binaryMatrix.length; k++) {
            System.out.print(" | ");
            for (int l = 0; l < binaryMatrix[k].length; l++) {
                System.out.print(binaryMatrix[k][l] + " | ");
            }
            System.out.print("\n");
        }

        // f) die Elemente der Hauptdiagonale durch 1 und alle anderen Elemente durch 0.
        binaryMatrixWithMainDiagonal = changeToBinaryMatrixWithMainDiagonal(matrix);
        System.out.println("\nDie binäre Matrix, bei der nur die Elemente der Hauptdiagonalen den Wert 1 besitzen, lautet wie folgt:");
        for(int k = 0; k < binaryMatrixWithMainDiagonal.length; k++) {
            System.out.print(" | ");
            for (int l = 0; l < binaryMatrixWithMainDiagonal[k].length; l++) {
                System.out.print(binaryMatrixWithMainDiagonal[k][l] + " | ");
            }
            System.out.print("\n");
        }
    }


    /**
     * Erstellen der Matrix auf Grundlage von User Input
     *
     * @return matrix – Die erstellte Matrix
     */
    public static int[][] getMatrix() {
        int[][] matrix;
        int column;
        int row;

        Scanner userInput = new Scanner(System.in);


        System.out.println("\nWie viele Zeilen soll die Matrix besitzen?");
        row = userInput.nextInt();

        System.out.println("\nWie viele Spalten soll die Matrix besitzen?");
        column = userInput.nextInt();

        matrix = new int[row][column];

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("\nWie lautet der ganzzahlige Wert in Zeile " + i + " Spalte " + j + "?");
                matrix[i][j] = userInput.nextInt();
            }
        }

        for(int k = 0; k < matrix.length; k++) {
            System.out.println("\nDie Werte in Zeile " + k + " lauten: ");
            for (int l = 0; l < matrix[k].length; l++) {
                System.out.print(matrix[k][l] + ", ");
            }
        }

        return matrix;
    }



    /**
     * a) die Summe der Elemente der Hauptdiagonale;
     *
     * @param matrix – Die erstellte Matrix
     * @return sum – Die Summe der Elemente der Hauptdiagonale
     */
    public static int sumMainDiagonal(int[][] matrix) {
        int maxLength;
        int sum = 0;

        // Festlegen der Länge der Diagonalen
        if(matrix.length > matrix[0].length) {
            maxLength = matrix.length;
        } else {
            maxLength=matrix[0].length;
        }

        for(int k = 0; k < (maxLength - 1); k++) {
            sum += matrix[k][k];
        }

        return sum;

    }



    /**
     * b) das arithmetische Mittel der Elemente der Matrix;
     *
     * @param matrix – Die erstellte Matrix
     * @return average – Der Durchschnitt der Elemente der Matrix
     */
    public static float arithmeticMiddleInTotal(int[][] matrix) {
        float average;
        int sum = 0;
        int counter = 0;

        for(int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix[k].length; l++) {
                counter ++;
                sum += matrix[k][l];
            }
        }

        average = (float) sum / counter;

        return average;
    }



    /**
     * c) das arithmetische Mittel der Elemente der einzelnen Spalten;
     *
     * @param matrix  – Die erstellte Matrix
     * @return averagesOfColumns – Das Array mit den Durchschnitten der einzelnen Spalten
     */
    public static float[] arithmeticMiddleOfColumn(int[][] matrix) {
        float average;
        int sum;
        float[] averagesOfColumns = new float[matrix[0].length];
        int columnsLength = matrix.length;


        // Gehe jede Spalte durch
        for (int k = 0; k < matrix[0].length; k++) {
            sum = 0;
            // Gehe in der Spalte jede Zeile durch
            for (int[] matrixInt : matrix) {
                sum += matrixInt[k];
            }
            averagesOfColumns[k] = (float) sum / columnsLength;
        }

        return averagesOfColumns;
    }



    /**
     * d) ihre transponierte Matrix
     *
     * @param matrix  – Die erstellte Matrix
     * @return transposedMatrix – Die transponierte Matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix;
        int columnLengthOld;
        int rowLengthNew;
        int rowLengthOld;
        int columnLengthNew;

        columnLengthOld = matrix[0].length;
        rowLengthNew = columnLengthOld;
        rowLengthOld = matrix.length;
        columnLengthNew = rowLengthOld;
        transposedMatrix = new int[rowLengthNew][columnLengthNew];

        for(int i = 0; i < rowLengthOld; i++) {
            for(int j = 0; j < columnLengthOld; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }



    /**
     * e) Ersetzen Sie alle negativen Elemente der Matrix durch 0 und alle positiven Elemente der Matrix durch 1;
     *
     * @param matrix – Die erstellte Matrix
     * @return newMatrix – Die neue Matrix bei der alle negativen Elemente durch 0 und alle positiven Elemente durch 1 ersetzt wurden
     */
    public static int[][] changeToBinaryMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < 0) {
                    newMatrix[i][j] = 0;
                } else {
                    newMatrix[i][j] = 1;
                }
            }
        }

        return newMatrix;
    }



    /**
     * f) die Elemente der Hauptdiagonale durch 1 und alle anderen Elemente durch 0.
     *
     * @param matrix – Die erstellte Matrix
     * @return newMatrix – Die neue Matrix bei der die Hauptdiagonale durch 1 und alle anderen Elemente durch 0 ersetzt wurden
     */
    public static int[][] changeToBinaryMatrixWithMainDiagonal(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i == j) {
                    newMatrix[i][j] = 1;
                } else {
                    newMatrix[i][j] = 0;
                }
            }
        }

        return newMatrix;
    }
}

