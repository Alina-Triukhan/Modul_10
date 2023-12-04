package Task_2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertToJsonTest {
    public static void main(String[] args) {
        try {
            List<User> users = readFromFile("fileForJson.txt");
            writeToJsonFile(users, "user.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readFromFile(String filePath) throws IOException {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String title = br.readLine();
            String[] titleNames = title.split(" ");
            String fieldUser;
            while ((fieldUser = br.readLine()) != null) {
                String[] values = fieldUser.split(" ");
                User user = new User();

                for (int i = 0; i < Math.min(titleNames.length, values.length); i++) {
                    if (titleNames[i].equals("name")) {
                        user.setName(values[i]);
                    } else if (titleNames[i].equals("age")) {
                        user.setAge(Integer.parseInt(values[i]));
                    }
                }
                users.add(user);
            }
        }
        return users;
    }

    public static void writeToJsonFile(List<User> users, String s) throws IOException {
        try (FileWriter fw = new FileWriter(s)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, fw);
        }
    }
}