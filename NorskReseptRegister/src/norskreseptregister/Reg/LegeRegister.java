/*
Filen inneholder klassen LegeRegister og arver fra Register klassen.
Laget av Henrik Fischer Bjelland
Sist endret 08-04-2014
*/
package norskreseptregister.Reg;

import javax.swing.DefaultListModel;
import norskreseptregister.ObjektKlasser.Lege;

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
