package Task_1;

import java.io.*;

public class PhoneValidatorTest {
//    public static void main(String[] args) {
//        String phones = "987-123-4567\n" +    //true
//                    "123 456 7890\n" +
//                    "(123) 456-7890\n" +      //true
//                    "127-233-0987\n" +        //true
//                    "987-876 7890\n" +
//                    "(783) 123-5678\n" +      //true
//                    "(783)-123-5678\n" +
//                    "4129-233-0987t\n" +
//                    "777-555-1234";            //true
//        try(FileOutputStream fileOutputStream = new FileOutputStream("file.txt")) {
//            byte[] buffer = phones.getBytes();
//            fileOutputStream.write(buffer, 0, buffer.length);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String phones;
            while ((phones = reader.readLine()) != null) {
                if (PhoneValidator.isValidPhoneNumber(phones)) {
                    System.out.println(phones);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}