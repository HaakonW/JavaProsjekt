/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland
 Sist endret 11-04-2014 
 */
package norskreseptregister.gui.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
    private JLabel fornavnlabel;
    private JButton visAlleLeger, visAlleResepterPaaLege, visResepteriGruppe, velgLege, hjelp;
    private JCheckBox a, b, c;
    private Lege lege;
    private RegisterSystem system;
    private LegeRegister legeRegister;

    public LegeInfoGUI(RegisterSystem system, LegeRegister legeRegister)
    {
        this.system = system;
        this.legeRegister = legeRegister;
        fornavnlabel = new JLabel("Legenavn   ");
        legedatafelt = new JTextField(20);
        visAlleLeger = new JButton("Vis alle leger i registeret");
        legedatafelt.setText("Velg lege ved å på knappen til høyre");
        visAlleResepterPaaLege = new JButton("Vis resepter legen har skrevet ut");
        visResepteriGruppe = new JButton("Vis resepter i gruppe");
        hjelp = new JButton("?");
        velgLege = new JButton("...");
        
        utskrift = new JTextArea(20,20);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        
        a = new JCheckBox("A");
        b = new JCheckBox("B");
        c = new JCheckBox("C");
        
        velgLege.addActionListener(this);
        visAlleLeger.addActionListener(this);
        visAlleResepterPaaLege.addActionListener(this);
        hjelp.addActionListener(this);
        
        velgLege.setPreferredSize(new Dimension(20, 20));
        legedatafelt.setEditable(false);
        hjelp.setPreferredSize(new Dimension(20, 20));
        
        ///PANELS START ////
        
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(legedatafelt);
        panel1.add(velgLege);
       
       
       panel3 = new JPanel();
       panel3.add(visAlleLeger);
       panel3.add(visAlleResepterPaaLege);
       
       panel4 = new JPanel();
       panel4.add(a);
       panel4.add(b);
       panel4.add(c);
       panel4.add(visResepteriGruppe);
       
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
        
       gc.gridx = 2;
       gc.gridy = 6;
       add(hjelp, gc);

        utskrift.setEditable(false); 
    }//end of Konstruktør
    
    public void VelgLege()
    {
        LegeRegister legeRegister = system.getLegeRegister();
        DefaultListModel model = new DefaultListModel();
        for (Lege l : legeRegister.FinnAlleObjekter())
        {
            model.addElement(l.toString());
        }

        VelgPersonGUI velgLege = new VelgPersonGUI(model);
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            lege = legeRegister.HentEttObjekt(valgtIndex);
            legedatafelt.setText(lege.getNavn());
        }
    }
    
    private void visAlleLeger()
    {
        String legeliste = "";
        List <Lege> list = system.getLegeRegister().FinnAlleObjekter();
        for (Lege lege : list)
        {
            legeliste+= lege.toString();
            legeliste +="\n\n";
        }
        utskrift.setText(legeliste);
    }
        
    public void visResepterForLege()
    {
        if ( lege != null)
        {
            FinnResepterForLege query = new FinnResepterForLege(lege);
            ArrayList <Resept> reseptene = system.getReseptRegister().FinnObjekterSomMatcher(query);
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
        else if (e.getSource() == visAlleLeger)
        {
            visAlleLeger();
        }
        else if (e.getSource() == visAlleResepterPaaLege)
        {
            visResepterForLege();
        }
        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP LEGEINFO");
        }
    }
    
}//end of class LegeInfoGUI
