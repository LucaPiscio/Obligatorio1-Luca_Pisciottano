package Persistencia;
import Dominio.Reserva;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PReserva {
    private static Conexion conexion = new Conexion();

    public static boolean agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas(IdReserva, IdHabitacion, IdHotel, IdHuesped, Monto, Fentrada, Fsalida) VALUES(?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                reserva.getIdReserva(),
                reserva.getIdHabitacion(),
                reserva.getIdHotel(),
                reserva.getIdHuesped(),
                reserva.getMonto(),
                reserva.getFentrada(),
                reserva.getFsalida()
        ));

        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se realizó el agregado con éxito");
                return true;
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }
        return false;
    }

    public static boolean eliminarReserva(int idReserva) {
        String sql = "DELETE FROM reservas WHERE IdReserva=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(idReserva));

        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se realizó la eliminación con éxito");
                return true;
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }
        return false;
    }

    public static boolean modificarReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET IdHabitacion=?, IdHotel=?, IdHuesped=?, Monto=?, Fentrada=?, Fsalida=? WHERE IdReserva=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                reserva.getIdHabitacion(),
                reserva.getIdHotel(),
                reserva.getIdHuesped(),
                reserva.getMonto(),
                reserva.getFentrada(),
                reserva.getFsalida(),
                reserva.getIdReserva()
        ));

        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se realizó la modificación con éxito");
                return true;
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }
        return false;
    }

    public static Reserva conseguirReserva(int idReserva) {
        String sql = "SELECT IdReserva, IdHabitacion, IdHotel, IdHuesped, Monto, Fentrada, Fsalida FROM reservas WHERE IdReserva=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(idReserva));

        try {
            List<List<Object>> resultado = conexion.seleccion(sql, parametros);
            if (!resultado.isEmpty()) {
                System.out.println("Se encontró la reserva");
                int IdReserva = (int) resultado.get(0).get(0);
                int IdHabitacion = (int) resultado.get(0).get(1);
                int IdHotel = (int) resultado.get(0).get(2);
                int IdHuesped = (int) resultado.get(0).get(3);
                double Monto = (double) resultado.get(0).get(4);
                LocalDate Fentrada = (LocalDate) resultado.get(0).get(5);
                LocalDate Fsalida = (LocalDate) resultado.get(0).get(6);
                return new Reserva(IdReserva, IdHabitacion, IdHotel, IdHuesped, Monto, Fentrada, Fsalida);
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }
        return null;
    }

    public static ArrayList<Reserva> listarReservas() {
        String sql = "SELECT * FROM reservas";
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            List<List<Object>> registros = conexion.seleccion(sql, null);
            if (!registros.isEmpty()) {
                System.out.println("Se obtuvieron las reservas");
                for (List<Object> registro : registros) {
                    int IdReserva = (int) registro.get(0);
                    int IdHabitacion = (int) registro.get(1);
                    int IdHotel = (int) registro.get(2);
                    int IdHuesped = (int) registro.get(3);
                    double Monto = (double) registro.get(4);
                    LocalDate Fentrada = (LocalDate) registro.get(5);
                    LocalDate Fsalida = (LocalDate) registro.get(6);

                    reservas.add(new Reserva(IdReserva, IdHabitacion, IdHotel, IdHuesped, Monto, Fentrada, Fsalida));
                }
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }

        return reservas;
    }
}
