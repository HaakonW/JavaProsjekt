/*
 Filen inneholder klassen FinnResepterForPasientIReseptGruppe.
 Laget av  Henrik Fischer Bjelland
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;

/* 
 FinnResepterForPasientIReseptGruppee er et slags query som implementerer Interfacet UtvalgsKriterie av Resept.
 Hensikten er å kunne søke igjennom reseptene i registeret og hente ut de som har navn lik den valgte pasienten
 og reseptgruppe lik den valgte reseptgruppen.
 */
public class FinnResepterForPasientIReseptGruppe implements UtvalgsKriterie<Resept>
{
    private final Pasient pasient;
    private final Boolean gruppeA;
    private final Boolean gruppeB;
    private final Boolean gruppeC;

    public FinnResepterForPasientIReseptGruppe(Pasient pasient, Boolean gruppeA, Boolean gruppeB, Boolean gruppeC)
    {
        this.pasient = pasient;
        this.gruppeA = gruppeA;
        this.gruppeB = gruppeB;
        this.gruppeC = gruppeC;
    }

    /* 
     Metode henter navnet på pasienten fra den innkommende 
     resepten og sjekker om det stemmer opp mot det valgte pasientnavnet.
     Så sjekker den hvilke medisingruppe som er valgt og returnerer true for denne som er valgt.
     */
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
} // end og class FinnResepterForPasientIReseptGruppe