import java.util.*;

public class Main {
    final int[][] board = new int[9][9];
    final int[][] solution = new int[9][9];
    long startTime;
    int moveCount = 0;
    int wrongMoves = 0;

    public static void main(String[] args) {
        new Main().startGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sudoku Puzzle Game!");
        while (true) {
            System.out.println("\nChoose difficulty level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            generatePuzzle(choice);
            play(scanner);
            System.out.print("Do you want to play again? (Y/N): ");
            char again = scanner.next().charAt(0);
            if (again == 'N' || again == 'n') {
                System.out.println("Thank you for playing Sudoku Puzzle Game!");
                break;
            }
        }
        scanner.close();
    }

    public void play(Scanner scanner) {
        startTime = System.currentTimeMillis();
        moveCount = 0;
        wrongMoves = 0;
        while (true) {
            printBoard();
            System.out.print("Enter your solution (row col value) or 'q' to quit: ");
            if (scanner.hasNext("q")) {
                System.out.println("Game exited.");
                scanner.next();
                return;
            }
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            int num = scanner.nextInt();

            if (solution[row][col] != 0 && board[row][col] != 0) {
                System.out.println("You cannot change given numbers!");
                continue;
            }

            if (isValidMove(row, col, num)) {
                board[row][col] = num;
                moveCount++;
            } else {
                System.out.println("Invalid move, try again.");
                wrongMoves++;
                if (wrongMoves % 3 == 0) {
                    System.out.println("something's wrong in 3 past choices >:)");
                }
            }

            if (isSolved()) {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                System.out.printf("Congratulations! You solved the Sudoku puzzle in %d minutes and %d seconds!\n", elapsedTime / 60, elapsedTime % 60);
                break;
            }
        }
    }

    public void generatePuzzle(int difficulty) {
        System.out.println("\nGenerating Sudoku puzzle...");

        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], 0);
            Arrays.fill(solution[i], 0);
        }
        if (!fillBoard(solution)) {
            System.out.println("Failed to generate a complete Sudoku solution.");
            return;
        }

        for (int i = 0; i < 9; i++) {
            System.arraycopy(solution[i], 0, board[i], 0, 9);
        }

        int clues = (difficulty == 1 ? 35 : (difficulty == 2 ? 27 : 20));
        removeNumbers(clues);
    }

    private boolean fillBoard(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    List<Integer> numbers = new ArrayList<>();
                    for (int num = 1; num <= 9; num++) {
                        numbers.add(num);
                    }
                    Collections.shuffle(numbers);
                    for (int num : numbers) {
                        if (isSafe(grid, row, col, num)) {
                            grid[row][col] = num;
                            if (fillBoard(grid)) {
                                return true;
                            }
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {
        // Проверка строки и столбца
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num || grid[i][col] == num)
                return false;
        }
        // Проверка 3x3 блока
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[boxRowStart + i][boxColStart + j] == num)
                    return false;
            }
        }
        return true;
    }

    private void removeNumbers(int clues) {
        int totalCells = 9 * 9;
        int cellsToRemove = totalCells - clues;
        Random rand = new Random();
        while (cellsToRemove > 0) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    public boolean isValidMove(int row, int col, int num) {
        return board[row][col] == 0 && isSafe(board, row, col, num);
    }

    public boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("\nSudoku Puzzle:");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print((board[i][j] == 0 ? "_" : board[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
