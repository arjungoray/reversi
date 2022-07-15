import java.util.Scanner; 
import java.util.ArrayList;
public class mainReversi {
    public static void main (String[] args) {
        char[][] board = { {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'} };
        char player1Char = 'X';
        char player2Char = 'O';
        Scanner input = new Scanner(System.in);
        while (boardFull == false) {
            int player1MoveX = 0;
            int player1MoveY = 0;
            int player2MoveX = 0;
            int player2MoveY = 0;
            boolean allowed = false;
            while (allowed == false) {
                System.out.println("Player 1 X");
                player1MoveX = Integer.parseInt(input.nextLine());
                System.out.println("Player 1 Y");
                player1MoveY = Integer.parseInt(input.nextLine());
                allowed = checkMove(board,player1MoveX,player1MoveY);
            }
            board[player1MoveY][player1MoveX] = player1Char;
            board = flips(board,player1Char);
            printBoard(board);
            allowed = false;
            while (allowed == false) {
                System.out.println("Player 2 X");
                player2MoveX = Integer.parseInt(input.nextLine());
                System.out.println("Player 2 Y");
                player2MoveY = Integer.parseInt(input.nextLine());
                allowed = checkMove(board,player2MoveX,player2MoveY);
            }
            board[player2MoveY][player2MoveX] = player2Char;
            board = flips(board,player2Char);
            printBoard(board);
            boardFull = checkFull(board,player1Char,player2Char);
        }
        //printBoard(board);
    }
    public static boolean boardFull = false;
    public static char[][] tempBoard;
    static boolean checkFull(char[][] board, char player1, char player2) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    static void printBoard(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
    static boolean checkMove(char[][] board, int x, int y) {
        if (board[y][x] != '-') {
            return false;
        }
        return true;
    }
    static char[][] flips(char[][] board, char playerChar) {
        tempBoard = board;
        tempBoard = checkHorizontal(playerChar);
        tempBoard = checkVertical(playerChar);
        tempBoard = checkDiagnolEasy(playerChar);
        tempBoard = checkDiagnolHard(playerChar);
        return tempBoard;
    }
    static char[][] checkHorizontal(char playerChar) {
        char[][] board = tempBoard;
        for (int y = 0; y < 8; y++) {
            int start = 10; 
            int end = 10; 
            for (int x = 0; x < 8; x++) {
                if (board[y][x] == playerChar && start == 10 && end == 10) {
                    start = x;
                    end = x;
                } else if (board[y][x] == playerChar && x > end) {
                    end = x;
                } else if (board[y][x] == playerChar && x < start) {
                    start = x;
                }
            }
            if (start != end) {
                for (int z = start + 1; z < end; z++) {
                    board[y][z] = playerChar;
                }
            }
            start = 0;
            end = 0;
        }
        return board;
    }
    static char[][] checkVertical(char playerChar) {
        char[][] board = tempBoard;
        for (int y = 0; y < 8; y++) {
            int start = 10; 
            int end = 10; 
            for (int x = 0; x < 8; x++) {
                if (board[x][y] == playerChar && start == 10 && end == 10) {
                    start = x;
                    end = x;
                } else if (board[x][y] == playerChar && x > end) {
                    end = x;
                } else if (board[x][y] == playerChar && x < start) {
                    start = x;
                }
            }
            if (start != end) {
                for (int z = start + 1; z < end; z++) {
                    board[z][y] = playerChar;
                }
            }
            start = 0;
            end = 0;
        }
        return board;
    }
    static char[][] checkDiagnolEasy(char playerChar) {
        char[][] board = tempBoard;
        int start = 10;
        int end = 10;
        for (int x = 0; x < 8; x++) {
            if (board[x][x] == playerChar && start == 10 && end == 10) {
                start = x;
                end = x;
            } else if (board[x][x] == playerChar && x > end) {
                end = x;
            } else if (board[x][x] == playerChar && x < start) {
                start = x;
            }
        }
        if (start != end) {
            for (int z = start + 1; z < end; z++) {
                board[z][z] = playerChar;
            }
        }
        return board;
    }
    static char[][] checkDiagnolHard(char playerChar) {
        char[][] board = tempBoard;
        int[][] dataset = { {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0} };
        //dataset.add(0,8);
        //dataset.add(1,7);
        //System.out.println(dataset);
        for (int i = 0; i < 8; i++) {
            dataset[i][0] = i;
            dataset[i][1] = 7-i;
        }
        int start = 10;
        int end = 10;
        for (int i = 0; i < 8; i++) {
            if (board[dataset[i][0]][dataset[i][1]] == playerChar && start == 10 && end == 10) {
                start = i;
                end = i;
            } else if (board[dataset[i][0]][dataset[i][1]] == playerChar && i > end) {
                end = i;
            } else if (board[dataset[i][0]][dataset[i][1]] == playerChar && i < start) {
                start = i;
            }
        }
        if (start != end) {
            for (int i = start; i < end; i++) {
                board[dataset[i][0]][dataset[i][1]] = playerChar;
            }
        }
        return board;
    }

}