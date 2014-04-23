/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui.info;

import norskreseptregister.Interface.UtvalgsKriterie;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;


public class FinnReseptForMedisin implements UtvalgsKriterie <Resept>
{
    private Medisin medisin;
    
    public FinnReseptForMedisin(Medisin medisin)
    {
        this.medisin = medisin;
    }

    public boolean objektetSkalVaereMed(Resept objekt)
    {
        String reseptMedisinNavn = objekt.getMedisinData();
        String medisinNavn = medisin.getNavn();
        if (reseptMedisinNavn.equals(medisinNavn))
        {
            return true;
        }
        return false;
    }
}