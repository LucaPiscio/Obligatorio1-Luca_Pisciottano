import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import Dominio.Hotel;
import Dominio.Reserva;
import Persistencia.PHotel;
import Persistencia.PReserva;

public class ControladoraFiltro {
    private static Scanner escaner = new Scanner(System.in);

    public static void BusquedaNombre() {
        List<Hotel> listarHotel = PHotel.listarHotel();
        System.out.println("Ingrese nombre del hotel a buscar:");
        String nombreH = escaner.nextLine();

        for (Hotel hotel : listarHotel) {
            if (hotel.getNombre().equals(nombreH)) {
                System.out.println("Hotel encontrado: " + hotel.getNombre() + ", Ciudad: " + hotel.getCiudad() +
                        ", País: " + hotel.getPais() + ", Estrellas: " + hotel.getEstrellas() +
                        ", Dirección: " + hotel.getDireccion());
            }
        }

    }

    public static void BusquedaCiudad() {
        List<Hotel> listarHotel = PHotel.listarHotel();
        System.out.println("Ingrese la ciudad del hotel a buscar:");
        String ciudadH = escaner.nextLine();

        for (Hotel hotel : listarHotel) {
            if (hotel.getCiudad().equals(ciudadH)) {
                System.out.println("Hotel encontrado: " + hotel.getNombre() + ", Ciudad: " + hotel.getCiudad() +
                        ", País: " + hotel.getPais() + ", Estrellas: " + hotel.getEstrellas() +
                        ", Dirección: " + hotel.getDireccion());
            }
        }

    }

    public static void BusquedaEstrella() {
        List<Hotel> listarHotel = PHotel.listarHotel();
        System.out.println("Ingrese cantidad de estrellas del hotel a buscar:");
        int estrellasH = Integer.parseInt(escaner.nextLine());

        for (Hotel hotel : listarHotel) {
            if (hotel.getEstrellas()==(estrellasH)) {
                System.out.println("Hotel encontrado: " + hotel.getNombre() + ", Ciudad: " + hotel.getCiudad() +
                        ", País: " + hotel.getPais() + ", Estrellas: " + hotel.getEstrellas() +
                        ", Dirección: " + hotel.getDireccion());
            }
        }

    }

    public static void reservadas() {
        List<Reserva> listarReserva = PReserva.listarReservas();
        System.out.println("Ingrese la fecha de Entrada :");
        LocalDate Fentrada = LocalDate.parse(escaner.nextLine());
        System.out.println("Ingrese la fecha de salida :");
        LocalDate Fsalida = LocalDate.parse(escaner.nextLine());

        boolean reservada = false;

        for (Reserva reserva : listarReserva) {
            if (reserva.getFentrada().equals(Fentrada) && reserva.getFsalida().equals(Fsalida)) {
                reservada = true;
                break;
            }
        }


        if (reservada) {
            System.out.println("La habitación está reservada para esa fecha.");
        } else {
            System.out.println("Para esa fecha, la habitación está libre.");
        }
    }

    }

