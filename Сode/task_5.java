//   Задание 5 
//   Необходимо написать программу, которая проверяет слово на "палиндромность".
//   Слово для проверки вводится вручную во время выполнения программы.

import java.util.Scanner;


public class task_5{

    public static boolean checkingForPalindrom(String str){
        return str.equalsIgnoreCase(((new StringBuffer(str)).reverse()).toString());
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word to check");
        System.out.print("You entered >> ");
        
        if(checkingForPalindrom(in.nextLine())){
            System.out.println("Palindrom");
        }else{
            System.out.println("Not palindrom");
        }
    }
}