package DEMO.MethodsExecises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (input) {
                case "exchange":
                    int exchangeIndex=Integer.parseInt(command[1]);
                    if(exchangeIndex<0||exchangeIndex>array.length-1){
                        System.out.println("Invalid index");
                    }else {
                        exchangeArray(array, exchangeIndex);
                    }

                    break;
                case "max":

                    break;
                case "min":

                    break;
            }


            input = scanner.nextLine();
        }

    }

    private static void exchangeArray(int[] arr, int exchangeIndex) {
        int [] arrDuplicate=new int [arr.length];
        int a=arr.length-1;
        for (int i = exchangeIndex; i >= 0; i--) {
            arrDuplicate[a] = arr[i];
            a--;
        }
        a=0;
        for (int i = exchangeIndex+1; i < arr.length; i++) {
            arrDuplicate[a]=arr[i];
            a++;
        }
        System.arraycopy(arrDuplicate, 0, arr, 0, arr.length);
    }
}
