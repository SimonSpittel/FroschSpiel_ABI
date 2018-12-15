/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Simon
 */
public class Muenze extends Treibgut {
    
    private boolean aGeholt;

    public Muenze(int pX, int pY){
        aX = pX;
        aY = pY;
         bilder.loadMuenze();
        
    }
    
    public void treiben(){
        aX--;
        if(aX < 0){
            aX = 19;
        }
    }
    
    public void holen(){
        aGeholt = true;
    }
    
    
    
    
    
    @Override
    public void zeichne(Graphics g, int breite, int hoehe) {
       
        g.setColor(Color.yellow);
//        g.fillRect(aX*breite, aY*hoehe+breite/3, breite-(breite/3)*2, hoehe-(hoehe/3)*2);
        g.drawImage(bilder.getMuenze(),aX*breite, aY*hoehe, breite, hoehe, null);
    }

    public boolean getaGeholt() {
        return aGeholt;
    }
    
}
