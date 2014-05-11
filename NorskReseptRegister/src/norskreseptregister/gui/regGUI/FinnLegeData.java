/*
 Filen inneholder klassen FinnLegeData
 Laget av  Henrik Fischer Bjelland
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.regGUI;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Lege;

/* 
 FinnLegeData er et slags query som implementerer Interfacet UtvalgsKriterie av Lege.
 Hensikten er å kunne søke igjennom legeRegisteret for å undersøke om den legen som kommer inn allerede
 eksisterer i registeret.
 */
public class FinnLegeData implements UtvalgsKriterie<Lege>
{
    private final Lege lege;

    public FinnLegeData(Lege lege)
    {
        this.lege = lege;
    }

    // Metoden henter navn og adresse fra den innkommende legen og sjekker de opp mot legeRegisteret.
    public boolean objektetSkalVaereMed(Lege objekt)
    {
        String legeNavnIRegister = objekt.getNavn();
        String legeAdresseIRegister = objekt.getArbeidssted();
        String pasientNavnInn = lege.getNavn();
        String legeAdresseInn = lege.getArbeidssted();

        if (legeNavnIRegister.equals(pasientNavnInn)
                && legeAdresseIRegister.equals(legeAdresseInn))
        {
            return true;
        }
        return false;
    }
} // end of class FinnLegeData
