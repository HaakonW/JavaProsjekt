/*
Filen inneholder klassen FinnResepterForLege
Laget av  Henrik Fischer Bjelland
Sist endret 22-04-2014
*/

package norskreseptregister.gui.info;

import norskreseptregister.Interface.Kriterie;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;

public class FinnResepterForLege implements Kriterie <Resept>
{
    private Lege lege;
    
    public FinnResepterForLege(Lege lege)
    {
        this.lege = lege;
    }

    public boolean erOppfyltFor(Resept element)
    {
        return element.getLegedata().getNavn().equals(lege.getNavn());
    }
}
