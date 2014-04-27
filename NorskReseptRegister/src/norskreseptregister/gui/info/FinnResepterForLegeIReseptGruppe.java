/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;


public class FinnResepterForLegeIReseptGruppe implements UtvalgsKriterie <Resept>
{
    private final Lege lege;
    private final Boolean gruppeA;
    private final Boolean gruppeB;
    private final Boolean gruppeC;
    
    public FinnResepterForLegeIReseptGruppe(Lege lege, Boolean gruppeA,Boolean gruppeB, Boolean gruppeC )
    {
        this.lege = lege;
        this.gruppeA = gruppeA;
        this.gruppeB = gruppeB;
        this.gruppeC = gruppeC;
    }

    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptLegeNavn = objekt.getLegedata().getNavn();
        String legeNavn = lege.getNavn();
        if (reseptLegeNavn.equals(legeNavn))
        {
            if (objekt.getMedisin().getGruppeA() && gruppeA)
            {
                return true;
            }
            if (objekt.getMedisin().getGruppeB() && gruppeB)
            {
                return true;
            }
            if (objekt.getMedisin().getGruppeC() && gruppeC)
            {
                return true;
            }
        }
        return false;
    }
}
