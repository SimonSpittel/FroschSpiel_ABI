/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froschspiel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Simon
 */
public class GUI extends javax.swing.JPanel {

    private Steuerung steuerung;
    private Anzeige anzeige;
    private Bilder bild = new Bilder();
    
    private int breite;
    private int hoehe;
    
    public GUI() {
        initComponents();
        setFocusable(true);
        requestFocus();
        bild.loadWasser();
        bild.loadWiese();
    }

    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bild.getWasser(), 0, 0, getWidth(), getHeight(), null);
        requestFocus();
        anzeige.repaint();
        breite = getWidth()/20;
        hoehe = getHeight()/11;
        g.drawImage(bild.getWiese(), 0, 0, getWidth(), hoehe, null);
        g.drawImage(bild.getWiese(), 0, hoehe*9, getWidth(), hoehe*3, null);
        getSteuerung().zeichne(g, breite, hoehe);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(64, 64, 244));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
       steuerung.tasteGedrückt(evt);
    }//GEN-LAST:event_formKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    /**
     * @param steuerung the steuerung to set
     */
    public void setSteuerung(Steuerung steuerung) {
        this.steuerung = steuerung;
    }

    /**
     * @param anzeige the anzeige to set
     */
    public void setAnzeige(Anzeige anzeige) {
        this.anzeige = anzeige;
    }

    /**
     * @return the steuerung
     */
    public Steuerung getSteuerung() {
        return steuerung;
    }
}