
package DEMO.ArraysExercises;

import java.util.Scanner;

public class ArrayRotation2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] newArr = new String[arr.length];
            newArr[newArr.length - 1] = arr[0];
            System.arraycopy(arr, 1, newArr, 0, arr.length - 1);
            arr = newArr;
        }
        System.out.println(String.join(" ", arr));
    }
}
