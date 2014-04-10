/*
MAINGUI gjort om til å extende JPANEL isteden for JFrame
 */

package norskreseptregister.gui;

/**
 *
 * @author PeterWilhelmsen
 */
 /*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import norskreseptregister.Reg.RegisterSystem;
import java.awt.image.*;
import javax.imageio.*;



public class hovedVinduGUI extends JPanel
{
    JButton info;
    JButton registrer;
    JButton admin;
    JButton rad, rad1, rad2, rad3, rad4, rad5, rad6, rad7, rad8, rad9, rad10, rad11, rad12, rad13, rad14;
    JButton k, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14;
    JLabel header;
    
    public hovedVinduGUI()
    {
        /*Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);*/
        //setVisible(true);
        //setSize(900,500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        ImageIcon bilde = new ImageIcon("src/norskreseptregister/gui/bilder/pille.png");
        ImageIcon footer = new ImageIcon ("src/norskreseptregister/gui/bilder/footer.png");
        JLabel header = new JLabel("Velkommen til Norsk Reseptregister. Dette er hovedmenyen. Herfra kan du navigere videre.");

        JLabel footerlabel = new JLabel(footer);
        JLabel pillelabel = new JLabel (bilde);
 
        
        info = new JButton("Info");
        registrer = new JButton("Register");
        admin = new JButton("Admin");
        rad = new JButton("0.0");
        rad1 = new JButton("1");
        rad2 = new JButton("2");
        rad3 = new JButton("3");
        rad4 = new JButton("4");
        rad5 = new JButton("5");
        rad6 = new JButton("6");
        rad7 = new JButton("7");
        rad8 = new JButton("8");
        rad9 = new JButton("9");
        rad10 = new JButton("10");
        rad11 = new JButton("11");
        rad12 = new JButton("12");
     
        
       
        k1 = new JButton("1");
        k2 = new JButton("2");
        k3 = new JButton("3");
        k4 = new JButton("4");
        k5 = new JButton("5");
        k6 = new JButton("6");
        k7 = new JButton("7");
        k8 = new JButton("8");
        k9 = new JButton("9");
        k10 = new JButton("10");
        k11 = new JButton("11");
        k12 = new JButton("12");
        k13 = new JButton("13");
        k14 = new JButton("14");
        
        
                
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
 
        
       ///// BUTTON START //// 
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 5;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(35, 5, 5, 35);        
        add(info, gc);      
           
         
        gc.gridx = 0;
        gc.gridy = 1;
        //gc.gridwidth = 6;
        //gc.fill = GridBagConstraints.HORIZONTAL;
        add(registrer, gc);
        
       
        gc.gridx = 0;
        gc.gridy = 2;
        add(admin, gc);
        
        ////// BUTTON SLUTT /////
        
        /// START LOGO //////
        
        gc.gridx = 5;
        gc.gridy = 0; 
        gc.gridheight = 4;/*
        gc.gridwidth = 4;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;*/
        add(pillelabel, gc);
        
        
        ///// SLUTT LOGO ///////
    
        
        
   } 
}
        
        // FINAL ROW
    /*
        gc.gridx = 1;
        gc.gridy = 3;
        add(footerlabel, gc);*/


   
    /* private class Knappelytter implements ActionListener
    {
        // HVA MÅ KALLES PÅ HER FOR Å FÅ OPP DE ANDRE PROGRAMMENE? ///
        public void actionPerformed( ActionEvent e )
        {
           if (e.getSource() ==  info)
           {
               InfoMainGUI vindu = new InfoMainGUI();
            } 
           else if (e.getSource() == registrer)
           {
              //KAller på Registrer vinduet   
           }
           else if (e.getSource() == admin)
           {
               //Kaller på admin vinduet
           }
        }*/
        
    //}//end of class Knappelytter
  
       


