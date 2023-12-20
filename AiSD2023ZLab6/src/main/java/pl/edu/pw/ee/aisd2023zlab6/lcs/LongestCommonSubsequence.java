package pl.edu.pw.ee.aisd2023zlab6.lcs;

public class LongestCommonSubsequence {

    public static String findLcs(String topText, String leftText) {
        int x = topText.length() + 1 ;
        int y = leftText.length() + 1;

        Cell[][] board = new Cell[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = new Cell();

                if (i == 0 || j == 0) {
                    board[i][j].setValue(0);
                    board[i][j].setSign('-');
                }
                else {
                    if(topText.charAt(i-1) == leftText.charAt(j-1)) {
                        board[i][j].setValue(board[i - 1][j - 1].getValue() + 1);
                        board[i][j].setSign('\\');
                    }
                    else {
                        if(board[i - 1][j].getValue() != board[i][j - 1].getValue()) {
                            board[i][j].setValue(Math.max(board[i - 1][j].getValue(), board[i][j - 1].getValue()));

                            if (board[i][j].getValue() == board[i - 1][j].getValue()) {
                                board[i][j].setSign('<');
                            }
                            else {
                                board[i][j].setSign('^');
                            }
                        }
                        else {
                            board[i][j].setValue(board[i][j - 1].getValue());
                            board[i][j].setSign('^');
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(board[j][i].getValue() + " ");
//            }
//            System.out.print("   ");
//            for (int j = 0; j < x; j++) {
//                System.out.print(board[j][i].getSign() + " ");
//            }
//            System.out.println();
//        }

        char checkingMark = board[--x][--y].getSign();
        StringBuilder substring = new StringBuilder();
        while (x != 0 && y != 0) {
            if (checkingMark == '-') {
                break;
            }
            if (checkingMark == '<') {
                checkingMark = board[--x][y].getSign();
            } else if (checkingMark == '^') {
                checkingMark = board[x][--y].getSign();
            } else {
                substring.insert(0, topText.charAt(x - 1));
                checkingMark = board[--x][--y].getSign();
            }
        }
        return substring.toString();
    }
}
