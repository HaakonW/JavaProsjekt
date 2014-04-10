/*
 * Filen inneholder klassen RegistrerLege.
 * Laget av  Henrik 
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.RegisterSystem;
import java.util.List;

public class RegistrerLege extends JPanel implements ActionListener
{
    private JButton regLege, visLege;
    private JTextField fornavnfelt, etternavnfelt, adressefelt;
    private JLabel fornavnlabel, etternavnlabel, adresselabel; 
    private JTextArea legeutskrift;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private LegeRegister legeRegister;
    
    public RegistrerLege(LegeRegister legeRegister)
    {
        this.legeRegister = legeRegister;
        fornavnlabel = new JLabel("Fornavn   ");
        etternavnlabel = new JLabel("Etternavn ");
        adresselabel = new JLabel("Adresse   ");
        etternavnfelt = new JTextField(20);
        fornavnfelt = new JTextField(20);
        adressefelt = new JTextField(20);
        regLege = new JButton("Registrer Lege");
        visLege = new JButton("Vis Lege");
        legeutskrift = new JTextArea(20, 20);
        legeutskrift.setEditable(false);
        regLege.addActionListener(this);
        visLege.addActionListener(this);
        

        /////PANEL START////
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(fornavnfelt);
        
        panel2 = new JPanel();
        panel2.add(etternavnlabel);
        panel2.add(etternavnfelt);
        
        panel3 = new JPanel();
        panel3.add(adresselabel);
        panel3.add(adressefelt);
        
        panel4 = new JPanel();
        panel4.add(regLege);
        panel4.add(visLege);
        
        panel5 = new JPanel();
        panel5.add(legeutskrift);
        
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
        gc.anchor = GridBagConstraints.WEST;
        add(panel3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);
        
        gc.gridx = 2;
        gc.gridy = 0; 
        gc.gridheight = 6;
        add(panel5, gc);
       
    }//end of konstruktør RegistrerLege

    private void nyLege()
    {
        Lege ny = new Lege(fornavnfelt.getText(), etternavnfelt.getText(), 
                adressefelt.getText());
        legeRegister.SettInn(ny);
        legeutskrift.setText("Registrert Lege: \n" + ny.toString());
    }

    public void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        adressefelt.setText("");
    }

    private void SkrivUt()
    {
        String legeliste = "";
        List <Lege> list = legeRegister.FinnAlle();
        for (Lege lege : list)
        {
            legeliste+= lege.toString();
            legeliste +="\n\n";
        }
        legeutskrift.setText(legeliste);
    }
        
    public void actionPerformed( ActionEvent e )
    {
       if (e.getSource() ==  regLege)
       {
            nyLege();
            TomFelt();
        } 
       else if (e.getSource() == visLege)
       {
            SkrivUt();
       }
    }
    
}//end of class RegistrerLege