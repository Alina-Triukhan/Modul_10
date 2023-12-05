package Task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountContains {
    public static void main(String[] args) {
        String filePath = "words.txt";
        Map<String, Integer> map = mapCounter(filePath);

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
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