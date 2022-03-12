package DEMO.TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String file = input.substring(input.lastIndexOf("\\") + 1);  // file = "Template.pptx"

        System.out.printf("File name: %s%nFile extension: %s",
                file.substring(0, file.indexOf(".")), file.substring(file.indexOf(".") + 1));

        /*String[] file = scanner.nextLine().split("\\\\");
        String last = file[file.length-1];             // Template.pptx
        String[] split = last.split("\\.");       // ["Template" , "pptx"]

        System.out.printf("File name: %s\n",split[0]);
        System.out.printf("File extension: %s",split[1]);*/

        //System.out.println("unhappy".substring(2)); -> happy
    }
}
