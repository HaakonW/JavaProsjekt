/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */


/**
 *
 * @author Haakon
 */
package norskreseptregister.gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;



public class GuiBeta extends JFrame 
{
    private JTextField p_fornavn, p_etternavn, p_dato, l_fornavn, l_etternavn, l_dato;
    private JButton regPasient, sjekkPasient, regLege, sjekkLege;
    private JTextArea u_pasient, u_lege; //Utskriftområde
    private JCheckBox a, b, c; //Bevilligninger
    private JRadioButton bevilgning, bevilgningFalse;
    
    
    public GuiBeta()
    {
         super("GUI BETA"); 
         setSize(1100,400);
         JTabbedPane fane = new JTabbedPane();
         setVisible(true);
         setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
         //checkboxlytter = new Typelytter();
         a = new JCheckBox("A");
         Knappelytter handler = new Knappelytter();
         a.addActionListener (handler);
         b = new JCheckBox("B");
         b.addActionListener (handler);
         c = new JCheckBox("C");
         c.addActionListener (handler);
         
         bevilgning = new JRadioButton();
         bevilgning.setText("Har bevilgning");
         bevilgningFalse = new JRadioButton();
         bevilgningFalse.setText("har IKKE bevilgning");
         p_fornavn = new JTextField(15);
         p_etternavn = new JTextField(15);
         p_dato = new JTextField(10);
         l_fornavn = new JTextField(15);
         l_etternavn = new JTextField(15);
         l_dato = new JTextField (15);     
         
         
         getContentPane().add(fane);
         
         JPanel fane1 = new JPanel();
         JPanel fane2 = new JPanel();
         JPanel fane3 = new JPanel();
         JPanel fane4 = new JPanel();
         JPanel fane5 = new JPanel();
         JPanel fane6 = new JPanel();
         JPanel fane7 = new JPanel();
         JPanel fane8 = new JPanel();


         JLabel hjem = new JLabel();
         fane.addTab("Hjem", fane1);
         
         
         JLabel label2 = new JLabel();
         fane.addTab("Registrer Pasient", fane2);
         fane2.setLayout(new FlowLayout());
         fane2.add(regPasient = new JButton ("Registrer pasient"));  
         fane2.add(sjekkPasient = new JButton ("Sjekk pasient"));        
         fane2.add(new JLabel("Etternavn: "));               
         fane2.add(p_etternavn);
         fane2.add(new JLabel("Fornavn: "));
         fane2.add(p_fornavn); 
         fane2.add(new JLabel("Dato: "));
         fane2.add(p_dato);
         fane2.add(u_pasient = new JTextArea(15, 40));
         this.u_pasient = u_pasient;      
         
         JLabel label1 = new JLabel();
         fane.addTab("Registrer Lege", fane3);
         fane3.setLayout(new FlowLayout());
         fane3.add(regPasient = new JButton ("Registrer lege"));  
         fane3.add(sjekkPasient = new JButton ("Sjekk lege"));        
         fane3.add(new JLabel("Etternavn: "));               
         fane3.add(l_etternavn);
         fane3.add(new JLabel("Fornavn: "));
         fane3.add(l_fornavn); 
         fane3.add(new JLabel("Dato: "));
         fane3.add(l_dato);
         fane3.add(u_lege = new JTextArea(15, 40));
         u_lege.setEditable(false);
 
         fane3.add(a);
         fane3.add(b);
         fane3.add(c);
         fane3.add(bevilgning);
         fane3.add(bevilgningFalse);
         this.u_lege = u_lege;
         
         fane3.add(a);
         fane3.add(b);
         fane3.add(c);
         fane3.add(bevilgning);
         fane3.add(bevilgningFalse);
         this.u_lege = u_lege;
         
         JLabel label3 = new JLabel();
          fane.addTab("Registrer lege", fane3);
         fane3.add(label3);
         
         JLabel label4 = new JLabel();
         fane.addTab("Sjekk pasient", fane4);
         label4.setText("HER KAN DET STÅ TEKST");
         fane4.add(label4);
         
         JLabel label5 = new JLabel();
         fane.addTab("sjekkpasient", fane5);
         label5.setText("HER KAN DET STÅ TEKST");
         fane5.add(label5);
         
         JLabel label6 = new JLabel();
         label6.setText("HER KAN DET STÅ TEKST");
         fane6.add(label6);
         
         JLabel label7 = new JLabel();
         label7.setText("HER KAN DET STÅ TEKST");
         fane7.add(label7);
         
         JLabel label8 = new JLabel();
         label8.setText("HER KAN DET STÅ TEKST");
         fane8.add(label8);
         
         /*fane.addTab("--", fane6);
         fane.addTab("--", fane7);
         fane.addTab("--", fane8);*/
         
         
        
    }
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            String text = "Legen kan skrive ut medikamenter i klasse: ";
           if (e.getSource() ==  a)
           {
                text += "A"; 
                u_lege.setText(text);
            } 
           else if (e.getSource() == b)
           {
                 text += " ,B";
                 u_lege.setText(text);
           }
           else if (e.getSource() == c)
            {
                text += ", C";
                u_lege.setText(text);
            }
        }
        
    }

   
}
