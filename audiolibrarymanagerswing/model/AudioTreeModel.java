/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audiolibrarymanagerswing.model;
import javax.swing.tree.*;

import java.io.*;

/**
 * This class creates a model for Audio Files JTree
 * @author Catalin Mazilu
 */
public class AudioTreeModel {
    public DefaultMutableTreeNode root;
    public String path;
    /**
     * Constructor - creates a tree from starting path
     * @param path - string given path
     */
    public AudioTreeModel (String path){
        root = new DefaultMutableTreeNode("root", true);
        this.path = path;
        
        //adding favorites list
        root.add(new DefaultMutableTreeNode("FAVORITES"));
       
        
        
        getFileList(root,new File(path));
    }
    
    /**
     * returns the data for the JTree
     * @return - DefaultMutableTreeNode, JTree Model
     */
   public  DefaultMutableTreeNode getTreeModel(){
        
        return root;
        
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
  
    
    
}
