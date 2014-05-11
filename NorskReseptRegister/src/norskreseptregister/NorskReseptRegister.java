/*
 Filen inneholder klassen NorskReseptRegister.
 Laget av Haakon Winter, Henrik Fischer Bjelland, Peter Wilhelmsen.
 Sist endret 11-05-2014 
 */
package norskreseptregister;

import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

// NorskReseptRegister er hovedklassen der mainmetoden blir kalt
public class NorskReseptRegister
{
    //Dette er main-metoden der hovedVindu blir kalt og programmet kjører
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                RegisterSystem system = new RegisterSystem();
                system.LesFraFil();
                Medisinliste medisinliste = Medisinliste.lesObjektFraFil();
                hovedVindu2 vindu = new hovedVindu2(system, medisinliste);
            }
        });
    }
}//end of class NorskReseptRegister