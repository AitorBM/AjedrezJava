/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Aitor
 */
public class PanelTablero extends javax.swing.JPanel {

    String Rutafondo;
    /**
     * Creates new form PanelTablero
     */
    public PanelTablero(int n) {
        initComponents();
        //Le indico el tamaño del tablero
        this.setSize(800, 800);
        switch (n) {
            case 0:
                Rutafondo = "./imagenes/Tableros/TableroAzul.png";
            break;
            case 1:
                Rutafondo = "./imagenes/Tableros/Fieltro.png";
            break;
            case 2:
                Rutafondo = "./imagenes/Tableros/Madera.png";
            break;
            case 3:
                Rutafondo = "./imagenes/Tableros/Marmol.png";
                break;
            default:
                Rutafondo = "./imagenes/Tableros/TableroAzul.png";
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        //Cojo el tamaño del tablero para generar las dimensiones
        Dimension tamano = getSize();
        //Creo la imagen del tablero
        ImageIcon fondo = new ImageIcon(getClass().getResource(Rutafondo));
        //La pinto
        g.drawImage(fondo.getImage(), 0,0, tamano.width, tamano.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
