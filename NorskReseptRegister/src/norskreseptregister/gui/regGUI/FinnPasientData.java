/*
Filen inneholder klassen FinnPasientData
Laget av  Henrik Fischer Bjelland
Sist endret 02-05-2014
*/

package norskreseptregister.gui.regGUI;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Pasient;

// FinnPasientData er et "query" for å 
public class FinnPasientData implements UtvalgsKriterie <Pasient>
{
    private final Pasient pasient;
    
    public FinnPasientData(Pasient pasient)
    {
        this.pasient = pasient;
    }

    public boolean objektetSkalVaereMed(Pasient objekt)
    {
       String pasientNavnIRegister = objekt.getNavn();
       String pasientFodselsDatoIRegister = objekt.getFodselsdato();
       String pasientNavnInn = pasient.getNavn();
       String pasientFodselsDatoInn = pasient.getFodselsdato();
       
       if (pasientNavnIRegister.equals(pasientNavnInn) &&
               pasientFodselsDatoIRegister.equals(pasientFodselsDatoInn))
       {
           return true;
       }
       return false; 
    }
    
}//end of class FinnPasientData
