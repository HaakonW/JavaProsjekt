/*
Filen inneholder klassen RegistrerPasient.
Laget av Henrik Fischer Bjelland, Haakon Winther
Sist endret 09-04-2014 
*/

package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.List;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;


public class RegistrerPasient extends JPanel implements ActionListener
{
    private PasientRegister pasientRegister;
    private String pasientliste = "pasientliste.txt";
    private JTextField fornavnfelt, etternavnfelt, fodselsdatofelt;
    private JLabel fornavnlabel, etternavnlabel, fodsellabel;
    private JButton regPasient, visListe;
    private JTextArea utskrift;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    
    public RegistrerPasient(PasientRegister pasientRegister)
    {
        this.pasientRegister = pasientRegister;
        fornavnfelt = new JTextField(20);
        etternavnfelt = new JTextField(20);
        fodselsdatofelt = new JTextField(20);
        fornavnlabel = new JLabel("Fornavn     ");
        etternavnlabel = new JLabel("Etternavn   ");
        fodsellabel = new JLabel("Fødselsdato");
        regPasient = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        utskrift = new JTextArea(20,20);        
        regPasient.addActionListener(this);
        visListe.addActionListener(this);
        
        //liste = new Medisinliste();
        
        //For å lese listen ved oppstart
        //lesObjektFraFil();
        
      
        ///PANEL START////
       panel1 = new JPanel();
       panel1.add(fornavnlabel);
       panel1.add(fornavnfelt);
       
       panel2 = new JPanel();
       panel2.add(etternavnlabel);
       panel2.add(etternavnfelt);
       
       panel3 = new JPanel();
       panel3.add(fodsellabel);
       panel3.add(fodselsdatofelt);
       
       panel4 = new JPanel();
       panel4.add(regPasient);
       panel4.add(visListe);
       
       panel5 = new JPanel();
       panel5.add(utskrift);
        
        
        /// GRID START ///
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
        
        utskrift.setEditable(false); 
    }//end of konstruktør
    
    private void nyPasient()
    {
        Pasient ny = new Pasient(fornavnfelt.getText(), etternavnfelt.getText(), 
                fodselsdatofelt.getText());
        pasientRegister.SettInn(ny);
        utskrift.setText("Registrert pasient: \n" + ny.toString());
    }
    
    private void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        fodselsdatofelt.setText("");
    }
    
    private void SkrivUt()
    {
        String pasientliste = "";
        List <Pasient> list = pasientRegister.FinnAlle();
        for (Pasient pasient : list)
        {
            pasientliste+= pasient.toString();
            pasientliste +="\n\n";
        }
        utskrift.setText(pasientliste);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == regPasient)
        {
            nyPasient();
            TomFelt();
        }
        if(e.getSource() == visListe)
        {
            SkrivUt();
        }
    }
}//end of class Registrer Pasient