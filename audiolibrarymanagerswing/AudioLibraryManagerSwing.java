/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audiolibrarymanagerswing;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
       
import  audiolibrarymanagerswing.model.*;

/**
 *
 * @author Catalin Mazliu
 */
public class AudioLibraryManagerSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyFrame f = new MyFrame("Audio Library Manager - Swing");
        f.setVisible(true);
    }
}



class MyFrame extends JFrame implements ActionListener {
    
    /**
     * Constructor Frame
     * @param title - String, name of the Windows
     */
    MyFrame(String title) {
        super(title);
        
        setLayout(new BorderLayout() );
        //setSize(1200, 800);
        
        //closing operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creating Left Panel
        JPanel leftPanel = new JPanel();
        
        
        
        //Creating Right Panel
        JPanel rightPanel = new JPanel();
        JLabel rightSideTitle = new JLabel("Info Area");
        rightPanel.add(rightSideTitle);
        //rightPanel.setSize(1200, 800);
        
        AudioTreeModel audioTreeModel = new AudioTreeModel("c:\\cantari\\mp3");
        
        JTree myAudioTree = new JTree(audioTreeModel.getTreeModel());
        leftPanel.add(myAudioTree);
        
        //Creating JSlipPanel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        getContentPane().add(splitPane,BorderLayout.CENTER);
        
        pack();
        
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
}