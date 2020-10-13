package com.cybertek.tests.Bitrix_US1;

public class SwapTwoNumbers {
            public static void main (String args[]) {
            int x = 20;
            int y =30;
            System.out.println("Numbers before swapping");
            System.out.println("number x is " + x);
            System.out.println("number y is " +y);
// Swapping numbers
            x= x+y;
            y=x-y;
            x=x-y;
            System.out.println("Numbers after swapping");
            System.out.println(" number x is " + x);
            System.out.println("number y is " +y);

                System.out.println("=============Reverse_Number=============");

                int num = 10025;
                System.out.println("Input - " + num + " Output:" +
                        reverseNo(num));
            }

    public static int reverseNo(int number) {
        int reversed = 0;

        while(number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return  reversed;
    }
}


