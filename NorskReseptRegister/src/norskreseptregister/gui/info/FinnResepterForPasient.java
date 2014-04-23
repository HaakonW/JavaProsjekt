/*
Filen inneholder klassen FinnResepterForPasient. 
Laget av  Henrik Fischer Bjelland
Sist endret 22-04-2014
*/

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;

public class FinnResepterForPasient implements UtvalgsKriterie <Resept>
{
    private Pasient pasient;
    
    public FinnResepterForPasient(Pasient Pasient)
    {
        this.pasient = pasient;
    }

    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptPasientNavn = objekt.getPasientdata().getNavn();
        String pasientNavn = pasient.getNavn();
        if (reseptPasientNavn.equals(pasientNavn))
        {
            return true;
        }
        return false;
    }
}//end of class FinnResepterForLege