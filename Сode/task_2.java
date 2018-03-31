//   Задание 2
//   Необходимо написать рекурсивный алгоритм, который находит числа Фибоначчи в пределах
//   от 1 до N.  N – вводится вручную во время выполнения программы.

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class task_2{

    //  Рекурсивный алгоритм, слишком медленно
    public static long fibonachirRecursion(int n){  
        
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return fibonachirRecursion(n - 1) + fibonachirRecursion(n - 2);   
    }
    //  Итеративный алгоритм
    public static ArrayList<Long> fibonachiRange(int n){    
        ArrayList<Long> fbList = new ArrayList<Long>();
        fbList.add((long)0);
        fbList.add((long)1);
        fbList.add((long)1);

        if (n >= 2){
            for(int i = 3; i <= n; i++){
                fbList.add(fbList.get(i - 1) + fbList.get(i - 2));
            }
        }  

        return fbList;
    }

    public static void main(String args[]){
        System.out.print("Border >> ");
        Scanner in = new Scanner(System.in);
        int border = in.nextInt();

        for(int i = 0; i <= border; i++){
            System.out.print(Long.toString(fibonachirRecursion(i)) + " ");
        }
    }
}