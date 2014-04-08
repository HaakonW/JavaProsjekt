/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//usikker på om vi bare kan importere swing.*; ????

/**
 *
 * @author Bandet
 */
public class LegeLisensGUI extends JPanel
{
   private JLabel fornavnlabel, etternavnlabel;
   private JTextField fornavnfelt, etternavnfelt;
   private JButton visLege, endre;
   private JTextArea utskrift;
   private JCheckBox a, b, c;
   
   public LegeLisensGUI()
   {
       fornavnfelt = new JTextField(20);
       etternavnfelt = new JTextField(20);
       visLege = new JButton("Vis lege");
       endre = new JButton("Endre bevilling");
       fornavnlabel = new JLabel("Fornavn:");
       etternavnlabel = new JLabel("Etternavn:");
       utskrift = new JTextArea(20,35);
       a = new JCheckBox("A");
       b = new JCheckBox("B");
       c = new JCheckBox("C");
       
       add(fornavnlabel);
       add(fornavnfelt);
       add(etternavnlabel);
       add(etternavnfelt);
       add(visLege);
       add(a);
       add(b);
       add(c);
       add(utskrift);
       add(endre);
       
   }
}
