package Dominio;

public class Habitacion {
    private int IdHabitacion;
    private int capacidad;
    private boolean matrimonial;
    private boolean aireAcondicionado;
    private boolean balcon;
    private boolean vista;
    private String amenities;
    private boolean disponible;

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int IdHabitacion) {
        this.IdHabitacion = IdHabitacion;
    }

    public boolean isMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(boolean matrimonial) {
        this.matrimonial = matrimonial;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public boolean isVista() {
        return vista;
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Habitacion(int idHabitacion, int capacidad, boolean matrimonial, boolean aireAcondicionado, boolean balcon, boolean vista, String amenities, boolean disponible) {
        this.IdHabitacion = idHabitacion;
        this.capacidad = capacidad;
        this.matrimonial = matrimonial;
        this.aireAcondicionado = aireAcondicionado;
        this.balcon = balcon;
        this.vista = vista;
        this.amenities = amenities;
        this.disponible = disponible;
    }

}
