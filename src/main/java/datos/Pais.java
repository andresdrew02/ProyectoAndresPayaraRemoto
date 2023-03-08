/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author andres
 */
public class Pais {
    private String name;
    private String continent;
    private int poblation;
    private int indpyear;

    public Pais(String name, String continent, int poblation, int indpyear) {
        this.name = name;
        this.continent = continent;
        this.poblation = poblation;
        this.indpyear = indpyear;
    }
    
    public Pais(){
      
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPoblation() {
        return poblation;
    }

    public void setPoblaton(int poblation) {
        this.poblation = poblation;
    }
    
    public int getIndpyear() {
        return indpyear;
    }

    public void setIndpyear(int indpyear) {
        this.indpyear = indpyear;
    }
    
}
