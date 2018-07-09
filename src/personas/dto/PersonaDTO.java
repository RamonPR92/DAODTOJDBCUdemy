/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.dto;

/**
 *
 * @author rperez
 */
public class PersonaDTO {
    
    public PersonaDTO(){
    }
    
    public PersonaDTO(int id){
        this.id = id;
    }
    
    private int id;
    private String nombre;
    private String apellido;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apeelido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apeelido the apeelido to set
     */
    public void setApellido(String apeelido) {
        this.apellido = apeelido;
    }
    
    @Override
    public String toString(){
        return "Persona: \n"
                +   "Id: " + this.id + "\n"
                +   "Nombre: " + this.nombre + "\n"
                +   "Apellido " + this.apellido;
    }
}
