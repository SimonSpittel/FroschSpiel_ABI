/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon
 */
public class Frosch extends Treibgut{
static{
    
    
}
    /**
     * @return the aMuenzzahl
     */
    public int getaMuenzzahl() {
        return aMuenzzahl;
    }
    private Image frosch;
    private int aVersuche;
    private int aMuenzzahl;
    
    public Frosch(int pX, int pY){
        aX = pX;
        aY = pY;
        bilder.loadFrosch();
        audio.loadJump();
        
        
    }
    
    public void springen(java.awt.event.KeyEvent evt){       
        switch(evt.getKeyCode()){
           case(KeyEvent.VK_UP): aY--;                                   
                                 break;
            case(KeyEvent.VK_DOWN): aY++;
                                 break;
            case(KeyEvent.VK_RIGHT): aX++;
                                 break;
            case(KeyEvent.VK_LEFT): aX--;
                                 break; 
            default:                     break;                     
       }

        if(aY > 9){
            aY--;
        }else{
            audio.JumpReset();
            audio.clipJumpStart();
        }
        if(aX < 0){
            aX = 19;
        }
        if(aX > 19){
            aX = 0;
        }
    }

    @Override
    public void zeichne(Graphics g, int breite, int hoehe) {
        
        g.setColor(Color.green);
    //    g.fillRect(aX*breite, aY*hoehe, breite, hoehe);
        g.drawImage(bilder.getFrosch(),aX*breite, aY*hoehe, breite, hoehe, null);
        
    }
    
    public void aufStartPos(){
        aX = 9;
        aY = 9;
    }
    
    public void reset(){
        aVersuche = 3;
        aMuenzzahl = 0;
    }
    
    public void decVersuche(){
        aVersuche--;
        
    }

    
    
    
}
