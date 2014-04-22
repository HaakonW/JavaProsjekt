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
import norskreseptregister.gui.MainGui;
import norskreseptregister.gui.regGUI.RegMainGUI;

public class NorskReseptRegister
{

    public static void main(String[] args)
    {
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                RegisterSystem system = new RegisterSystem();
                system.LesFraFil();
<<<<<<< HEAD
                hovedVindu vindu = new hovedVindu(system);
=======
                Medisinliste medisinliste = Medisinliste.lesObjektFraFil();
                hovedVindu vindu = new hovedVindu(system, medisinliste);
>>>>>>> FETCH_HEAD
            }
        });
    }
}//end of class NorskReseptRegister