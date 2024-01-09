package datastructure.string;

public class SumString {
    public String sum(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SumString sumString = new SumString();
        String num1 = "1234";
        String num2 = "456";

        String sum = sumString.sum(num1, num2);

        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
    }
}
