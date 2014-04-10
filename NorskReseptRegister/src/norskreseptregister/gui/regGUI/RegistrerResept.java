/*
 * Filen inneholder klassen RegistrerResept.
 * Laget av  Henrik
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui.regGUI;

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
        
        anvisning = new JTextArea(5,15);
        utskrift = new JTextArea(20,20);        
        regResept.addActionListener(this);
        visListe.addActionListener(this);
        
        add(datolabel);
        add(datofelt);
        
        add(pasientdatalabel);
        add(pasientdatafelt);
        
        add(legedatalabel);
        add(legedatafelt);
        
        add(medisindatalabel);
        add(medisindatafelt);
        
        add(mengdelabel);
        add(mengdefelt);
        
        add(kategorilabel);
        add(kategorifelt);
        
        add(anvisningslabel);
        add(anvisning);
        
        add(utskrift);
        
        add(regResept);
        add(visListe);
        
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
