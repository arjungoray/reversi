import java.util.ArrayList;
public class checker {
    public static void main (String[] args) {
        char[][] board = { {'-', '-', '-', '-', '-', '-', '-', 'X'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'} };
        char playerChar = 'X';
        int[][] dataset = {};
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
        printBoard(board);
    }
    static void printBoard(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}        

