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
    JButton info;
    JButton registrer;
    JButton admin;
    
    public MainGui()
    {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Klarte ikke "hurtigveien"
        ImageIcon bilde = new ImageIcon("src/norskreseptregister/gui/bilder/pille.png");
        ImageIcon footer = new ImageIcon ("src/norskreseptregister/gui/bilder/footer.png");
        JLabel footerlabel = new JLabel(footer);
        JLabel pillelabel = new JLabel (bilde);
 
        
        info = new JButton("Info");
        registrer = new JButton("Register");
        admin = new JButton("Admin");
                
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //// Første kollonne
        //gc.anchor = GridBagConstraints.LINE_END;
       
        gc.gridx = 0;
        gc.gridy = 0;           
        add(info, gc);      
           
         
        gc.gridx = 1;
        gc.gridy = 0;
        add(admin, gc);
        
       
        gc.gridx = 2;
        gc.gridy = 0;
        add(registrer, gc);
        
        gc.gridx = 0;
        gc.gridy = 1; 
        
        
        
        gc.gridx = 1;
        gc.gridy = 2; 
        add(pillelabel, gc);
        
        
      
        
        
        
        
        // FINAL ROW
      
          
        gc.gridx = 1;
        gc.gridy = 3;
        add(footerlabel, gc);


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
