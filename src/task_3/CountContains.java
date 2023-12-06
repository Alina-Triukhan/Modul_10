package task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountContains {
    public static void main(String[] args) {
        String filePath = "words.txt";
        Map<String, Integer> map = mapCounter(filePath);

        Comparator<Map.Entry<String, Integer>> c = Map.Entry.<String, Integer>comparingByValue().reversed();
        Set<Map.Entry<String, Integer>> entrySet = new LinkedHashSet<>(map.entrySet().stream().sorted(c).toList());

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

//        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public static Map<String, Integer> mapCounter(String filePath) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String str;
            while ((str = br.readLine()) != null) {
                String[] words = str.trim().split(" ");
                for (int i = 0; i < words.length; i++) {
                    map.put(words[i], map.getOrDefault(words[i], 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }
}