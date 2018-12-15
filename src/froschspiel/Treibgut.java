/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.awt.Graphics;

/**
 *
 * @author Simon
 */
public abstract class Treibgut {
    protected int aX;
    protected int aY;
    protected Bilder bilder = new Bilder();
    protected Audio audio = new Audio();
    
    public boolean hatGleichesXY(int pX, int pY){
        return getaX() == pX && getaY() == pY;
    }


    public int getaX() {
        return aX;
    }


    public int getaY() {
        return aY;
    }
    
    public abstract void zeichne(Graphics g, int breite, int hoehe);
        
           
}
