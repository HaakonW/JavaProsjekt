/*
 Filen inneholder klassen FinnResepterForLegeIReseptGruppe.
 Laget av  Henrik Fischer Bjelland
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;

public class FinnResepterForLegeIReseptGruppe implements UtvalgsKriterie<Resept>
{
    private final Lege lege;
    private final Boolean gruppeA;
    private final Boolean gruppeB;
    private final Boolean gruppeC;

    /* 
     FinnResepterForLegeIReseptGruppe  er et slags query som implementerer Interfacet UtvalgsKriterie av Resept.
     Hensikten er å kunne søke igjennom reseptene i registeret og hente ut de som har navn lik den valgte legen
     og reseptgruppe lik den valgte reseptgruppen.
     */
    public FinnResepterForLegeIReseptGruppe(Lege lege, Boolean gruppeA, Boolean gruppeB, Boolean gruppeC)
    {
        this.lege = lege;
        this.gruppeA = gruppeA;
        this.gruppeB = gruppeB;
        this.gruppeC = gruppeC;
    }

    /* 
     Metode henter navnet på legen fra den innkommende 
     resepten og sjekker om det stemmer opp mot det valgte legenavnet.
     Så sjekker den hvilke medisingruppe som er valgt og returnerer true for denne som er valgt.
     */
    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptLegeNavn = objekt.getLege().getNavn();
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
} // end of class FinnResepterForLegeIReseptGruppe