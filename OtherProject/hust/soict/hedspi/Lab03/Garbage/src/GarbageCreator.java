package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.txt";
        byte[] inputBytes = { 0 };

        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));

        startTime = System.currentTimeMillis();

        String outputString = "";

        for (byte b : inputBytes) {
            outputString += (char) b;
            // mỗi lần nối tạo object mới là "garbage"
        }

        endTime = System.currentTimeMillis();

        System.out.println("Time using String (+): " + (endTime - startTime) + "ms");
    }
}