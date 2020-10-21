package leetcode.numberSum;

/*
实现36位正数加法计算器, 使⽤0~9表示0~9,a~z表示10~35.
 */
public class ThirtySixJin {

    public String thirtySixAdd(String a, String b) {
        // swap a is longer
        String temp;
        if (a.length() < b.length()) {
            temp = b;
            b = a;
            a = temp;
        }
        // calculate
        int carry = 0;
        StringBuilder sumBuilder = new StringBuilder();
        for (int i = a.length() - 1; i > -1; i--) {
            // get last in a b
            char aLast = a.charAt(i);
            int sum;
            
            char sumChar;
            if (b.length() >= a.length() - i) {
                char blast = b.charAt(i);
                sum = changeThirtyToTen(aLast) + changeThirtyToTen(blast) + carry;
            } else {
                sum = changeThirtyToTen(aLast) + carry;
            }
            carry = 0;
            if (sum > 35) {
                carry = 1;
                sum -= 36;
            }
            sumChar = changeTenToThirty(sum);
            sumBuilder.append(sumChar);
        }
        if (carry == 1) {
            sumBuilder.append(1);
        }
        return sumBuilder.reverse().toString();
    }

    public int changeThirtyToTen(char number) {
        if (number >= 97 && number <= 122) {
            return number - 87;
        }
        String a = number + "";
        return Integer.parseInt(a);
    }

    public char changeTenToThirty(int number) {
        if (number < 10 && number >= 0) {
            String a = number + "";
            return a.charAt(0);
        } else return (char) (number + 87);
    }

    public static void main(String[] args) {
        System.out.println(new ThirtySixJin().thirtySixAdd("yyyx", "0021"));
    }
}
