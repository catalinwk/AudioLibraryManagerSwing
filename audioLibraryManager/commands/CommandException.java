/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audioLibraryManager.commands;

/**
 * Used for catching audio commands exceptions
 * @author Catalin Mazilu
 */
public class CommandException extends Exception
{
    public CommandException (String message){
        super(message);
    }
}
