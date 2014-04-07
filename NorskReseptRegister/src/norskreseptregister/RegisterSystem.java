/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister;

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
}// end of class System
