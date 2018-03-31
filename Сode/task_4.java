//   Задание 4
//   Необходимо написать рекурсивный алгоритм для нахождения НОД и НОК двух чисел.
//   Два числа вводятся вручную во время выполнения программы.

import java.util.Scanner;

public class task_4{

    // Алгоритм Евклида
    public static int NOD(int a, int b){
        if (a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        if(b == 0){
            return a;
        }
        return NOD(b, a % b);
    }

    // Из связи НОК и НОД
    public static int NOK(int a, int b){
        return a * b / NOD(a, b);
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two numbers");
        System.out.print("You entered >> ");
        
        try{
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println("NOD: " + String.valueOf(NOD(a, b)) + "\nNOK: " + String.valueOf(NOK(a, b)));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }  
    }
}