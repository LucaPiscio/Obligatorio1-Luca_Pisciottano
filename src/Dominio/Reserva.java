package Dominio;

import java.time.LocalDate;

public class Reserva {
    private int IdReserva;
    private int IdHabitacion;
    private int IdHotel;
    private int IdHuesped;
    private double Monto;
    private LocalDate Fentrada;
    private LocalDate Fsalida;

    public Reserva(int idReserva, int idHabitacion, int idHotel, int idHuesped, double monto, LocalDate fentrada, LocalDate fsalida) {
        IdReserva = idReserva;
        IdHabitacion = idHabitacion;
        IdHotel = idHotel;
        IdHuesped = idHuesped;
        Monto = monto;
        Fentrada = fentrada;
        Fsalida = fsalida;
    }




    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int idReserva) {
        IdReserva = idReserva;
    }

    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        IdHabitacion = idHabitacion;
    }

    public int getIdHotel() {
        return IdHotel;
    }

    public void setIdHotel(int idHotel) {
        IdHotel = idHotel;
    }

    public int getIdHuesped() {
        return IdHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        IdHuesped = idHuesped;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        this.Monto = monto;
    }

    public LocalDate getFentrada() {
        return Fentrada;
    }

    public void setFentrada(LocalDate fentrada) {
        Fentrada = fentrada;
    }

    public LocalDate getFsalida() {
        return Fsalida;
    }

    public void setFsalida(LocalDate fsalida) {
        Fsalida = fsalida;
    }



}
