/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audiolibrarymanagerswing.model;
import javax.swing.tree.*;
import audioLibraryManager.commands.*;


import java.io.*;

/**
 * This class creates a model for Audio Files JTree
 * @author Catalin Mazilu
 */
public class AudioTreeModel {
    public DefaultMutableTreeNode root;
    public String path;
    
    /**
     * default favorite file
     */
    public String favoritePath = "favorite.txt";
    /**
     * default favorite node
     */
    DefaultMutableTreeNode favorites;
    
    /**
     * Constructor - creates a tree from starting path
     * @param path - string given path
     */
    public AudioTreeModel (String path) throws CommandException {
        root = new DefaultMutableTreeNode("root", true);
        this.path = path;
        
        //adding favorites list
        favorites = new DefaultMutableTreeNode("FAVORITES");
       
        loadFavorites(favoritePath,favorites);
        root.add(favorites);
        
        getFileList(root,new File(path));
    }
    
    /**
     * returns the data for the JTree
     * @return - DefaultMutableTreeNode, JTree Model
     */
   public  DefaultMutableTreeNode getTreeModel(){
        
        return root;
        
    }
   
   public void addFavoriteModel(String favname){
       DefaultMutableTreeNode child = new DefaultMutableTreeNode(favname);
       favorites.add(child);
               
   }
    
    public  void getFileList(DefaultMutableTreeNode node, File f) {
     if(!f.isDirectory()) {
         // We keep only JAVA source file for display in this HowTo
         if (f.getName().endsWith(".mp3")) {
            //System.out.println("FILE  -  " + f.getName());
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
            node.add(child);
            }
         }
     else {
        // System.out.println("DIRECTORY  -  " + f.getName());
         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
         node.add(child);
         File fList[] = f.listFiles();
         for(int i = 0; i  < fList.length; i++)
             getFileList(child, fList[i]);
         }
    }
  
    /**
     * Loads the favorites from default file located in current working directory
     * @param f filename of favorites
     */
    public void loadFavorites(String filePath, DefaultMutableTreeNode node) throws CommandException {
        
        File f = new File(new File(filePath).getAbsolutePath());
    
            if (f.exists()) {
                /*
                 * add the file to favorite file
                 */
                
                try (BufferedReader favfile = new BufferedReader(new FileReader(filePath))) {
                   
                    while (favfile.ready())
                    {
                        String file_name =  favfile.readLine();
                        DefaultMutableTreeNode child = new DefaultMutableTreeNode(file_name);
                        node.add(child);  
                    }
                    
                    
                   
                } catch (IOException e){
                    //System.out.println(e.getMessage());
                    throw(new CommandException(e.getMessage()));
                }
                
            } else {

                throw(new CommandException("Incorect path"));

            }
        
        
    }
    
    
}
