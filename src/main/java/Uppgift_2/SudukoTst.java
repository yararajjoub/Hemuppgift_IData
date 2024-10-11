package Uppgift_2;
import java.util.Random;

public class SudukoTst {

    private static final int GRID_SIZE = 4;
    private static final int SUBGRID_SIZE = 2;

    public static void main(String[] args) {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];

        if (fillGrid(grid)) {
            removeNumbers(grid);
            printGrid(grid);
        } else {
            System.out.println("Kunde inte generera en giltig Sudoku.");
        }
    }

    private static boolean fillGrid(int[][] grid) {
        return fillGridHelper(grid, 0, 0);
    }

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

        Random random = new Random();
        int[] numbers = {1, 2, 3, 4};
        shuffleArray(numbers, random);

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

    private static void removeNumbers(int[][] grid) {
        Random random = new Random();
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

    private static boolean canRemove(int[][] grid, int row, int col) {
        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;
        int filledCells = 0;

        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                if (grid[startRow + i][startCol + j] != 0) {
                    filledCells++;
                }
            }
        }

        return filledCells > 2;
    }

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

    private static void shuffleArray(int[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private static void printGrid(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}