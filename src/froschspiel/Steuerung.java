/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author Simon
 */
public class Steuerung {

    /**
     * @param graphic the graphic to set
     */

    GUI oberflaeche;
    private int aVersuche = 3;
    private int aMuenzzahl = 0;
    private int aBlattzahl;
    private int aZustand;
    private Blatt blaetter[];
    private Muenze muenze[];
    private Frosch frosch;
    private Image gewonnen;
    private Image verloren;
    private Random wuerfel =  new Random();
    private Audio audio = new Audio();
    public Timer t;

    
    
    public Steuerung(GUI pFenster){
        this.muenze = new Muenze[10];
        this.blaetter = new Blatt[120];
        frosch = new Frosch(9,9);
        oberflaeche = pFenster; 
        audio.loadGameOver();
        audio.loadVictory();
        audio.loadSplash();
        audio.loadMuenze();
        try {
            verloren = ImageIO.read(new File("Picture"+File.separator+"Verloren.png"));
            gewonnen = ImageIO.read(new File("Picture"+File.separator+"Gewonnen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        t = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                treiben();
            }
        });
    }
    
    public void verteileTreibgut(){
        int x;
        int y;

        boolean belegt = false;
        muenze[0] = new Muenze(wuerfel.nextInt(20), wuerfel.nextInt(8)+1);
        for(int i = 1; i < muenze.length ; i++){
            do{
                x = wuerfel.nextInt(20);
                y = wuerfel.nextInt(8)+1;
                for(int k = 0; k < i-1; k++){
                    if(muenze[k].hatGleichesXY(x, y)){
                        belegt = true;
                        break;
                    }
                }
                belegt = false;
            }while(belegt);
            
            muenze[i] = new Muenze(x,y);
            belegt = false;
           
            
        }

       
        
        
        blaetter[0] = new Blatt(wuerfel.nextInt(20), wuerfel.nextInt(8)+1);
        for(int i = 1; i < blaetter.length ; i++){
            do{
                x = wuerfel.nextInt(20);
                y = wuerfel.nextInt(8)+1;
                for(int k = 0; k < i-1; k++){
                    
                    if(blaetter[k].hatGleichesXY(x, y)){
                        belegt = true;
                        break;
                    }
                }
                belegt = false;
            }while(belegt);
            
            blaetter[i] = new Blatt(x,y);
            belegt = false;

        }
        
      
       
        
    }
    
    public void treiben(){
        for (Blatt blaetter1 : blaetter) {
            blaetter1.treiben();
            
            
        }
        
        for (Muenze muenze1 : muenze) {
            if (!muenze1.getaGeholt()) {
                muenze1.treiben();
            }            
        }
        oberflaeche.repaint();
        
        bestimmeZustand(frosch.getaX(), frosch.getaY());
    }
    
    public void bestimmeZustand(int pX, int pY){
        
        boolean aufBlatt = false;
        boolean aufMuenze = false;        
        if(pY == 0 && getaMuenzzahl() == 10){            
            aZustand = 2;
            t.stop();
            audio.clipVictoryStart();
            frosch.aufStartPos();
            
        }
        
        if(pY == 0 && getaMuenzzahl() != 10){            
            aZustand = 1;
            audio.clipGameOverStart();
            t.stop();
            frosch.aufStartPos();
            
        }

        
        
        
        if(pY<9){
            for (Blatt blaetter1 : blaetter) {
                
                if(blaetter1.hatGleichesXY(pX, pY)){
                    aufBlatt = true;
                    break;
                }
            }
            
            for (Muenze muenze1 : muenze) {
            if (!muenze1.getaGeholt()) {
                if (muenze1.hatGleichesXY(pX, pY)) {                    
                    muenze1.holen();
                    audio.MuenzeReset();
                    audio.clipMuenzeStart();
                    aufMuenze = true;                   
                    aMuenzzahl++;
                    break;                   
                } 
            }
            
            
            }
            
            if(!aufMuenze && !aufBlatt && pY != 0){
                aVersuche--;
                frosch.aufStartPos();
                audio.SplashReset();
                audio.clipSplashStart();
            }
            
            if(getaVersuche() == 0){
                t.stop();
                audio.clipGameOverStart();
                frosch.aufStartPos();
                aZustand = 1;
            }
            
             
            
            
            
        }
                          
        
    }
    
    public void tasteGedrückt(java.awt.event.KeyEvent evt){
        frosch.springen(evt);       
        bestimmeZustand(frosch.getaX(), frosch.getaY());
        
        oberflaeche.repaint();
        
    }
    
    public void neuesSpiel(){
        t.stop();
        aZustand = 0;
        aMuenzzahl = 0;
        aVersuche = 3;
        verteileTreibgut();
        frosch.aufStartPos();
        frosch.reset();
        audio.clipReset();
        t.start();
        
    }
    
    
    
    
    
    
    

    
    public void zeichne(Graphics g, int breite, int hoehe){
        for (Blatt blaetter1 : blaetter) {
            blaetter1.zeichne(g,breite,hoehe);       
        }
        
        for (Muenze muenze1 : muenze) {
            if (!muenze1.getaGeholt()) {
                muenze1.zeichne(g,breite,hoehe); 
            }            
        }
        frosch.zeichne(g, breite, hoehe);
        
        switch(aZustand){
            case 1: g.drawImage(verloren,0, (hoehe*10)/3, breite*20, (hoehe*10)/3, null);
                    break;
            case 2: g.drawImage(gewonnen,0, (hoehe*10)/3, breite*20, (hoehe*10)/3, null);
                    break;
            default: break;        
        }
        
        
        oberflaeche.repaint();
    }

    /**
     * @return the aVersuche
     */
    public int getaVersuche() {
        return aVersuche;
    }

    /**
     * @return the aMuenzzahl
     */
    public int getaMuenzzahl() {
        return aMuenzzahl;
    }
    

    
}
