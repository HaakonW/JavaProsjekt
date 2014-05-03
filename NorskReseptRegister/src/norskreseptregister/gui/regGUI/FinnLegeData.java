/*
Filen inneholder klassen FinnLegeData
Laget av  Henrik Fischer Bjelland
Sist endret 02-05-2014
*/

package norskreseptregister.gui.regGUI;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Lege;


public class FinnLegeData implements UtvalgsKriterie <Lege>
{
    private final Lege lege;
    
    public FinnLegeData(Lege lege)
    {
        this.lege = lege;
    }

    public boolean objektetSkalVaereMed(Lege objekt)
    {
       String legeNavnIRegister = objekt.getNavn();
       String legeAdresseIRegister = objekt.getArbeidssted();
       String pasientNavnInn = lege.getNavn();
       String legeAdresseInn = lege.getArbeidssted();
       
       if (legeNavnIRegister.equals(pasientNavnInn) &&
               legeAdresseIRegister.equals(legeAdresseInn))
       {
           return true;
       }
       return false; 
    }
    
}
