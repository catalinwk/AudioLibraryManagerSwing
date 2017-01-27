/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audioLibraryManager;
import audioLibraryManager.commands.interfaces.*;
import audioLibraryManager.commands.*;
import java.util.*;
import java.io.*;

/**
 * This class creates a shell to be used for a LibraryAudioManager
 * @author Catalin Mazilu
 */
public class AudioShell {
    /**
     * Used for storing registered commands
     */
    ArrayList<AudioCommand> commandList = new ArrayList<AudioCommand>();
    
    /**
     * Storing current Path to display
     */
    
     
    ShellPath shellPath = new ShellPath();
    /**
     * Used to initialise CurrentPath
     */
    AudioShell(){
     
        
        
    }
    
    
    /**
     * Used to initialise Shell
     */
    
    public void initShell(){
        System.out.println("Audio Library Manager\ntype 'help' for command list");               
        //System.out.print(currentPath);
        
        
        /* reading from keyboard until exit is typed */
          String command = "";
          
         while (!command.contains("exit")){
         
                System.out.print(shellPath);
                Scanner s = new Scanner(System.in);
                command = s.nextLine();
                
                /* if nothing is entered do not check for command tokens */
                if (command.length()<3)
                       continue;
                
                /*
                 * The first element of command
                 */
             
                StringTokenizer commandToken = new StringTokenizer(command);
                 
                /*
                 * searching the commands in the registered list
                 */
                String firstToken = commandToken.nextToken();
                
                for (AudioCommand i:commandList){
                  
                    if (i.getName().equals(firstToken) )
                    {
                        try {
                            
                            i.runCommand(shellPath, command);
                            
                        } catch (CommandException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
                
               
               if (command.contains("help")) {
                   System.out.println("help - getting commnmand list");
                   System.out.println("ls [directory] lists direcotry contents");
                   System.out.println("cd [directory] change current direcotry");
                   
                   
               }
         }//end while
        
        
    }
    
    
    public void registerCommand(AudioCommand c){
        commandList.add(c);
    }
    
    
    public void runCommand(){
        
    }
    
    
}
