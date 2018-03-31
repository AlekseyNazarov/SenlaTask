//   Задание 3
//   Необходимо написать рекурсивный алгоритм, которая определяет пересекаются ли два отрезка.
//   Координаты отрезков вводятся вручную во время выполнения программы.

import java.util.Scanner;
import java.lang.Math;

public class task_3{

    // Проверка на пересечение с использованием проекций
    public static boolean checkIntersectionCutsProjection(Cut cut_1, Cut cut_2){
        // Проверка проекций на ось абсцис
        if(!(((Math.min(cut_1.p_1.x, cut_1.p_2.x) <= cut_2.p_1.x) && (Math.max(cut_1.p_1.x, cut_1.p_2.x) >= cut_2.p_1.x)) || ((Math.min(cut_1.p_1.x, cut_1.p_2.x) <= cut_2.p_2.x) && (Math.max(cut_1.p_1.x, cut_1.p_2.x) >= cut_2.p_2.x)))){
            if(!(((Math.min(cut_2.p_1.x, cut_2.p_2.x) <= cut_1.p_1.x) && (Math.max(cut_2.p_1.x, cut_2.p_2.x) >= cut_1.p_1.x)) || ((Math.min(cut_2.p_1.x, cut_2.p_2.x) <= cut_1.p_2.x) && (Math.max(cut_2.p_1.x, cut_2.p_2.x) >= cut_1.p_2.x)))){
                return false;
            }
        }

        // Проверка проекций на ось ординат
        if(!(((Math.min(cut_1.p_1.y, cut_1.p_2.y) <= cut_2.p_1.y) && (Math.max(cut_1.p_1.y, cut_1.p_2.y) >= cut_2.p_1.y)) || ((Math.min(cut_1.p_1.y, cut_1.p_2.y) <= cut_2.p_2.y) && (Math.max(cut_1.p_1.y, cut_1.p_2.y) >= cut_2.p_2.y)))){
            if(!(((Math.min(cut_2.p_1.y, cut_2.p_2.y) <= cut_1.p_1.y) && (Math.max(cut_2.p_1.y, cut_2.p_2.y) >= cut_1.p_1.y)) || ((Math.min(cut_2.p_1.y, cut_2.p_2.y) <= cut_1.p_2.y) && (Math.max(cut_2.p_1.y, cut_2.p_2.y) >= cut_1.p_2.y)))){
                return false;
            }            
        }
        return true;
    }

    // Векторное произведение
    public static int vectorProduct(Point p_1, Point p_2){
        return p_1.x * p_2.y - p_1.y * p_2.x;
    }

    // Проверка на пересечение с использованием векторного произведения
    public static boolean checkIntersectionCutsVector(Cut cut_1, Cut cut_2){
        int v1 = vectorProduct(new Point(cut_2.p_2.x - cut_2.p_1.x, cut_2.p_2.y - cut_2.p_1.y), new Point(cut_1.p_1.x - cut_2.p_1.x, cut_1.p_1.y - cut_2.p_1.y));
        System.out.println(v1);
        int v2 = vectorProduct(new Point(cut_2.p_2.x - cut_2.p_1.x, cut_2.p_2.y - cut_2.p_1.y), new Point(cut_1.p_2.x - cut_2.p_1.x, cut_1.p_2.y - cut_2.p_1.y));
        System.out.println(v2);
        int v3 = vectorProduct(new Point(cut_1.p_2.x - cut_1.p_1.x, cut_1.p_2.y - cut_1.p_1.y), new Point(cut_2.p_1.x - cut_1.p_1.x, cut_2.p_1.y - cut_1.p_1.y));
        System.out.println(v3);
        int v4 = vectorProduct(new Point(cut_1.p_2.x - cut_1.p_1.x, cut_1.p_2.y - cut_1.p_1.y), new Point(cut_2.p_2.x - cut_1.p_1.x, cut_2.p_2.y - cut_1.p_1.y));
        System.out.println(v4);

        if((v1 * v2 <= 0) && (v3 * v4 <= 0)){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter coordinates in the format");
        System.out.println("x1 y1 x2 y2 x3 y3 x4 y4");
        System.out.print("You entered >> ");
        
        try{
            if(checkIntersectionCutsProjection(new Cut(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()), new Cut(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()))){
                System.out.println("Intersect");
            }else{
                System.out.println("Do not intersect");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }  
    }
}

class Point{
    int x,
        y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Cut{
    Point p_1,
          p_2;
    
    public Cut(Point p_1, Point p_2){
        this.p_1 = p_1;
        this.p_2 = p_2;
    }

    public Cut(int x_1, int y_1, int x_2, int y_2){
        p_1 = new Point(x_1, y_1);
        p_2 = new Point(x_2, y_2);
    }
}