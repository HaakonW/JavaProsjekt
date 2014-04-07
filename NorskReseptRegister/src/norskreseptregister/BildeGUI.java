/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

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
    InfoMainGUI f1 = new InfoMainGUI();
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
                        

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //Første kolonne 0.0
        gc.gridx = 0;
        gc.gridy = 0;
        //add(label2, gc);
        
        //Andre kolonne 0.1
        infoMain = new JButton("Info");
        gc.gridx = 0;
        gc.gridy = 1;
        add(infoMain, gc);
        
        //Tredeje Kolonne 0.2
        adminMain = new JButton("Admin");
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weighty = 5;
        gc.gridx = 0;
        gc.gridy = 2;
        add(adminMain, gc);    
        
        
        //Last Row
        
        regMain = new JButton("Registrer ");
        //gc.weighty = 10;
        //gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 1;
                
        add(regMain, gc);
        /*
        gc.add(infoMain = new JButton("Info"));
        gc.add(adminMain = new JButton("Admin"));   */    
    }
   
    public static void main(String args[])
    {
        new BildeGUI();
    }
    
        private class Knappelytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
           if (e.getSource() ==  regMain)
           {
               
           } 
           else if (e.getSource() == infoMain)
           {

           }
           else if (e.getSource() == adminMain)
            {

            }
        }
        
    }
}
