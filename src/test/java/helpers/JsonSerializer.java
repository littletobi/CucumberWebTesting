package helpers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonSerializer {

    public static void main(String[] args) throws IOException {
        User user1 = new User();
        User user2 = new User();
        List<User> listOfSettings = new ArrayList<>();

        user1.setId(1);
        user1.setFirstName("Johny");
        user1.setLastName("Bravo");
        user1.setUserPassword("password1");
        user1.setEmail("johnybravo@gmail.com");

        user2.setId(2);
        user2.setFirstName("James");
        user2.setLastName("Bond");
        user2.setUserPassword("password2");
        user2.setEmail("james@gmail.com");

        //Before serialization
        listOfSettings.add(user1);
        listOfSettings.add(user2);
        System.out.println("BEFORE " + listOfSettings.toString());

        serializeToJson(listOfSettings);

        List<User> loadedSettings = deserializeFromJson(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\settings.json");
        //After serialization
        System.out.println("AFTER " + loadedSettings.toString());
    }

    private static void serializeToJson(List<User> userSettings) throws IOException {
        try {
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\settings.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(userSettings, fw);
            fw.close();
        } catch (IOException e) {
            System.out.println("Exception! :" + e.toString());
        }
    }

    public static List<User> deserializeFromJson(String path) throws IOException {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<User>>() {
        }.getType();
        FileReader fr = new FileReader(path);

        List<User> decodedSettings = gson.fromJson(fr, collectionType);
        fr.close();
        return decodedSettings;
    }
}