/*
Filen inneholder klassen FinnResepterForLege. 
Laget av  Henrik Fischer Bjelland
Sist endret 22-04-2014
*/

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;

public class FinnResepterForLege implements UtvalgsKriterie <Resept>
{
    private Lege lege;
    
    public FinnResepterForLege(Lege lege)
    {
        this.lege = lege;
    }

    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptLegeNavn = objekt.getLege().getNavn();
        String legeNavn = lege.getNavn();
        if (reseptLegeNavn.equals(legeNavn))
        {
            return true;
        }
        return false;
    }  
}//end of class FinnResepterForLege