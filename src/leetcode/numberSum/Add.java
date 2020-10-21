package leetcode.numberSum;

public class Add {

    public String sum(String a, String b) {
        int alength = a.length();
        int blength = b.length();
        int clength;
        if (alength >= blength) clength = alength;
        else clength = blength;

        int[] aa = new int[clength];
        for (int p = 0; p < clength; p++) {
            aa[p] = 0;
        }
        int[] bb = new int[clength];
        for (int p = 0; p < clength; p++) {
            bb[p] = 0;
        }
        int i, j;
        for (i = alength - 1; i >= 0; i--) {
            aa[alength - i - 1] = (int) a.charAt(i);
        }

        for (j = blength - 1; j >= 0; j--) {
            bb[blength - j - 1] = (int) b.charAt(j);
        }

        int[] cc = new int[clength + 1];
        for (int p = 0; p < clength + 1; p++) {
            cc[p] = 0;
        }

        for (int k = clength - 1; k >= 0; k--) {
            cc[clength - k - 1] += aa[clength - k - 1] + bb[clength - k - 1];
            if (cc[clength - k - 1] >= 36) {
                cc[clength - k - 1] = cc[clength - k - 1] - 36;
                cc[clength - k] = 1;
            }
        }
        StringBuilder c = new StringBuilder();
        for (int m = 0; m < clength; m++) {
            c.append(cc[m]);
        }

        return c.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Add().sum("z", "1"));
    }

}
