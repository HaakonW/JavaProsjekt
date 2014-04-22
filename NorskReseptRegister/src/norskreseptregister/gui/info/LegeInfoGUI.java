/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland
 Sist endret 11-04-2014 
 */
package norskreseptregister.gui.info;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgPersonGUI;

public class LegeInfoGUI extends JPanel implements ActionListener
{

    private JTextField legedatafelt;
    private JTextArea utskrift;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JLabel fornavnlabel, etternavnlabel;
    private JButton knapp1, knapp2, knapp3, velgLege;
    private JCheckBox a, b, c;
    private Lege lege;
    private RegisterSystem system;

    public LegeInfoGUI(RegisterSystem system)
    {
        this.system = system;
        fornavnlabel = new JLabel("Fornavn   ");
        legedatafelt = new JTextField(20);
        knapp1 = new JButton("Vis alle leger");
        knapp2 = new JButton("Vis alle resepeter på lege");
        knapp3 = new JButton("Vis resepter i kategori");
        velgLege = new JButton("...");
        
        utskrift = new JTextArea(20,20);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        
        a = new JCheckBox("A");
        b = new JCheckBox("B");
        c = new JCheckBox("C");
        
        velgLege.addActionListener(this);
        knapp2.addActionListener(this);
        
        ///PANELS START ////
        
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(legedatafelt);
        panel1.add(velgLege);
       
       
       panel3 = new JPanel();
       panel3.add(knapp1);
       panel3.add(knapp2);
       
       panel4 = new JPanel();
       panel4.add(a);
       panel4.add(b);
       panel4.add(c);
       panel4.add(knapp3);
       
       panel5 = new JPanel();
       panel5.add(utskrift);

       ///GRID START ////
       GridBagConstraints gc = new GridBagConstraints();
       setLayout(new GridBagLayout());
       gc.gridx = 0;
       gc.gridy = 0;
       gc.insets = new Insets(10, 5, 5, 10);
       gc.anchor = GridBagConstraints.WEST;
       gc.fill = GridBagConstraints.HORIZONTAL;
       add(panel1, gc);
       
     
       /*gc.gridx = 0;
       gc.gridy = 1;
       add(panel2, gc);*/
       
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = 0;
        gc.anchor = GridBagConstraints.EAST;
        add(panel3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel5, gc);

        utskrift.setEditable(false); 
    }
    
    public void VelgLege()
    {
        // #info: Gjort dialogen slik at den kan brukes til å velge mange forskjellige ting
        LegeRegister legeRegister = system.getLegeRegister();
        DefaultListModel model = new DefaultListModel();
        for (Lege l : legeRegister.FinnAlle())
        {
            model.addElement(l.toString());
        }

        VelgPersonGUI velgLege = new VelgPersonGUI(model);
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            lege = legeRegister.HentEttElement(valgtIndex);
            legedatafelt.setText(lege.getNavn());
        }
    }
    
    public void visResepterForLege()
    {
        if ( lege != null)
        {
            FinnResepterForLege query = new FinnResepterForLege(lege);
            ArrayList <Resept> reseptene = system.getReseptRegister().Finn(query);
            String alleResepterForLege ="";
            for (Resept r : reseptene)
            {
                alleResepterForLege += r.toString();
            }
            utskrift.setText("Fant følgende resepter for :\n"
                    + lege.getNavn() + "\n" + alleResepterForLege);
        }
        else
        {
            utskrift.setText("Du må velge en lege for å skrive ut");  
        }

    }
    

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        else if (e.getSource() == knapp2)
        {
            visResepterForLege();
        }
    }
    
    
}//end of class LegeInfoGUI
