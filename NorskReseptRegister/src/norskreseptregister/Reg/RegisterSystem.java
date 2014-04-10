/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.Reg;

/**
 *
 * @author Henrik
 */
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
