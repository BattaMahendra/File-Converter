package hems.app_utils;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class NotepadReader {

    @SneakyThrows
    public String reader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);


        Scanner sc = new Scanner(file);
        StringBuilder wholeContent =new StringBuilder();
        while (sc.hasNextLine()) {
            wholeContent.append(sc.nextLine());
//            System.out.println(sc.nextLine());
        }
        String string = wholeContent.toString();
        return string;
    }
}
