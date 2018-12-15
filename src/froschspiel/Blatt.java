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
public class Blatt extends Treibgut {
    
    public Blatt(int pX, int pY){
        aX = pX;
        aY = pY;
         bilder.loadSchwimmElement();
        
    }
    
    public void treiben(){
        aX++;
        if(aX > 19){
            aX = 0;
        }
    }

    
    @Override
    public void zeichne(Graphics g, int breite, int hoehe){
       
        g.setColor(Color.BLACK);
     //   g.fillRect(aX*breite, aY*hoehe, breite, hoehe);
        g.drawImage(bilder.getSchwimmElement(),aX*breite, aY*hoehe, breite, hoehe, null);
        
    }
    
}
