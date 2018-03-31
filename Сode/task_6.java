//   Задание 6
//   Необходимо написать программу, которая удаляет из текста числа.
//   Текст вводится вручную во время выполнения программы.

import java.util.Scanner;


public class task_6{

    public static String deleteNumber(String str){
        for(int i = 0; i < 10; i++){
            str = str.replaceAll(String.valueOf(i), "");
        }

        return str;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Entered string");
        System.out.print("You entered >> ");
        System.out.println(deleteNumber(in.nextLine()));
    }
}