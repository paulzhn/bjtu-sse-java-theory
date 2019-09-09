package exercise3;

import java.util.Scanner;

public class JudgeSymmetric {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a;
        StringBuffer b;

        System.out.println("Input a string: ");
        a = sc.next();
        b = new StringBuffer(a);
        if(a.equals(b.reverse().toString())) {
            System.out.println("Is a symmetric string");
        } else {
            System.out.println("Isn't a symmetric string");
        }

    }
}
