/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stain
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PRAC_4 {
    private String absFileName;

    public PRAC_4(String absFileName) {
        this.absFileName = absFileName;
    }

    public boolean search(String word) {
        boolean found = false;

        try {
            File file = new File(absFileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                if(scanner.nextLine().indexOf(word) != -1) {
                    found = true;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return found;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a file name > ");
        String fileName = scanner.nextLine();

        PRAC_4 fileSearcher = new PRAC_4(fileName);

        System.out.println("Enter a word filter > ");
        String word = scanner.nextLine();
        scanner.close();

        boolean found = fileSearcher.search(word);
        if (found) {
            System.out.println("Word found");
        } else {
            System.out.println("Word not found");
        }
    }

}
