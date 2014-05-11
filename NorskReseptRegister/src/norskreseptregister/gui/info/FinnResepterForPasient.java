/*
 Filen inneholder klassen FinnResepterForPasient. 
 Laget av  Henrik Fischer Bjelland
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;

/* 
 FinnResepterForPasient er et slags query som implementerer Interfacet UtvalgsKriterie av Resept.
 Hensikten er å kunne søke igjennom reseptene i registeret og hente ut de som har navn lik den valgte pasienten.
 */
public class FinnResepterForPasient implements UtvalgsKriterie<Resept>
{
    private Pasient pasient;

    public FinnResepterForPasient(Pasient pasient)
    {
        this.pasient = pasient;
    }

    /* 
     Metode henter navnet på pasienten fra resepten i registeret 
     og sjekker om det stemmer opp mot det valgte pasientnavnet
     */
    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptPasientNavn = objekt.getPasient().getNavn();
        String pasientNavn = pasient.getNavn();
        if (reseptPasientNavn.equals(pasientNavn))
        {
            return true;
        }
        return false;
    }
}//end of class FinnResepterForPasient
