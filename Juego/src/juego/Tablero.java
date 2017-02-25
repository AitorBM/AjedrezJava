/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.*;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Aitor
 */
public class Tablero extends javax.swing.JFrame implements MouseListener{

    Pieza p;
    Pieza[][] tablero;
    PanelTablero Ptablero;
    JButton b;
    int fondo = 0;
    int selectX;
    int selectY;
    
    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        //Pongo el tamaño de la ventana
        this.setSize(new Dimension(805, 829));
        this.setMinimumSize(new Dimension(800, 800));
        this.setPreferredSize(new Dimension(800, 800));
        //Creo el tablero y lo añado a la ventana
        Ptablero = new PanelTablero(0);
        
        rellenarTablero();
        
        this.add( Ptablero, BorderLayout.CENTER);
        Ptablero.repaint();
        //Creo el tablero y las piezas
        
        leerTablero();
    }

    public void rellenarTablero(){
        boolean blanca = false;
        tablero = new Pieza[8][8];
        
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((y==0||y==7)&&(x==0||x==7)) {
                    p = new Pieza(x, y, "Torre");
                    p.setPosicion();
                    tablero[x][y] = p;
                    if (y==7) {
                        blanca = true;
                    }
                    anadirBoton(x, y, p.nombre, blanca);
                }
                if (y==1||y==6) {
                    p = new Pieza(x, y, "Peón");
                    p.setPosicion();
                    tablero[x][y] = p;
                    if (y==6) {
                        blanca = true;
                    }
                    anadirBoton(x, y, p.nombre, blanca);
                }
                if ((y==0||y==7)&&(x==1||x==6)) {
                    p = new Pieza(x, y, "Caballo");
                    p.setPosicion();
                    tablero[x][y] = p;
                    if (y==7) {
                        blanca = true;
                    }
                    anadirBoton(x, y, p.nombre, blanca);
                }
                if ((y==0||y==7)&&(x==2||x==5)) {
                    p = new Pieza(x, y, "Alfil");
                    p.setPosicion();
                    tablero[x][y] = p;
                    if (y==7) {
                        blanca = true;
                    }
                    anadirBoton(x, y, p.nombre, blanca);
                }
                if ((y==0||y==7)&&(x==3)) {
                    p = new Pieza(x, y, "Dama");
                    p.setPosicion();
                    tablero[x][y] = p;
                    if (y==7) {
                        blanca = true;
                    }
                    anadirBoton(x, y, p.nombre, blanca);
                }
                if ((y==0||y==7)&&(x==4)) {
                    p = new Pieza(x, y, "Rey");
                    p.setPosicion();
                    tablero[x][y] = p;
                    if (y==7) {
                        blanca = true;
                    }
                    anadirBoton(x, y, p.nombre, blanca);
                }
                if (tablero[x][y] == null) {
                    anadirBoton(x, y, "", blanca);
                }
            }
        }
    }
    
    public void leerTablero(){
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (tablero[x][y] != null) {
                    System.out.println("x:"+tablero[x][y].getX()+", y:"+tablero[x][y].getY()+" ("+tablero[x][y].getPosicion()+")"+", "+tablero[x][y].getNombre());
                } else {
                    System.out.println("Casilla vacía.");
                }
                
            }
        }
    }
    
    public void moverPieza(int xOrigen, int yOrigen, int xDestino, int yDestino){
        p = tablero[xOrigen][yOrigen];
        p.setX(xDestino);
        p.setY(yDestino);
        p.setPosicion();
        tablero[xOrigen][yOrigen] = null;
        tablero[xDestino][yDestino] = p;
    }
    
    public void anadirBoton(int x, int y, String texto, boolean blanca){
        ImageIcon imagen = new ImageIcon();
        b = new JButton();
                    b.setBounds(x*100, y*100, 100, 100);
                    b.setText(texto);
                    switch (texto) {
                        case "Peón":
                            if (blanca) {
                                tablero[x][y].nombre += " Blanco";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/PeonB.png"));
                            } else {
                                tablero[x][y].nombre += " Negro";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/PeonN.png"));
                            }
                            break;
                        case "Torre":
                            if (blanca) {
                                tablero[x][y].nombre += " Blanca";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/TorreB.png"));
                            } else {
                                tablero[x][y].nombre += " Negra";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/TorreN.png"));
                            }
                            break;
                        case "Caballo":
                            if (blanca) {
                                tablero[x][y].nombre += " Blanco";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/CaballoB.png"));
                            } else {
                                tablero[x][y].nombre += " Negro";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/CaballoN.png"));
                            }
                            break;
                        case "Alfil":
                            if (blanca) {
                                tablero[x][y].nombre += " Blanco";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/AlfilB.png"));
                            } else {
                                tablero[x][y].nombre += " Negro";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/AlfilN.png"));
                            }
                            break;
                        case "Dama":
                            if (blanca) {
                                tablero[x][y].nombre += " Blanca";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/DamaB.png"));
                            } else {
                                tablero[x][y].nombre += " Negra";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/DamaN.png"));
                            }
                            break;
                        case "Rey":
                            if (blanca) {
                                tablero[x][y].nombre += " Blanco";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/ReyB.png"));
                            } else {
                                tablero[x][y].nombre += " Negro";
                                imagen = new ImageIcon(getClass().getResource("./imagenes/Piezas/ReyN.png"));
                            }
                            break;
                        default:
                            
                    }
                    b.setIcon(imagen);
                    b.setContentAreaFilled(false);
                    b.addMouseListener(this);
                    add(b);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajedrez");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        selectX = e.getComponent().getLocation().x/100;
        selectY = e.getComponent().getLocation().y/100;
        System.out.println("Click en la casilla:"+" x "+selectX+", y "+selectY);
        if (e.getButton() == BUTTON3) {
            this.remove(Ptablero);
            Random r = new Random();
            fondo = r.nextInt(4);
            Ptablero = new PanelTablero(fondo);
            this.add( Ptablero, BorderLayout.CENTER);
            Ptablero.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
