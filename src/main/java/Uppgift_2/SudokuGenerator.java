package Uppgift_2;

/**
 * The SudokuGenerator class generates a 4x4 Sudoku puzzle.
 */

import java.util.Random;
public class SudokuGenerator {

        private static final int GRID_SIZE = 4;
        private static final int SUBGRID_SIZE = 2;
        private static final Random random = new Random();


        public static void main(String[] args) {
            int[][] grid = new int[GRID_SIZE][GRID_SIZE];

            if (fillGrid(grid)) {
                removeNumbers(grid);
                printGrid(grid);
            } else {
                System.out.println("Can not generate a valid Sudoku Grid ");
            }
        }

        /**
         * Fills the Sudoku grid with a valid solution.
         *
         * @param grid The Sudoku grid to fill.
         * @return true if the grid is successfully filled, false otherwise.
         */
        private static boolean fillGrid(int[][] grid) {
            return fillGridHelper(grid, 0, 0);
        }

        /**
         * Helper method to recursively fill the Sudoku grid.
         *
         * @param grid The Sudoku grid to fill.
         * @param row The current row index.
         * @param col The current column index.
         * @return true if the grid is successfully filled, false otherwise.
         */
        private static boolean fillGridHelper(int[][] grid, int row, int col) {
            if (row == GRID_SIZE) {
                return true;
            }
            if (col == GRID_SIZE) {
                return fillGridHelper(grid, row + 1, 0);
            }
            if (grid[row][col] != 0) {
                return fillGridHelper(grid, row, col + 1);
            }

            int[] numbers = {1, 2, 3, 4};
            shuffleArray(numbers);

            for (int num : numbers) {
                if (isSafe(grid, row, col, num)) {
                    grid[row][col] = num;
                    if (fillGridHelper(grid, row, col + 1)) {
                        return true;
                    }
                    grid[row][col] = 0;
                }
            }
            return false;
        }


        /**
         * Removes numbers from the filled Sudoku grid to create a puzzle.
         *
         * @param grid The Sudoku grid to modify.
         */
        private static void removeNumbers(int[][] grid) {
            int numbersToRemove = 8; // Adjust this value as needed

            while (numbersToRemove > 0) {
                int row = random.nextInt(GRID_SIZE);
                int col = random.nextInt(GRID_SIZE);

                if (grid[row][col] != 0 && canRemove(grid, row, col)) {
                    grid[row][col] = 0;
                    numbersToRemove--;
                }
            }
        }


    /**
     * @param grid The Sudoku grid
     * @param row The row index of the cell to check.
     * @param col The column index of the cell to check.
     * @return true if the number can be removed, false otherwise.
     */
        private static boolean canRemove(int[][] grid, int row, int col) {
            int startRow = row - row % SUBGRID_SIZE;
            int startCol = col - col % SUBGRID_SIZE;
            int filledCells = 0;

            // Count the number of filled cells in the sub-grid
            for (int i = startRow; i < startRow + SUBGRID_SIZE; i++) {
                for (int j = startCol; j < startCol + SUBGRID_SIZE; j++) {
                    if (grid[i][j] != 0) {
                        filledCells++;
                        // Early exit if we reach 3 filled cells
                        if (filledCells > 2) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        /**
         * Checks if placing a number in a specific cell is valid according to Sudoku rules.
         *
         * @param grid The Sudoku grid.
         * @param row The row index of the cell.
         * @param col The column index of the cell.
         * @param num The number to place.
         * @return true if the number can be placed, false otherwise.
         */
        private static boolean isSafe(int[][] grid, int row, int col, int num) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if (grid[row][x] == num || grid[x][col] == num) {
                    return false;
                }
            }

            int startRow = row - row % SUBGRID_SIZE;
            int startCol = col - col % SUBGRID_SIZE;
            for (int i = 0; i < SUBGRID_SIZE; i++) {
                for (int j = 0; j < SUBGRID_SIZE; j++) {
                    if (grid[i + startRow][j + startCol] == num) {
                        return false;
                    }
                }
            }

            return true;
        }

        /**
         * Shuffles an array of integers randomly.
         *
         * @param array The array to shuffle.
         */
        private static void shuffleArray(int[] array) {
            for (int i = array.length - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }

        /**
         * Prints the Sudoku grid to the console.
         *
         * @param grid The Sudoku grid to print.
         */
        private static void printGrid(int[][] grid) {
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    System.out.print(grid[row][col] == 0 ? "* " : grid[row][col] + " ");
                }
                System.out.println();
            }
        }

}
