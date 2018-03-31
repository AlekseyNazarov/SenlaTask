//   Задание 1 
//   Необходимо написать программу, которая вычисляет простые числа в пределах
//   от 1 до N.  N – вводится вручную во время выполнения программы.
//   Реализован алгоритм "Решето Эратрофена"

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class task_1{

    public static ArrayList<Integer> algorithmEratosthenes(int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] numArr = new boolean[n];
        Arrays.fill(numArr, true);

        for(int i = 2; i < n; i++){
            if (numArr[i]){
                result.add(i);
                for(int j = i * i; j < n; j += i){
                    numArr[j] = false;
                }
            }
        }    

        return result;   
    }

    public static void main(String args[]){
        System.out.print("Border >> ");
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> result = algorithmEratosthenes(in.nextInt() + 1);
        for(Integer tmp : result){
            System.out.print(String.valueOf(tmp) + " ");
        }
    }
}