package hems.controllers;

import hems.app_utils.ExcelWriter;
import hems.app_utils.NotepadReader;
import hems.services.AppService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    NotepadReader reader;
    
    @Autowired
    ExcelWriter excelWriter;
    

    @GetMapping("/welcome")
    public String sayHello(){
        return appService.sayHello();
    }

    @SneakyThrows
    @GetMapping("/converter")
    public String notepadReader() throws FileNotFoundException {
    	
    	//give your source text file path here
    	String s=reader.reader("C:\\Users\\batta.chowdary\\Downloads\\Things to learn - Java.txt");
    	
    	//passing the note pad contents into excel converter.
    	excelWriter.writeIntoExcel(s);
    	
    	String output;
    	output="<h1 style=\"color:blue;font-size:70px;text-align: center;\"> Hey\n HEMS </h1>\n <h2> these are the raw contents from your  text file</h2>\n\n";
    	
    	output=output.concat(s);
    	
    	output=output.concat("\n\n <h1> these things have been saved to excel</h2>\n "
    			+ "<h5 style=\"color:black;text-align: right;\"> with </h5>"
    			+ "<h3 style=\"color:red;text-align: right;\">❤</h3>"
    			+ "<h5 style=\"color:black;text-align: right;\"> from  MAHI</h5> "
    			);
    	
       return output;
    }
}
