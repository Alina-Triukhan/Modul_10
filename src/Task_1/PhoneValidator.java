package Task_1;


import java.io.*;

public class PhoneValidator {
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
                if (isPhoneNumberValid(phones)) {
                    System.out.println(phones);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isPhoneNumberValid(String phoneNumber) {
        String phoneRegex = "^\\((\\d{3})\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";
        return phoneNumber.matches(phoneRegex);
    }
}
