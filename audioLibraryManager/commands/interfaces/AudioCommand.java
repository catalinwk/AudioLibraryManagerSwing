/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audioLibraryManager.commands.interfaces;
import audioLibraryManager.commands.*;
import audioLibraryManager.*;
import java.io.*;
/**
 * Implements methods used by an audio command
 * @author Catalin Mazilu
 */
public interface AudioCommand {
    
    /**
     * Gets the name of Audio Library command
     * @return name of audio library command
     */
    public String getName();
    
    /**
     * Runs the command
     */
    public void runCommand(ShellPath path, String args)
    throws CommandException
    ;
        
   
    
}
