/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon.Spittel
 */
public class Bilder {

    /**
     * @return the wiese
     */
    public Image getWiese() {
        return wiese;
    }
    private Image wasser;
    private Image frosch;
    private Image schwimmElement;
    private Image muenze;
    private Image wiese;
    
    
    public void loadWasser(){
        try {
            wasser = ImageIO.read(new File("Picture"+File.separator+"Wasser.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void loadFrosch(){
        try {
            frosch = ImageIO.read(new File("Picture"+File.separator+"Frosch.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadSchwimmElement(){
        try {
            schwimmElement = ImageIO.read(new File("Picture"+File.separator+"SchwimmElement.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadMuenze(){
        try {
            muenze = ImageIO.read(new File("Picture"+File.separator+"Muenze.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadWiese(){
        try {
            wiese = ImageIO.read(new File("Picture"+File.separator+"Wiese.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the wasser
     */
    public Image getWasser() {
        return wasser;
    }

    /**
     * @return the frosch
     */
    public Image getFrosch() {
        return frosch;
    }

    /**
     * @return the schwimmElement
     */
    public Image getSchwimmElement() {
        return schwimmElement;
    }

    /**
     * @return the muenze
     */
    public Image getMuenze() {
        return muenze;
    }
}
