/*
 Filen inneholder klassen InfoSystem.
 Laget av  Henrik Fischer Bjelland 
 Sist endret 11-04-2014 
 */
package norskreseptregister.Info;

public class InfoSystem
{

    private LegeInfo legeInfo;
    private PasientInfo pasientInfo;

    public InfoSystem()
    {
        legeInfo = new LegeInfo();
        pasientInfo = new PasientInfo();
    }

    public LegeInfo getLegeInfo()
    {
        return legeInfo;
    }

    public PasientInfo getPasientInfo()
    {
        return pasientInfo;
    }

}//end of class InfoSystem