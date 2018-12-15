/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Simon.Spittel
 */
public class Audio {
    private File soundJump;
    private File soundTod;
    private File soundVictory;
    private File soundGameOver;
    private File soundMuenze;
    private AudioInputStream sound_Jump;
    private AudioInputStream sound_Tod;
    private AudioInputStream sound_Victory;
    private AudioInputStream sound_GameOver;
    private AudioInputStream sound_Muenze;
    private Clip clipJump;
    private Clip clipTod;
    private Clip clipVictory;
    private Clip clipGameOver;
    private Clip clipMuenze;
    private DataLine.Info infoJump;
    private DataLine.Info infoTod;
    private DataLine.Info infoVictory;
    private DataLine.Info infoGameOver;
    private DataLine.Info infoMuenze;
    
    public Audio(){

    }
    
    
    public void clipJumpStart(){
        clipJump.start();
    }
    public void clipSplashStart(){
        clipTod.start();
    }
    public void clipVictoryStart(){
        clipVictory.start();
    }
    
    public void clipGameOverStart(){
        clipGameOver.start();
    }
    
    public void clipMuenzeStart(){
        clipMuenze.start();
    }
    
    public void MuenzeReset(){
        clipMuenze.stop();
        clipMuenze.setMicrosecondPosition(0);
    }
    

    public void JumpReset(){
        clipJump.stop();
        clipJump.setMicrosecondPosition(0);
    }
    
    public void SplashReset(){
        clipTod.stop();
        clipTod.setMicrosecondPosition(0);
    }

    
    public void clipReset(){
        
        clipGameOver.stop();
        clipVictory.stop();
        
        clipGameOver.setMicrosecondPosition(0);
        clipVictory.setMicrosecondPosition(0);
       
    }
    
    public void loadGameOver(){
     soundGameOver = new File("Sounds"+File.separator+"GameOver.wav");  
     
        try {
            sound_GameOver = AudioSystem.getAudioInputStream(soundGameOver);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     try {
            infoGameOver = new DataLine.Info(Clip.class, sound_GameOver.getFormat());
            clipGameOver = (Clip) AudioSystem.getLine(infoGameOver);
            try {
                clipGameOver.open(sound_GameOver);
            } catch (IOException ex) {
                Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadJump(){
        soundJump = new File("Sounds"+File.separator+"Jump.wav");
        try {
            sound_Jump = AudioSystem.getAudioInputStream(soundJump);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            infoJump = new DataLine.Info(Clip.class, sound_Jump.getFormat());
            clipJump = (Clip) AudioSystem.getLine(infoJump);
            try {
                clipJump.open(sound_Jump);
            } catch (IOException ex) {
                Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadSplash(){
        soundTod = new File("Sounds"+File.separator+"Splash.wav");
        try {
            sound_Tod = AudioSystem.getAudioInputStream(soundTod);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            infoTod = new DataLine.Info(Clip.class, sound_Tod.getFormat());
            clipTod = (Clip) AudioSystem.getLine(infoTod);
            try {
                clipTod.open(sound_Tod);
            } catch (IOException ex) {
                Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadVictory(){
        soundVictory = new File("Sounds"+File.separator+"Victory.wav");
        try {
            sound_Victory = AudioSystem.getAudioInputStream(soundVictory);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            infoVictory = new DataLine.Info(Clip.class, sound_Victory.getFormat());
            clipVictory = (Clip) AudioSystem.getLine(infoVictory);
            try {
                clipVictory.open(sound_Victory);
            } catch (IOException ex) {
                Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadMuenze(){
        soundMuenze = new File("Sounds"+File.separator+"Muenze.wav");
        try {
            sound_Muenze = AudioSystem.getAudioInputStream(soundMuenze);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            infoMuenze = new DataLine.Info(Clip.class, sound_Muenze.getFormat());
            clipMuenze = (Clip) AudioSystem.getLine(infoMuenze);
            try {
                clipMuenze.open(sound_Muenze);
            } catch (IOException ex) {
                Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


   
