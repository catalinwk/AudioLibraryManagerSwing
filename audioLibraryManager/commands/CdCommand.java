/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audioLibraryManager.commands;
import audioLibraryManager.commands.interfaces.*;
import java.io.*;
import java.util.*;


import audioLibraryManager.*;

/**
 * Used to Change Direcotory
 * @author Catalin Mazilu
 */
public class CdCommand 
implements AudioCommand

{
    /**
     * Name of the command
     */
    String name="cd";
    
    /**
     * Returns the name of the command
     * @return name of command
     */
    public String getName(){
    
        return name;
        
    }
    
    /**
     * Runs the Change Directory command
     */
    public void runCommand(ShellPath path, String args)
    throws CommandException
    {
        
        StringTokenizer commandToken = new StringTokenizer(args);
        
        if (commandToken.countTokens()>2)
            throw(new CommandException("Invalid number of arguments"));
        commandToken.nextToken();
        
        String newpath = commandToken.nextToken();
        File f = new File(newpath);
        /*
         * BUG WHEN GETS TO C:\ it meet double of \\
         */
  
        
         try {
            
                if (!path.setPath(f.getCanonicalPath()))
                throw(new CommandException("Incorect path"));    
                    
                System.setProperty("user.dir", path.getPath());
                
            } catch (IOException e){
                
            }
        
        
        
       
        
    }
    
    
    
    
}
