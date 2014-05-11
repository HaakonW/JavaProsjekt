/*
 Filen inneholder klassen FinnPasientData
 Laget av  Henrik Fischer Bjelland
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.regGUI;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Pasient;

/* 
 FinnPasientData er et slags query som implementerer Interfacet UtvalgsKriterie av Pasient.
 Hensikten er å kunne søke igjennom pasientRegisteret for å undersøke om den pasienten som kommer inn allerede
 eksisterer i registeret.
 */
public class FinnPasientData implements UtvalgsKriterie<Pasient>
{
    private final Pasient pasient;

    public FinnPasientData(Pasient pasient)
    {
        this.pasient = pasient;
    }

    // Metoden henter navn og fødselsdato fra den innkommende pasientet og sjekker de opp mot pasientRegisteret.
    public boolean objektetSkalVaereMed(Pasient objekt)
    {
        String pasientNavnIRegister = objekt.getNavn();
        String pasientFodselsDatoIRegister = objekt.getFodselsdato();
        String pasientNavnInn = pasient.getNavn();
        String pasientFodselsDatoInn = pasient.getFodselsdato();

        if (pasientNavnIRegister.equals(pasientNavnInn)
                && pasientFodselsDatoIRegister.equals(pasientFodselsDatoInn))
        {
            return true;
        }
        return false;
    }

}// end of class FinnPasientData
