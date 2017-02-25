/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Aitor
 */
public class Pieza {
    int x;
    int y;
    String nombre;
    String posicion;

    public Pieza(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }

    public void moverA(int xNueva, int yNueva){
        this.x = xNueva;
        this.y = yNueva;
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion() {
        switch (x) {
            case 0:
                this.posicion = "A"+(y+1);
                break;
            case 1:
                this.posicion = "B"+(y+1);
                break;
            case 2:
                this.posicion = "C"+(y+1);
            break;
            case 3:
                this.posicion = "D"+(y+1);
            break;
            case 4:
                this.posicion = "E"+(y+1);
            break;
            case 5:
                this.posicion = "F"+(y+1);
            break;
            case 6:
                this.posicion = "G"+(y+1);
            break;
            case 7:
                this.posicion = "H"+(y+1);
            break;
            default:
        }
    }
}