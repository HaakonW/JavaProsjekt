/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.RegisterSystem;
/**
 *
 * @author Henrik
 */

public class RegistrerPasient extends JFrame
{
        private JTextField fornavn, etternavn, dato;
        private JTextArea pasientutskrift; //Utskriftområde
        RegisterSystem system;
        
    public RegistrerPasient(RegisterSystem system)
    {
        this.system = system;
        //getContentPane().add(fane);
        JPanel fane1 = new JPanel();

        /*JLabel label2 = new JLabel();
        fane.addTab("Registrer Pasient", test);
        test.setLayout(new FlowLayout());
        test.add(regPasient = new JButton ("Registrer pasient"));  
        test.add(sjekkPasient = new JButton ("Sjekk pasient"));        
        test.add(new JLabel("Etternavn: "));               
        test.add(etternavn);
        test.add(new JLabel("Fornavn: "));
        test.add(fornavn); 
        test.add(new JLabel("Dato: "));
        test.add(dato);
        test.add(pasientutskrift = new JTextArea(15, 40));
        this.pasientutsktift = pasientutskrift;*/   
    }

}
