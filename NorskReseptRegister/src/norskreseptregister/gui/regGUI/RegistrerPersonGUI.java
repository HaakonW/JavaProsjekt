/*
Filen inneholder klassen RegistrerPersonGUI.
Laget av  Henrik Fischer Bjelland
Sist endret 17-04-2014  
*/

package norskreseptregister.gui.regGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class RegistrerPersonGUI extends JPanel
{
    protected JButton reg, vis; 
    protected JTextField fornavnfelt, etternavnfelt, infofelt;
    protected JTextArea utskrift;
    private JLabel fornavnlabel, etternavnlabel, infolabel; 
    private JPanel panel1, panel2, panel3, panel4, panel5;
    
    public RegistrerPersonGUI(String infolabeltekst)
    {
        fornavnlabel = new JLabel("Fornavn     ");
        etternavnlabel = new JLabel("Etternavn   ");
        infolabel = new JLabel(infolabeltekst);
        fornavnfelt = new JTextField(20);
        etternavnfelt = new JTextField(20);
        infofelt = new JTextField(20);
        reg = new JButton("Registrer");
        vis = new JButton("Vis");
        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);

        /////PANEL START////
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(fornavnfelt);
        
        panel2 = new JPanel();
        panel2.add(etternavnlabel);
        panel2.add(etternavnfelt);
        
        panel3 = new JPanel();
        panel3.add(infolabel);
        panel3.add(infofelt);
        
        panel4 = new JPanel();
        panel4.add(reg);
        panel4.add(vis);
        
        panel5 = new JPanel();
        panel5.add(utskrift);
        
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
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(panel3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);
        
        gc.gridx = 2;
        gc.gridy = 0; 
        gc.gridheight = 6;
        add(panel5, gc);      
    }//end of konstruktør RegistrerLege

    public void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        infofelt.setText("");
    } 
}//end of class RegistrerLege
