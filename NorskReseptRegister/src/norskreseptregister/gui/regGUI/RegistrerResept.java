/*
 * Filen inneholder klassen RegistrerResept.
 * Laget av  Henrik
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui.regGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.ReseptRegister;
import norskreseptregister.Reg.RegisterSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrerResept extends JPanel implements ActionListener
{
    private ReseptRegister reseptRegister;
    private String pasientliste = "pasientliste.txt";
    private JTextField datofelt, pasientdatafelt, legedatafelt, medisindatafelt, mengdefelt, kategorifelt;
    private JLabel datolabel, pasientdatalabel, legedatalabel, medisindatalabel, mengdelabel, kategorilabel, anvisningslabel;
    private JButton regResept, visListe;
    private JTextArea utskrift, anvisning;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
    
    public RegistrerResept(ReseptRegister reseptRegister)
    {
        this.reseptRegister = reseptRegister;
        datofelt = new JTextField(20);
        pasientdatafelt = new JTextField(20);
        legedatafelt = new JTextField(20);
        medisindatafelt = new JTextField(20);
        mengdefelt = new JTextField(20);
        kategorifelt = new JTextField(20);
        
        datolabel = new JLabel("Dato     ");
        pasientdatalabel = new JLabel("Pasient   ");
        legedatalabel = new JLabel("Lege");
        medisindatalabel = new JLabel("Medisin     ");
        mengdelabel = new JLabel("Mengde   ");
        kategorilabel = new JLabel("Kategori");
        anvisningslabel = new JLabel("Anvisning");
        
        regResept = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        
        anvisning = new JTextArea(5,20);
        //JScrollPane sp= new JScrollPane(anvisning); PRøvde å få til scroller
        utskrift = new JTextArea(20,20);        
        regResept.addActionListener(this);
        visListe.addActionListener(this);
        
        panel1 = new JPanel();
        panel1.add(datolabel);
        panel1.add(datofelt);
        
        panel2 = new JPanel();
        panel2.add(pasientdatalabel);
        panel2.add(pasientdatafelt);
        
        panel3 = new JPanel();
        panel3.add(legedatalabel);
        panel3.add(legedatafelt);
        
        panel4 = new JPanel();        
        panel4.add(medisindatalabel);
        panel4.add(medisindatafelt);
        
        panel5 = new JPanel();
        panel5.add(mengdelabel);
        panel5.add(mengdefelt);
        
        panel6 = new JPanel();
        panel6.add(kategorilabel);
        panel6.add(kategorifelt);
        
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
        
        gc.gridx = x;
        gc.gridy = y;
        add(panel6, gc);
        y++;
        
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
        
        
        
    }
    
    private void nyResept()
    {
        /*Resept ny = new Resept(datofelt.getText(), pasientdatafelt.getText(), 
                legedatafelt.getText(), medisindatafelt.getText(), 
                mengdefelt.getText(),kategorifelt.getText(), anvisning.getText());
        reseptRegister.SettInn(ny);
        utskrift.setText("Registrert pasient: \n" + ny.toString());*/
    }
    
    private void TomFelt()
    {
        datofelt.setText("");
        pasientdatafelt.setText("");
        legedatafelt.setText("");
        medisindatafelt.setText("");
        mengdefelt.setText("");
        kategorifelt.setText("");
    }
    
    private void SkrivUt()
    {
        String pasientliste = "";
        List <Resept> list = reseptRegister.FinnAlle();
        for (Resept resept : list)
        {
            pasientliste+= resept.toString();
            pasientliste +="\n\n";
        }
        utskrift.setText(pasientliste);
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
    }
}//end of class RegistrerResept
