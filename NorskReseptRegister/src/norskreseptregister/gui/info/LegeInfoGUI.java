/*
Filen inneholder klassen LegeInfoGUI
Laget av Henrik Fischer Bjelland
Sist endret 11-04-2014 
*/

package norskreseptregister.gui.info;

import javax.swing.JPanel;
import javax.swing.*;

public class LegeInfoGUI extends JPanel
{
    private JTextField fornavnfelt, etternavnfelt;
    private JTextArea utskrift;
    private JLabel fornavnlabel, etternavnlabel;
    private JButton knapp1, knapp2, knapp3;
    private JRadioButton a, b, c;
    
    public LegeInfoGUI()
    {
        fornavnlabel = new JLabel("Fornavn   ");
        etternavnlabel = new JLabel("Etternavn ");
        etternavnfelt = new JTextField(20);
        fornavnfelt = new JTextField(20);
        knapp1 = new JButton("Vis alle leger");
        knapp2 = new JButton("Vis alle resepeter på lege");
        knapp3 = new JButton("Vis resepter i kategori");
        a = new JRadioButton("A");
        b = new JRadioButton("B");
        c = new JRadioButton("C");
  
    } 
}//end of class LegeInfoGUI
