/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class StatistikkGUI extends JPanel
{
     private JLabel fradato, tildato, fraAar, tilAar, velgLegemiddel;
     private JTextField fraAarfelt, tilAarfelt, velgaar1, velgaar2, legemiddelfelt;
     private String [] maned;
     private JButton knapp1, knapp2, knapp3;
     private JComboBox rullgardin1, rullgardin2;
     private JPanel panel1, panel2, panel3;
     private JTextArea temp;
    
    StatistikkGUI()
    {
         
        String maned[] = {"Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August",
                            "Septemeber", "Oktober", "November", "Desember"};
        rullgardin1 = new JComboBox();
        rullgardin2 = new JComboBox();
        fraAarfelt = new JTextField(4);
        tilAarfelt = new JTextField(4);
        fradato = new JLabel("Fra Måned");
        tildato = new JLabel("Til Måned");
        velgLegemiddel = new JLabel("Velg Legemiddel");
        legemiddelfelt = new JTextField(20); 
        fraAar = new JLabel("Velg år");
        tilAar = new JLabel("Velg år");
        temp = new JTextArea(20,50);
        
        int teller = 0;
        
        for (int i=0; i < maned.length; i++)
        {
            rullgardin1.addItem(maned[i]);
            
        }
          for (int i=0; i < maned.length; i++)
        {
            rullgardin2.addItem(maned[i]);
            
        }
          
        panel1 = new JPanel();
        panel1.add(velgLegemiddel);
        panel1.add(legemiddelfelt);
        
        
        panel2 = new JPanel();
        panel2.add(fradato);
        panel2.add(rullgardin1);
        panel2.add(fraAar);
        panel2.add(fraAarfelt);
        
        panel3 = new JPanel();
        panel3.add(tildato);
        panel3.add(rullgardin2);
        panel3.add(tilAar);
        panel3.add(tilAarfelt);
        
       GridBagConstraints gc = new GridBagConstraints();
       setLayout(new GridBagLayout());
       
       int x = 0;
       int y = 0;
       
       gc.gridx = x;
       gc.gridy = y;
       add(panel1, gc);       
          
       gc.gridx = x;
       gc.gridy = ++y;
       add(panel2, gc);
       
       gc.gridx = x;
       gc.gridy = ++y;
       add(panel3, gc);
       
       gc.gridx = x;
       gc.gridy = ++y;
       add(temp, gc);
       
       
       
       
      
       
       
        
    }

}
