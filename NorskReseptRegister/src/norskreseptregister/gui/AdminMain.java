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

public class AdminMain extends JPanel
{
    private JTabbedPane tabbedPane;
    private JPanel panel1, panel2;
    private JLabel hei;
    private JButton endreLisens, medisin;
    LegeLisensGUI panel3 = new LegeLisensGUI();
    MedisinGUI panel4 = new MedisinGUI();    
    
    public AdminMain()
    {
        
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("bilder/Admin.jpg"));
        tabbedPane.addTab("Hjem", icon, panel1, "Hjem");
        tabbedPane.addTab("Endre Lisens for lege", icon, panel3, "Lege");
        tabbedPane.addTab("Registrer medisin", icon, panel4, "Registrer Medisin");
        add(tabbedPane);
        hei = new JLabel("Dette er for admin. ");
        endreLisens = new JButton("Endre Lisens");
        medisin = new JButton("Registrer Medisin");
        
        ////PANELS START////
        panel1 = new JPanel();
        panel1.add(hei);
        
        panel2 = new JPanel();
        panel2.add(endreLisens);
        panel2.add(medisin);
        
        //// GRID START ////
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(panel2, gc);
        
    }
    
  private static void createAndShowGUI()
  {
    //Create and set up the window.
    JFrame frame = new JFrame("Admin");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,200);
    frame.getContentPane().add(new AdminMain(), BorderLayout.CENTER);

    //Display the window.
   
    frame.setVisible(true);
    frame.pack(); // Litt kranglete med størrelsen
  }

  public static void main(String[] args)
  {
    createAndShowGUI();
  }
    
}