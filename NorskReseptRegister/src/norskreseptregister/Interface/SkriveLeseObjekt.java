/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.Interface;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Henrik
 */
public interface SkriveLeseObjekt 
{
    public void SkrivObjektTilFil();
    
    public void SkrivObjektTilFil(FileOutputStream filnavn);
    public boolean LesObjektFraFil(FileInputStream filnavn);
}
