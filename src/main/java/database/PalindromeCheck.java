package database;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class PalindromeCheck {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String ans;
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    set.add(s.charAt(i));
                    set.add(s.charAt(j));


                }

            }

        }

        System.out.println(set);


    }}

