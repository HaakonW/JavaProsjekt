/*
 Filen inneholder klassen OmVindu.
 Laget av Peter Wilhelmsen
 Sist endret 13-05-14
 */
package norskreseptregister;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// OmVindu som viser informasjon om hvem som har laget programmet, rettigheter og lignende.
public class OmVindu extends JFrame
{
    private JFrame ramme;
    private JTextArea utskrift;
    private Font font;
    private String tekst;

    public OmVindu()
    {
        ramme = new JFrame();
        utskrift = new JTextArea();
        font = new Font("Monospaced", Font.PLAIN, 11);

        tekst = "Velkommen til Norsk ReseptRegister\n"
                + "Programmet er eksamensoppgave i faget Programutvikling på HIOA"
                + " våren 2014\n\n";
        tekst += "Norsk Reseptregister er laget av "
                + "Henrik Bjelland, Haakon Winther & Peter Wilhelmsen\n\n";
        tekst += "Norsk ReseptRegister version 1.0 \n™ and © 2014 Gruppe 38\n";
        tekst += "All Rights Reserved";

        utskrift.setText(tekst);
        utskrift.setFont(font);
        utskrift.setBackground(Color.LIGHT_GRAY);
        utskrift.setEditable(false);
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);

        setTitle("Norsk ReseptRegister");
        add(utskrift);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}// end of class OmVindu
