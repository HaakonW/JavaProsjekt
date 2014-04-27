/*
Filen inneholder klassen FinnResepterForMedisin 
Laget av  Henrik Fischer Bjelland
Sist endret 22-04-2014
*/

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;


public class FinnReseptForMedisin implements UtvalgsKriterie <Resept>
{
    private Medisin medisin;
    
    public FinnReseptForMedisin(Medisin medisin)
    {
        this.medisin = medisin;
    }
    
    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptMedisinNavn = objekt.getMedisin().getNavn();
        String medisinNavn = medisin.getNavn();
        if (reseptMedisinNavn.equals(medisinNavn))
        {
            return true;
        }
        return false;
    }
}//end of class FinnReseptForMedisin