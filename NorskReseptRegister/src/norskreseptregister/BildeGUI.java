/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

class BildeGUI extends JFrame
{   
    private JLabel label1, label2;
    private JButton regMain, infoMain, adminMain;
    //JTabbedPane temp = new JTabbedPane();
    //InfoMainGUI f1 = new InfoMainGUI();
    JFrame frame = new JFrame();
    
    public BildeGUI()
    {
        setTitle("Icon image");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Icon pille = new ImageIcon( getClass().getResource("pille.png" ) );
        //label2 = new JLabel(pille, SwingConstants.RIGHT );
        //add( label2 ); // add label2 to JFrame
        setSize(800,500);
        setVisible(true);
                        

    
        /*
        gc.add(infoMain = new JButton("Info"));
        gc.add(adminMain = new JButton("Admin"));   */    
    }
   
    /*public static void main(String args[])
    {
        new BildeGUI();
    }*/
    
        
        
    }

