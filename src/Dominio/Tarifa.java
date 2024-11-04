package Dominio;
import java.time.LocalDate;

public class Tarifa {
    private int IdTarifa;
    private LocalDate Finicio;
    private LocalDate Ffin;
    private double monto;


    public int getIdTarifa() {
        return IdTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        IdTarifa = idTarifa;
    }

    public LocalDate getFinicio() {
        return Finicio;
    }

    public void setFinicio(LocalDate finicio) {
        Finicio = finicio;
    }

    public LocalDate getFfin() {
        return Ffin;
    }

    public void setFfin(LocalDate ffin) {
        Ffin = ffin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Tarifa(int idTarifa, LocalDate finicio, LocalDate ffin, double monto) {
        IdTarifa = idTarifa;
        Finicio = finicio;
        Ffin = ffin;
        this.monto = monto;
    }


}
