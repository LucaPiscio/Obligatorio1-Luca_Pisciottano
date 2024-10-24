package Dominio;


public class Hotel {
    private int idHotel;
    private String nombre;
    private String ciudad;
    private String pais;
    private int estrellas;
    private String direccion;
    private int IdHabitacion;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        IdHabitacion = idHabitacion;
    }

    public Hotel(int idHotel, String nombre, String ciudad, String pais, int estrellas, String direccion, int idHabitacion) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estrellas = estrellas;
        this.direccion = direccion;
        this.IdHabitacion = idHabitacion;
    }


}
