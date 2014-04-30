/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;

public class FinnResepterForPasientIReseptGruppe implements UtvalgsKriterie <Resept>
{
    private final Pasient pasient;
    private final Boolean gruppeA;
    private final Boolean gruppeB;
    private final Boolean gruppeC;
    
    public FinnResepterForPasientIReseptGruppe(Pasient pasient, Boolean gruppeA,Boolean gruppeB, Boolean gruppeC)
    {
        this.pasient = pasient;
        this.gruppeA = gruppeA;
        this.gruppeB = gruppeB;
        this.gruppeC = gruppeC;
    }

    public boolean objektetSkalVaereMed(Resept objekt)
    {
       String reseptPasientNavn = objekt.getPasient().getNavn();
       String pasientNavn = pasient.getNavn();
       if (reseptPasientNavn.equals(pasientNavn))
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