/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audioLibraryManager;
import audioLibraryManager.commands.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 * This class test the console for changing currentPath and listing files
 * @author Catalin Mazilu
 */
public class SimpleTest {
    
    /*
     * this is used to store current pathcdcd
     */
    public static String currentPath = ".";
   
    /**
     * List the directory specified
     * @param direcotry name
     */
   public static void listDirectory(String param){
       File path = new File(param);
        String[] list;
        
        list = path.list();
        System.out.println("Current path is " + path.getAbsolutePath());
        
        
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
        System.out.println(dirItem);
   }
   
   /**
    * changes current directory
    * @param param 
    */
   public static void changeDirectory(String param){
       
   }
   
   /**
    * Creates an command line interface for working with files
    * @param args 
    */
    
    public static void main(String[] args){
         String command = "";
    
         /*while (!command.contains("exit")){
                       
                Scanner s = new Scanner(System.in);
                command = s.nextLine();
               
                if (command.contains("ls")) {
                    
                    System.out.println("Listing...");
                    listDirectory("./");
                }
                
               if (command.contains("cd"))
                    System.out.println("Changing directory...");
               
               if (command.contains("help")) {
                   System.out.println("help - getting commnmand list");
                   System.out.println("ls [directory] lists direcotry contents");
                   System.out.println("cd  change current direcotry");
               }
        }
         */

         AudioShell as = new AudioShell();
         
         /*
          * Registering the commands
          */
         
         as.registerCommand(new CdCommand());
         as.registerCommand(new ListCommand());
         as.registerCommand(new PlayCommand());
         as.registerCommand(new InfoCommand());
         as.registerCommand(new FavCommand());
         as.registerCommand(new ReportCommand());
         as.registerCommand(new FindCommand());
         
         as.initShell();
    }
    
    
}
