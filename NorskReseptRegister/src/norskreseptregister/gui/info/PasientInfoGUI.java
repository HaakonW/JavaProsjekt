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
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgPasientGUI;
import norskreseptregister.gui.regGUI.VelgPersonGUI;

public class PasientInfoGUI extends JPanel implements ActionListener
{

    private JTextField pasientdatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JLabel pasientlabel;
    private JButton visAllePasienter, visResepteriGruppe, velgPasient, hjelp;
    private JCheckBox a, b, c;
    private RegisterSystem system;
    private PasientRegister pasientRegister;
    private Pasient pasient;

    public PasientInfoGUI(RegisterSystem system, PasientRegister pasientRegister)
    {
        this.system = system;
        this.pasientRegister = pasientRegister;
        pasientlabel = new JLabel("Pasient   ");
        pasientdatafelt = new JTextField(20);
        pasientdatafelt.setText("Velg pasient med knappen til høyre");
        visAllePasienter = new JButton("Vis alle pasienter");

        visResepteriGruppe = new JButton("Vis resepter");
        hjelp = new JButton("?");
        velgPasient = new JButton("...");
        
        utskrift = new JTextArea(20,20);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        utskriftscroll = new JScrollPane(utskrift);
        
        a = new JCheckBox("A", true);
        b = new JCheckBox("B", true);
        c = new JCheckBox("C", true);
        
        velgPasient.addActionListener(this);
        visAllePasienter.addActionListener(this);
        
        hjelp.addActionListener(this);
        
        velgPasient.setPreferredSize(new Dimension(20, 20));
        hjelp.setPreferredSize(new Dimension(20, 20));
        pasientdatafelt.setEditable(false);
        
        ///PANELS START ////
        
        panel1 = new JPanel();
        panel1.add(pasientlabel);
        panel1.add(pasientdatafelt);
        panel1.add(velgPasient);
       
       
       panel3 = new JPanel();
       panel3.add(visAllePasienter);
       
       
       panel4 = new JPanel();
       panel4.setBorder(BorderFactory.createEtchedBorder());
       panel4.add(a);
       panel4.add(b);
       panel4.add(c);
       panel4.add(visResepteriGruppe);
       
       panel5 = new JPanel();
       panel5.add(utskriftscroll);

       ///GRID START ////
       GridBagConstraints gc = new GridBagConstraints();
       setLayout(new GridBagLayout());
       gc.gridx = 0;
       gc.gridy = 0;
       gc.insets = new Insets(5, 10, 5, 10);       
       add(panel1, gc);
       
       gc.gridx = 0;
       gc.gridy = 1;  
       gc.fill = GridBagConstraints.HORIZONTAL;
       add(panel4, gc);
       
       gc.gridx = 0;
       gc.gridy = 2;       
       add(panel3, gc);      
       
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel5, gc);
        
        gc.gridx = 2;
        gc.gridy = 6;
        add(hjelp, gc);

        utskrift.setEditable(false); 
    }//end of Konstruktør
    
    private void VelgPasient()
    {
        // #info: Gjort dialogen slik at den kan brukes til å velge mange forskjellige ting
        PasientRegister pasientRegister = system.getPasientRegister();
        DefaultListModel model = new DefaultListModel();
        for (Pasient p : pasientRegister.FinnAlleObjekter())
        {
            model.addElement(p.toString());
        }

        VelgPersonGUI velgPasient = new VelgPersonGUI(model);
        velgPasient.setLocationRelativeTo(this);
        velgPasient.setVisible(true);
        int valgtIndex = velgPasient.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            pasient = pasientRegister.HentEttObjekt(valgtIndex);
            pasientdatafelt.setText(pasient.getNavn());
        }
    }
    
    private void visAllePasienter()
    {
        String legeliste = "";
        List <Pasient> list = system.getPasientRegister().FinnAlleObjekter();
        for (Pasient pasient : list)
        {
            legeliste+= pasient.toString();
            legeliste +="\n\n";
        }
        utskrift.setText(legeliste);
    }
        
    public void visResepterForPasient()
    {
        if ( pasient != null)
        {
            FinnResepterForPasient query = new FinnResepterForPasient(pasient);
            ArrayList <Resept> reseptene = system.getReseptRegister().FinnObjekterSomMatcher(query);
            String alleResepterForPasient ="";
            for (Resept r : reseptene)
            {
                alleResepterForPasient += r.toString();
            }
            utskrift.setText("Fant følgende resepter for :\n"
                    + pasient.getNavn() + "\n" + alleResepterForPasient);
        }
        else
        {
            utskrift.setText("Du må velge en lege for å skrive ut");  
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgPasient)
        {
            VelgPasient();
        }
        else if (e.getSource() == visAllePasienter)
        {
            visAllePasienter();
        }
      
        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "Pasient info. \n"+
                                                 "Velg lege ved å trykke på ...\n" +
                                                  "For mere informasjon trykk HER");
        }
    }
    
}//end of class LegeInfoGUI