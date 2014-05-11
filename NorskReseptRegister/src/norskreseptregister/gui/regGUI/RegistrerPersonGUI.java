/*
 Filen inneholder klassen RegistrerPersonGUI.
 Laget av Henrik Fischer Bjelland, Haakon Winther
 Sist endret 11-05-2014  
 */
package norskreseptregister.gui.regGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* 
RegistrerPersonGUI er en abstrakt superklasse for registrering av person(Pasient,Lege)
Klassen inneholder alt som er felles for Pasient og Lege.
*/
public abstract class RegistrerPersonGUI extends JPanel implements ActionListener
{
    protected JButton reg, hjelp;
    protected JTextField fornavnfelt, etternavnfelt, infofelt;
    protected JTextArea utskrift;
    private JLabel fornavnlabel, etternavnlabel, infolabel;
    private JPanel fornavnpanel, etternavnpanel, infopanel, regknapppanel, utskriftpanel;

    public RegistrerPersonGUI(String infolabeltekst, String infoFeltTekst)
    {
        fornavnlabel = new JLabel("Fornavn      ");
        fornavnfelt = new JTextField(20);
        
        etternavnlabel = new JLabel("Etternavn    ");
        etternavnfelt = new JTextField(20);
        
        infolabel = new JLabel(infolabeltekst);
        infofelt = new JTextField(20);
        infofelt.setText(infoFeltTekst);

        reg = new JButton("Registrer");
        reg.setToolTipText("Trykk her for å registrere");
        reg.addActionListener(this);

        hjelp = new JButton("?");
        hjelp.setToolTipText("Trykk her for hjelp");
        hjelp.setPreferredSize(new Dimension(25, 25));
        hjelp.addActionListener(this);
<<<<<<< HEAD
=======

>>>>>>> FETCH_HEAD

        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);

        // legger element i paneler
        fornavnpanel = new JPanel();
        fornavnpanel.add(fornavnlabel);
        fornavnpanel.add(fornavnfelt);

        etternavnpanel = new JPanel();
        etternavnpanel.add(etternavnlabel);
        etternavnpanel.add(etternavnfelt);

        infopanel = new JPanel();
        infopanel.add(infolabel);
        infopanel.add(infofelt);

        regknapppanel = new JPanel();
        regknapppanel.add(reg);

        utskriftpanel = new JPanel();
        utskriftpanel.add(utskrift);

<<<<<<< HEAD
       /* Her starter layouten for registrer en person. Sjekk
        produktdokumentasjonen for forklaring av layouten*/
        

        /*
        START INNSETTINGEN AV ELEMENTENE I LAYOUTEN OPPRETTER EN INT X OG INT
        Y FOR Å ENKELT KUNNE UTVIDE MED FLERE ELEMENTER INSETS ER AVSTAND FRA
        TOP, VENSTRE, BUNN OG HØYRE
        */
=======

       /* Her starter layouten for registrer en person. Sjekk
        produktdokumentasjonen for forklaring av layouten*/
>>>>>>> FETCH_HEAD

        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;
        
        gc.gridx = x;
        gc.gridy = y;
<<<<<<< HEAD
        gc.insets = new Insets(10, 10, 10, 10);  
        //add(panel1, gc);

=======
>>>>>>> FETCH_HEAD
        gc.insets = new Insets(5, 5, 5, 10);
        add(fornavnpanel, gc);


        gc.gridx = x;
        gc.gridy = ++y;
        add(etternavnpanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(infopanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(regknapppanel, gc);

        //Nullstiller y for en ny rad. 
        y = 0;
        gc.gridx = ++x;
        gc.gridy = y;
        gc.gridheight = 6;
        add(utskriftpanel, gc);

        gc.gridx = ++x;
        gc.gridy = 6;
        add(hjelp, gc);

    }// end of konstruktør RegistrerLege

    // Metode for å tømme feltene
    public void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        infofelt.setText("");
    }
    
    //  RegEx for fornavn
    public boolean sjekkFornavn(String fornavn)
    {  
 
        if(fornavn.matches("^[a-zøæåéA-ZØÆÅ. \\-]{2,20}"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Fornavnet må være kun bokstaver.");
            return false;
        } 
    }
    
    // RegEx for etternavn
    public boolean sjekkEtternavn(String etternavn)
    {
        
        if(etternavn.matches("^[a-zøæåéA-ZØÆÅ. \\-]{2,20}"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Etternavnet må være kun bokstaver.");
            return false;
        }
    }
    
    // RegEx for fødselsdato
    public boolean sjekkFodselsdato(String fodselsdato)
    {
       if(infofelt.getText().matches("\\d.*"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Feilmelding for fødselsdato.");
            return false;
        }
    }
        
    // RegEx for adresse
    public boolean sjekkAdresse(String adresse)
    {
        if (infofelt.getText().matches("^[a-zøæåéA-ZØÆÅ. \\-]{2,20}"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Adresse må være kun bokstaver.");
            return false;
        }
    }
}// end of class RegistrerLege
