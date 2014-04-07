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
import norskreseptregister.RegisterSystem;

/**
 *
 * @author Haakon
 */
public class MainGui extends JFrame
{
    JButton info, registrer, admin;
    public MainGui()
    {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBorder(BorderFactory.createTiltedBorder("Legedetaljer"));
        
        /*JLabel nameLabel = new JLabel("Navn: ");
        JLabel stilling = new JLabel("Stilling: ");
        
        JTextField nameField = new JTextField(10);
        JTextField yrke = new JTextField(10);*/
        
        info = new JButton("Info");
        registrer = new JButton("Register");
        admin = new JButton("Admin");
                
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //// Første kollonne
        //gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5; 
        gc.anchor = GridBagConstraints.FIRST_LINE_START; 
        gc.gridx = 0;
        gc.gridy = 0;           
        add(info, gc);
        
        ///// ANdre kollonne
        gc.anchor = GridBagConstraints.EAST;
         
        gc.gridx = 1;
        gc.gridy = 0;
        add(admin, gc);
        
        //Tredje Kolonnne
        gc.anchor = GridBagConstraints.SOUTH;
        gc.gridx = 1;
        gc.gridy = 1;
        add(registrer, gc);
        
        
        //Første Rad 
        gc.gridx = 0;
        gc.gridy = 1;
        
        
        
        
        /* FINAL ROW
       // gc.weighty = 10;
        //gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(fem, gc);*/


    }
     private class Knappelytter implements ActionListener
    {
        
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
        }
        
    }//end of class Knappelytter
  
       
}
