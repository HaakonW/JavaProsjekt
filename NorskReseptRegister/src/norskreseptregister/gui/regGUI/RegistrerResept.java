/*
Filen inneholder klassen RegistrerResept.
Laget av Henrik Fischer Bjelland, Haakon Winther
Sist endret 09-04-2014 
*/

package norskreseptregister.gui.regGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.Reg.ReseptRegister;

public class RegistrerResept extends JPanel implements ActionListener
{
    private String pasientliste = "pasientliste.txt";
    private JTextField datofelt, pasientdatafelt, legedatafelt, medisindatafelt, mengdefelt, kategorifelt;
    private JLabel datolabel, pasientdatalabel, legedatalabel, medisindatalabel, mengdelabel, kategorilabel, anvisningslabel;
    private JButton regResept, visListe, velgPasient, velgLege, velgMedisin;

    JTextArea utskrift, anvisning;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    private final RegisterSystem system;
    private Pasient pasient;
    private final Medisinliste medisinliste;
    private Lege lege;
    private Medisin medisin;
    
    public RegistrerResept(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        datofelt = new JTextField(20);
        pasientdatafelt = new JTextField(21);

        legedatafelt = new JTextField(20);
        medisindatafelt = new JTextField(20);
        mengdefelt = new JTextField(20);
        //kategorifelt = new JTextField(20);
        

        datolabel = new JLabel("Dato       ");
        pasientdatalabel = new JLabel("Pasient ");

        datolabel = new JLabel("Dato  ");
        pasientdatalabel = new JLabel("Pasient      ");

        legedatalabel = new JLabel("Lege       ");
        medisindatalabel = new JLabel("Medisin   ");
        mengdelabel = new JLabel("Mengde   ");
        kategorilabel = new JLabel("Kategori  ");
        anvisningslabel = new JLabel("Anvisning");
        pasientdatafelt.setEditable(false);

        legedatafelt.setEditable(false);
        medisindatafelt.setEditable(false);
        
        regResept = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        
        velgPasient = new JButton("...");
        velgLege = new JButton("...");
        velgMedisin = new JButton("...");
        
        velgPasient.setPreferredSize(new Dimension(20, 20));
        velgLege.setPreferredSize(new Dimension(20, 20));
        velgMedisin.setPreferredSize(new Dimension(20, 20));
        
        
        anvisning = new JTextArea(5,20);
        //JScrollPane sp = new JScrollPane(anvisning); //PRøvde å få til scroller
        utskrift = new JTextArea(20,20);
        
        regResept.addActionListener(this);
        visListe.addActionListener(this);
        velgPasient.addActionListener(this);
        velgLege.addActionListener(this);
        velgMedisin.addActionListener(this);
        
        panel1 = new JPanel();
        panel1.add(datolabel);
        panel1.add(datofelt);
        
        panel2 = new JPanel();
        panel2.add(pasientdatalabel);
        panel2.add(pasientdatafelt);
        panel2.add(velgPasient);
        
        panel3 = new JPanel();
        panel3.add(legedatalabel);
        panel3.add(legedatafelt);
        panel3.add(velgLege);
        
        panel4 = new JPanel();        
        panel4.add(medisindatalabel);
        panel4.add(medisindatafelt);
        panel4.add(velgMedisin);;
        
        panel5 = new JPanel();
        panel5.add(mengdelabel);
        panel5.add(mengdefelt);
        
        /*panel6 = new JPanel();
        panel6.add(kategorilabel);
        panel6.add(kategorifelt);*/
        
        panel7 = new JPanel();
        panel7.add(anvisningslabel);
        panel7.add(anvisning);
              
        panel8 = new JPanel();
        panel8.add(regResept);
        panel8.add(visListe);
        
        panel9 = new JPanel();
        panel9.add(utskrift);
        
        //////// START GRID ///////////
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        int x = 0;
        int y = 0;
                
        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 5, 5, 10);
        //gc.anchor = GridBagConstraints.EAST; // MÅ FIKSE LAYOUT HER
        gc.fill = GridBagConstraints.HORIZONTAL; 
        add(panel1, gc);
        y++;
        
        gc.gridx = x;
        gc.gridy = y;
        add(panel2, gc);
        y++;
        
        gc.gridx = x;
        gc.gridy = y;
        add(panel3, gc);
        y++;
        
        gc.gridx = x;
        gc.gridy = y;
        add(panel4, gc);
        y++;
        
        gc.gridx = x;
        gc.gridy = y;
        add(panel5, gc);
        y++;
        
       /* gc.gridx = x;
        gc.gridy = y;
        add(panel6, gc);
        y++;*/
        
         gc.gridx = x;
        gc.gridy = y;
        add(panel7, gc);
        y++;
        
         gc.gridx = x;
        gc.gridy = y;
        add(panel8, gc);
        x++;
        
        gc.gridx = x;
        gc.gridy = 0;
        gc.gridheight = 10;
        gc.fill = GridBagConstraints.VERTICAL;
        add(panel9, gc);
    }//end of Konstruktør
    
    private void nyResept()
    {
        Resept ny = new Resept(datofelt.getText(), pasient, 
                lege, medisin.getNavn(), mengdefelt.getText(),"", anvisning.getText());
        system.getReseptRegister().SettInn(ny);
        utskrift.setText("Registrert resept: \n" + ny.toString());
    }
    
    private void TomFelt()
    {
        datofelt.setText("");
        pasientdatafelt.setText("");
        legedatafelt.setText("");
        medisindatafelt.setText("");
        mengdefelt.setText("");
        //kategorifelt.setText("");
    }
    
    private void SkrivUt()
    {
        String pasientliste = "";
        List <Resept> list = system.getReseptRegister().FinnAlle();
        for (Resept resept : list)
        {
            pasientliste+= resept.toString();
            pasientliste +="\n\n";
        }
        utskrift.setText(pasientliste);
    }
    
    private void VelgPasient()
    {
        VelgPasientGUI velgPasientGUI = new VelgPasientGUI(this, system);
        velgPasientGUI.setLocationRelativeTo(this);
        velgPasientGUI.setVisible(true);
        pasient = system.getPasientRegister().HentEttElement(velgPasientGUI.getValgtIndex());
        pasientdatafelt.setText(pasient.getNavn());

        PasientRegister pasientRegister = system.getPasientRegister();
        DefaultListModel model = new DefaultListModel();
        for (Pasient p : pasientRegister.FinnAlle())
        {
            model.addElement(p.toString());
        }

        VelgPersonGUI velgPasient = new VelgPersonGUI(model);
        velgPasient.setLocationRelativeTo(this);
        velgPasient.setVisible(true);
        int valgtIndex = velgPasient.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            pasient = pasientRegister.HentEttElement(valgtIndex);
            pasientdatafelt.setText(pasient.getNavn());
        }
    }
    
    private void VelgLege()
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
    
    private void VelgMedisin()
    {
        DefaultListModel model = new DefaultListModel();
        for (Medisin m : medisinliste.FinnAlle())
        {
            model.addElement(m.toString());
        }
        VelgPersonGUI velgMedisin = new VelgPersonGUI(model);
        velgMedisin.setLocationRelativeTo(this);
        velgMedisin.setVisible(true);
        int valgtIndex = velgMedisin.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            medisin = medisinliste.HentEttElement(valgtIndex);
            medisindatafelt.setText(medisin.getNavn());
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == regResept)
        {
            nyResept();
            TomFelt();
        }
        if(e.getSource() == visListe)
        {
            SkrivUt();
        }
        if (e.getSource() == velgPasient)
        {
            VelgPasient();
        }
        if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        if (e.getSource() == velgMedisin)
        {
            VelgMedisin();
        }
    }
}//end of class RegistrerResept