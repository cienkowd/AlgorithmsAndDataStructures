package pl.edu.pw.ee.aisd2023zlab6.lcs;

public class LongestCommonSubsequence {

    public static String findLcs(String topText, String leftText) {
        int x = topText.length() + 1 ;
        int y = leftText.length() + 1;
        int[][] board = new int[x][y];
        char[][] marks = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0) {
                    board[i][j] = 0;
                    marks[i][j] = '-';
                }
                else {
                    if(topText.charAt(i-1) == leftText.charAt(j-1)) {
                        board[i][j] = board[i-1][j-1] + 1;
                        marks[i][j] = '\\';
                    }
                    else {
                        if(board[i-1][j] != board[i][j-1]) {
                            board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
                            if(board[i][j] == board[i-1][j]) marks[i][j] = '<';
                            else marks[i][j] = '^';
                        }
                        else {
                            board[i][j] = board[i][j-1];
                            marks[i][j] = '^';
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(board[j][i] + " ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                System.out.print(marks[j][i] + " ");
//            }
//            System.out.println();
//        }

        char checkingMark = marks[--x][--y];
        StringBuilder pullUp = new StringBuilder();
        while(x != 0 && y != 0) {
            if(checkingMark == '-') {
                break;
            }
            if(checkingMark == '<') {
                checkingMark = marks[--x][y];
            }
            else if(checkingMark == '^') {
                checkingMark = marks[x][--y];
            }
            else {
                pullUp.insert(0,topText.charAt(x-1));
                checkingMark = marks[--x][--y];
            }
        }
        return pullUp.toString();
    }

    public static void main(String[] args) {
        String topText = "PIEROGI";
        String leftText = "WIROG";
        String essa = findLcs(topText,leftText);
        System.out.println(essa);
    }
}
