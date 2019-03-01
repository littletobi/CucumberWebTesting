package helpers;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializer {

    public static void main(String[] args) throws IOException {
        User user1 = new User();
        User user2 = new User();
        List<User> listOfSettings = new ArrayList<>();

        user1.setId(1);
        user1.setFirstName("John");
        user2.setLastName("Doe");
        user1.setUserPassword("password1");
        user1.setEmail("johndoe@onet.pl");

        user2.setId(2);
        user2.setFirstName("Tobi");
        user2.setLastName("Kenobi");
        user2.setUserPassword("password2");
        user1.setEmail("tobi@gmail.com");

        //Before serialization
        listOfSettings.add(user1);
        listOfSettings.add(user2);
        System.out.println("BEFORE " + listOfSettings.toString());
        serializeToXML(listOfSettings);
        List<User> loadedSettings = deserializeFromXML();
        //After serialization
        System.out.println("AFTER " + loadedSettings.toString());
    }

    private static void serializeToXML(List<User> listOfUserSettings) throws IOException {
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\settings.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.writeObject(listOfUserSettings);
        encoder.close();
        fos.close();
    }

    private static List<User> deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\settings.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        @SuppressWarnings("unchecked")
        List<User> decodedSettings = (List<User>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }
}