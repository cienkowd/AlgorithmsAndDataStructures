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

    public static void main(String[] args) {
//        String topText = "Panno święta, co Jasnej bronisz Częstochowy I w Ostrej świecisz Bramie! Ty, co gród zamkowy Nowogródzki ochraniasz z jego wiernym ludem! Jak mnie dziecko do zdrowia powróciłaś cudem(Gdy od płaczącej matki, pod Twoją opiekę Ofiarowany, martwą podniosłem powiekę; I zaraz mogłem pieszo, do Twych świątyń progu Iść za wrócone życie podziękować Bogu), Tak nas powrócisz cudem na Ojczyzny łono. Tymczasem przenoś moją duszę utęsknioną Do tych pagórków leśnych, do tych łąk zielonych, Szeroko nad błękitnym Niemnem rozciągnionych; Do tych pól malowanych zbożem rozmaitem, Wyzłacanych pszenicą, posrebrzanych żytem; Gdzie bursztynowy świerzop, gryka jak śnieg biała, Gdzie panieńskim rumieńcem dzięcielina pała, A wszystko przepasane jakby wstęgą, miedzą Zieloną, na niej z rzadka ciche grusze siedzą.";
//        String leftText = "Śród takich pól przed laty, nad brzegiem ruczaju, Na pagórku niewielkim, we brzozowym gaju, Stał dwór szlachecki, z drzewa, lecz podmurowany; Świeciły się z daleka pobielane ściany, Tym bielsze, że odbite od ciemnej zieleni Topoli, co go bronią od wiatrów jesieni. Dom mieszkalny niewielki, lecz zewsząd chędogi, I stodołę miał wielką, i przy niej trzy stogi Użątku, co pod strzechą zmieścić się nie może. Widać, że okolica obfita we zboże, I widać z liczby kopic, co wzdłuż i wszerz smugów Świecą gęsto jak gwiazdy, widać z liczby pługów Orzących wcześnie łany ogromne ugoru, Czarnoziemne, zapewne należne do dworu, Uprawne dobrze na kształt ogrodowych grządek: Że w tym domu dostatek mieszka i porządek. Brama na wciąż otwarta przechodniom ogłasza, Że gościnna, i wszystkich w gościnę zaprasza.";
        String topText = "PIEROGI";
        String leftText = "WIROG";
        String substring = findLcs(topText,leftText);
        System.out.println(substring);
    }
}
