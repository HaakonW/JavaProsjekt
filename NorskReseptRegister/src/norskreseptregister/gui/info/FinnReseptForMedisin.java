/*
Filen inneholder klassen FinnResepterForMedisin 
Laget av  Henrik Fischer Bjelland
Sist endret 11-05-2014
*/

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;

/* 
 FinnReseptForMedisin er et slags query som implementerer Interfacet UtvalgsKriterie av Resept.
 Hensikten er å kunne søke etter resepter som har samme medisinnavn som den valgte medisinen.
 */
public class FinnReseptForMedisin implements UtvalgsKriterie <Resept>
{
    private Medisin medisin;
    
    public FinnReseptForMedisin(Medisin medisin)
    {
        this.medisin = medisin;
    }
    
    // Metoden henter navnet på medisinen fra den innkommende resepten og sjekker om den er lik den valgte medisinen.
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