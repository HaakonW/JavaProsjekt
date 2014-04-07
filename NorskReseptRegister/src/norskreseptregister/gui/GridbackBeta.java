/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

import javax.swing.*;
import java.awt.*;
import norskreseptregister.RegisterSystem;

/**
 *
 * @author Haakon
 */
public class GridbackBeta extends JFrame
{
    public GridbackBeta()
    {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setVisible(true);
        setSize(400,400);
        //setBorder(BorderFactory.createTiltedBorder("Legedetaljer"));
        
        /*JLabel nameLabel = new JLabel("Navn: ");
        JLabel stilling = new JLabel("Stilling: ");
        
        JTextField nameField = new JTextField(10);
        JTextField yrke = new JTextField(10);*/
        
        JButton en = new JButton("BOX 1");
        JButton to = new JButton("BOX 2");
        JButton tre = new JButton("BOX 3");
        JButton fire = new JButton("BOX 4");
        JButton fem = new JButton("BOX 5");
        JButton yolo = new JButton("hvor havner du?");// Du havnet bak box4
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //// Første kollonne
        //gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        
        gc.gridx = 0;
        gc.gridy = 0;           
        add(en, gc);
         
        gc.gridx = 0;
        gc.gridy = 1;
        add(tre, gc);
        
        ///// ANdre kollonne
        //gc.anchor = GridBagConstraints.LINE_START;   
        gc.gridx = 1;
        gc.gridy = 0;
        add(to, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(fire, gc);
        add(yolo, gc);
        
        /* FINAL ROW
       // gc.weighty = 10;
        //gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(fem, gc);*/


    }
        public static void main(String args[])
    {
        new GridbackBeta();
    }
}
