/*
Filen inneholder klassen RegisterSystem og inneholder alle registerne våre.
Her er også metoden for å skrive og lese til fil.
Laget av Henrik Fischer Bjelland
Sist endret 22-04-2014
*/

package norskreseptregister.Reg;

public class RegisterSystem 
{
    private LegeRegister legeRegister;
    private PasientRegister pasientRegister;
    private ReseptRegister reseptRegister;
    //Konstruktøren new'er opp alle registerne
    public RegisterSystem()
    {
        legeRegister = new LegeRegister();
        pasientRegister = new PasientRegister();
        reseptRegister = new ReseptRegister();
    }
    //Get Metoder for registerne
    public LegeRegister getLegeRegister()
    {
        return legeRegister;
    }
    
    public PasientRegister getPasientRegister()
    {
        return pasientRegister;
    }
        
    public ReseptRegister getReseptRegister()
    {
        return reseptRegister;
    }
    //Metode for å skrive til fil
    public void SkrivTilFil() 
    {
        legeRegister.SkrivTilFil("LegeRegister.txt");
        pasientRegister.SkrivTilFil("PasientRegister.txt");
        reseptRegister.SkrivTilFil("ReseptRegister.txt");
    }
    //Meotde for å lese fra fil
    public void LesFraFil()
    {
        legeRegister.LesFraFil("LegeRegister.txt");
        pasientRegister.LesFraFil("PasientRegister.txt");
        reseptRegister.LesFraFil("ReseptRegister.txt");   
    }
}// end of class System
