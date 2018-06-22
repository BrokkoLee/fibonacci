import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Fibonacci {
    static int range;
    static ArrayList<Integer> listRec = new ArrayList<>();
    static ArrayList<Integer> listIter = new ArrayList<>();
    static ArrayList<Integer> listArr = new ArrayList<>();
    static LinkedList<Integer> listLink = new LinkedList<>();
    static int[] listInt = new int[100];

    public static void main(String[] args){
        Fibonacci fibo = new Fibonacci();

        fibo.scanRange();

        long startTime = System.nanoTime();
        fibo.iteration(range);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.format("Iteration time:" + "%10d", duration);

        long startTime2 = System.nanoTime();
        fibo.recursion(range);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.format("\nRecursion time:" + "%10d", duration2);

        long startTime3 = System.nanoTime();
        fibo.arrList(range);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        System.out.format("\nArrayList time:" + "%10d", duration3);

        long startTime5 = System.nanoTime();
        fibo.arrLink(range);
        long endTime5 = System.nanoTime();
        long duration5 = (endTime5 - startTime5);
        System.out.format("\nLinkedLit time:" + "%10d",duration5);

        long startTime4 = System.nanoTime();
        fibo.intList(range);
        long endTime4 = System.nanoTime();
        long duration4 = (endTime4 - startTime4);
        System.out.format("\nint[] time:" + "%14d",duration4);

        /*
        System.out.println(listRec);
        System.out.println(listIter);
        System.out.println(listArr);
        System.out.println(listLink);
        for (Integer number : listInt) {
            System.out.print(number + " ");
        }
        */

    }
    void scanRange(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the Fib sequence: ");
        range = sc.nextInt();
    }

    void iteration(int range){
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i <= range; i++) {
            listIter.add(a);
            a = b;
            b += c;
            c = a;
        }
    }

    int fibonacci(int number)  {
        if (number == 0)
            return 0;
        else if(number == 1 || number == 2){
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number -2);
    }
    void recursion(int range){
        int index = 0;
        while (index != range + 1){
            listRec.add(fibonacci(index));
            index++;
        }
    }

    void arrList(int range){
        if (range == 1){
            listArr.add(0);
        } else if (range == 2){
            listArr.add(0);
            listArr.add(1);
        } else {
            listArr.add(0);
            listArr.add(1);
            int size = 0;
            while (range != size) {
                size = listArr.size();
                listArr.add(listArr.get(size - 1) + listArr.get(size - 2));
            }
        }
    }

    void arrLink(int range){
        if (range == 1){
            listLink.add(0);
        } else if (range == 2){
            listLink.add(0);
            listLink.add(1);
        } else {
            listLink.add(0);
            listLink.add(1);
            int size = 0;
            while (range != size) {
                size = listLink.size();
                listLink.add(listLink.get(size - 1) + listLink.get(size - 2));
            }
        }
    }

    void intList (int range){
        if (range == 1){
            listInt[0] = 0;
        } else if (range == 2){
            listInt[0] = 0;
            listInt[1] = 1;
        } else {
            listInt[0] = 0;
            listInt[1] = 1;
            int bit = 1;
            while (range != bit) {
                bit++;
                listInt[bit] = listInt[bit-1] + listInt[bit-2];
            }
        }
    }
}