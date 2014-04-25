/*
 Filen inneholder klassen NorskReseptRegister som er mainklassen der alle 
 vinduene våre blir kalt opp.
 Laget av Haakon Winter, Henrik Fischer Bjelland, Peter Wilhelmsen.
 Sist endret 17-04-2014 
 */
package norskreseptregister;

import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
<<<<<<< HEAD
=======

>>>>>>> FETCH_HEAD
import norskreseptregister.gui.regGUI.RegMainGUI;

public class NorskReseptRegister
{
    //Dette er main-metoden der hovedVindu blir kalt og programmet starer
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                RegisterSystem system = new RegisterSystem();
                system.LesFraFil();
                Medisinliste medisinliste = Medisinliste.lesObjektFraFil();
                hovedVindu vindu = new hovedVindu(system, medisinliste);
            }
        });
    }
}//end of class NorskReseptRegister