package DEMO.ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs_04 {

    public static class Song {
        private String typeList;
        private String name;
        private String time;

        public String getTypeList() {  // Alt + Insert !!! Auto generate Getters & Setters
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song currentSong = new Song();    // currently is "null"
            currentSong.setTypeList(type);    // fill-in the current song
            currentSong.setName(name);
            currentSong.setTime(time);

            songs.add(currentSong);
        }
        String typeList = scanner.nextLine();  // receive type list to filter
        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(typeList))
                    System.out.println(song.getName());
            }
        }
        /*List<Song> filterSong = songs.stream().filter(e->e.getTypeList().equals(typeList)).collect(Collectors.toList());
        for (Song song : filterSong) {
            System.out.println(song.getName());
        }*/


    }
}
