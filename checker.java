public class mainReversi {
    public static void main (String[] args) {
        char[][] board = { {'X', 'O', 'X', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-', '-', '-', '-'} };
        char playerChar = 'X';
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

