package model;

import jakarta.persistence.*;

@Entity
@Table(name= "usuarioAdmin")
@NamedQueries({
        @NamedQuery(name= "UsuarioAdministrativo.findAll",
                    query= "Select u FROM UsuarioAdministrativo u")
})
public class UsuarioAdministrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "id_seq")
    @SequenceGenerator(name= "id_seq", sequenceName= "adminID_SEQ", allocationSize= 1)
    private int id;

    private String nombre;
    private String apellido;
    private Boolean activo=true;

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "UsuarioAdministrativo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", activo=" + activo +
                '}';
    }
}
