/*
 Filen inneholder klassen FinnResepterForLege. 
 Laget av  Henrik Fischer Bjelland
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;

/* 
 FinnResepterForLege  er et slags query som implementerer Interfacet UtvalgsKriterie av Resept.
 Hensikten er å kunne søke igjennom reseptene i registeret og hente ut de som har navn lik den valgte legen.
 */
public class FinnResepterForLege implements UtvalgsKriterie<Resept>
{
    private Lege lege;

    public FinnResepterForLege(Lege lege)
    {
        this.lege = lege;
    }

    
    // Metode henter navnet på legen fra resepten i registeret og sjekker om det stemmer opp mot det valgte legenavnet
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
