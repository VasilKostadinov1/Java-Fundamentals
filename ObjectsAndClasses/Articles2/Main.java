package DEMO.ObjectsAndClasses_Exercises.Articles2_04;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articleList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article article = new Article(input[0], input[1], input[2]);
            articleList.add(article);
        }
        String input = scanner.nextLine();

        switch (input) {
            case "title":
                articleList.stream().sorted(Comparator.comparing(Article::getTitle)).forEach(System.out::println);
                break;
            case "content":
                articleList.stream().sorted(Comparator.comparing(Article::getContent)).forEach(e -> System.out.println(e.toString()));
                break;
            case "author":
                articleList.stream().sorted(Comparator.comparing(Article::getAuthor)).forEach(e -> System.out.println(e.toString()));
                break;
        }


    }
}
