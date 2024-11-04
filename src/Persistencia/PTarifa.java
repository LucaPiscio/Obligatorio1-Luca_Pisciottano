package Persistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import Dominio.Tarifa;

public class PTarifa {
    private static Conexion conexion = new Conexion();

    public static boolean agregarTarifa(Tarifa tarifa) {
        String sql = "INSERT INTO tarifas(IdTarifa, Finicio, Ffin, monto) VALUES(?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(List.of(
                tarifa.getIdTarifa(),
                tarifa.getFinicio(),
                tarifa.getFfin(),
                tarifa.getMonto()
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

    public static boolean eliminarTarifa(int idTarifa) {
        String sql = "DELETE FROM tarifas WHERE IdTarifa=?";
        ArrayList<Object> parametros = new ArrayList<>(List.of(idTarifa));

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

    public static boolean modificarTarifa(Tarifa t) {
        String sql = "UPDATE tarifas SET Finicio=?, Ffin=?, monto=? WHERE IdTarifa=?";
        ArrayList<Object> parametros = new ArrayList<>(List.of(
                t.getFinicio(),
                t.getFfin(),
                t.getMonto(),
                t.getIdTarifa()
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

    public static Tarifa conseguirTarifa(int idTarifa) {
        String sql = "SELECT IdTarifa, Finicio, Ffin, monto FROM tarifas WHERE IdTarifa=?";
        ArrayList<Object> parametros = new ArrayList<>(List.of(idTarifa));

        try {
            List<List<Object>> resultado = conexion.seleccion(sql, parametros);
            if (!resultado.isEmpty()) {
                System.out.println("Se encontró la tarifa");
                int IdTarifa = (int) resultado.get(0).get(0);
                LocalDate Finicio = (LocalDate) resultado.get(0).get(1);
                LocalDate Ffin = (LocalDate) resultado.get(0).get(2);
                double monto = (double) resultado.get(0).get(3);
                return new Tarifa(IdTarifa, Finicio, Ffin, monto);
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }
        return null;
    }

    public static ArrayList<Tarifa> listarTarifas() {
        String sql = "SELECT * FROM tarifas";
        ArrayList<Tarifa> tarifas = new ArrayList<>();

        try {
            List<List<Object>> registros = conexion.seleccion(sql, null);
            if (!registros.isEmpty()) {
                System.out.println("Se realizó la consulta con éxito");
                for (List<Object> registro : registros) {
                    int IdTarifa = (int) registro.get(0);
                    LocalDate Finicio = (LocalDate) registro.get(1);
                    LocalDate Ffin = (LocalDate) registro.get(2);
                    double monto = (double) registro.get(3);
                    tarifas.add(new Tarifa(IdTarifa, Finicio, Ffin, monto));
                }
            }
        } catch (AppSQLException ase) {
            System.out.println(ase.getMessage());
        }

        return tarifas;
    }
}
