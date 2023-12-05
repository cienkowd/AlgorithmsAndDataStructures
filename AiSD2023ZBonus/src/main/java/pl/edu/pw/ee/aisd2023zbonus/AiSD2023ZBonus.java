package pl.edu.pw.ee.aisd2023zbonus;

public class AiSD2023ZBonus {

    public static int findSmallerOfTwo(int c) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(c));
        StringBuilder binarySmall = new StringBuilder();
        StringBuilder binaryBig = new StringBuilder();
        boolean check = true;
        for (int i = 0; i < binary.length(); i++) {
            if (check) {
                binaryBig.append(binary.charAt(i));
                binarySmall.append('0');
                check = false;
            } else {
                binarySmall.append(binary.charAt(i));
                binaryBig.append('0');
                check = true;
            }
        }
        return Integer.parseInt(String.valueOf(binarySmall),2);
    }
}