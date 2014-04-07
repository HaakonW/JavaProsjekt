/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 *
 * @author Bandet
 */

public class InfoMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    private	JPanel	panel1;
    private	JPanel	panel2;
    private	JPanel	panel3;
    
    public InfoMainGUI()
            {
                super(new GridLayout(1, 1));
                JTabbedPane tabbedPane = new JTabbedPane();
                ImageIcon icon = new ImageIcon(getClass().getResource("pille.png"));
                tabbedPane.addTab("Informasjon", icon, panel1, "Informasjon");
                tabbedPane.addTab("LegeInfo", icon, panel2, "Lege");
                tabbedPane.addTab("PasientInfo", icon, panel3, "Pasient");
                tabbedPane.addTab("Legemiddel", icon, panel3, "Legemiddel");
                 add(tabbedPane);
            }
     public static void createAndShowGUI()
  {
    //Create and set up the window.
    JFrame frame = new JFrame("Informasjon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,400);
    frame.getContentPane().add(new InfoMainGUI(), BorderLayout.CENTER);

    //Display the window.
   
    frame.setVisible(true);
  }

  /*public static void main(String[] args)
  {
    createAndShowGUI();
  }*/
    
}