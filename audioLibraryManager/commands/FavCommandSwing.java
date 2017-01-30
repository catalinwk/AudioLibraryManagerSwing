/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audioLibraryManager.commands;
import audioLibraryManager.commands.interfaces.*;
import audioLibraryManager.*;

import java.io.*;
import java.util.*;


/**
 * Add a file to favorite lists
 * @author Catalin Mazilu
 */
public class FavCommandSwing 
implements AudioCommand
{
    /**
     * name of the command
     */       
    public String name ="fav";
    
    /**
     * Path to the favorite file list
     */
    public String favorite_path =".";
  
    /**
     * Initialize default current directory
     */
    public FavCommandSwing () {
        File f = new File(new File("favorite.txt").getAbsolutePath());
        favorite_path=f.getAbsolutePath();
    }
    
    
    
    /**
     * Returns the name of the command
     * @return name of command
     */
      public String getName(){
    
        return name;
        
    }
 
    
    /**
     * Add the audio file to favorites list
     */
    public void runCommand(ShellPath path, String filePath)
    throws CommandException
    {
            System.out.println("Favorite Path is" + favorite_path);
            File f = new File(new File(filePath).getAbsolutePath());
    
            if (f.exists()) {
                /*
                 * add the file to favorite file
                 */
                
                
                try (BufferedWriter favfile = new BufferedWriter(new FileWriter(favorite_path,true))) {
                   
                     favfile.write(f.getAbsolutePath().toString());
                     /*
                      * Adds new line - taken from BufferedWriter class
                      */
                     favfile.newLine();
                     
                   
                } catch (IOException e){
                    //System.out.println(e.getMessage());
                    throw(new CommandException(e.getMessage()));
                }
                
            } else {

                throw(new CommandException("Incorect path"));

            }
    }
    
}
