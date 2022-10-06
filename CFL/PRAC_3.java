/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stain
 */
import java.io.File;
import java.util.Scanner;


public class PRAC_3 {
    private String directoryPath;

    public PRAC_3(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void search(String filter) {
        File file = new File(directoryPath);
        File[] fileArray = file.listFiles();

        for (File file2 : fileArray) {
            if (file2.isDirectory()) {
                continue;
            }
            if (file2.getName().startsWith(filter)) {
                System.out.println(file2.getName());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a directory > ");
        String directoryPath = scanner.nextLine();

        PRAC_3 directorySearcher = new PRAC_3(directoryPath);

        System.out.println("Enter filter > ");
        String filter = scanner.nextLine();

        directorySearcher.search(filter);

        scanner.close();
    }

}
