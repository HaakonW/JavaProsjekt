/*
Filen inneholder klassen LegeRegister..
Laget av Henrik Fischer Bjelland
Sist endret 08-04-2014
*/
package norskreseptregister.Reg;

import javax.swing.DefaultListModel;
import norskreseptregister.ObjektKlasser.Lege;

//LegeRegister er en subklasse av Register og inneholder en override metode for getListModel()
public class LegeRegister extends Register<Lege>
{
    //
    @Override
    public DefaultListModel<String> getListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Lege lege : FinnAlleObjekter())
        {
            model.addElement(lege.getNavnOgArbeidsSted());
        }
        return model;
    }
}
