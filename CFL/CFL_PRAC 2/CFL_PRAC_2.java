/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author admin
 */

public class CFL_PRAC_2 {
    FileWriter fileWriter;

    public CFL_PRAC_2(String filePath, boolean appendMode) {
        try {
            fileWriter = new FileWriter(filePath, appendMode);
        }
        catch (IOException e) {
            System.err.println("IOError: File could not be opened");
            e.printStackTrace();
        }
    }
    
    public void writeLog(String message, String intensity) {
        String datetime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        try {
            fileWriter.write(datetime + "\t\t" + message + "\t\t" + intensity + "\n");
            fileWriter.flush();
        }
        catch (IOException e) {
            System.err.println("IOError: Log could not be written");
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("IOError: File could not be closed");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        CFL_PRAC_2 customLogger = new CFL_PRAC_2("log.txt", true);
        String[] intensity = {"INFO", "WARNING", "ERROR", "CRITICAL"};
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            customLogger.writeLog("Log " + i, intensity[random.nextInt(4)]);
        }

        customLogger.close();
    }
}
