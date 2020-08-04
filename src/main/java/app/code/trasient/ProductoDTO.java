package app.code.trasient;

import java.io.Serializable;


public class ProductoDTO implements Serializable {

    private long id;

    private String codigo;

    private String nombre;

    private int stock;
        
    public ProductoDTO(){
    }

    public ProductoDTO(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "COD: " + this.codigo + " NOM:" + this.nombre + " STODK: "+ this.stock; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
