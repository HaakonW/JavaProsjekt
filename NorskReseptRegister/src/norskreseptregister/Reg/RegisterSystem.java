/*
Filen inneholder klassen RegisterSystem
Laget av Henrik Fischer Bjelland
Sist endret 08-04-2014
*/

package norskreseptregister.Reg;

public class RegisterSystem 
{
    private LegeRegister legeRegister;
    private PasientRegister pasientRegister;
    private ReseptRegister reseptRegister;
    
    public RegisterSystem()
    {
        legeRegister = new LegeRegister();
        pasientRegister = new PasientRegister();
        reseptRegister = new ReseptRegister();
    }
    
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

    public void SkrivTilFil() 
    {
        legeRegister.SkrivTilFil("LegeRegister.txt");
        pasientRegister.SkrivTilFil("PasientRegister.txt");
        reseptRegister.SkrivTilFil("ReseptRegister.txt");
    }
}// end of class System
