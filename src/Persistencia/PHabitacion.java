package Persistencia;

import Dominio.Habitacion;
import Dominio.Huesped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHabitacion {
    private static Conexion conexion = new Conexion();
    public static boolean agregarHabitacion(Habitacion pHabitacion){
        String sql = "INSERT INTO habitaciones(IdHabitacion,capacidad,matrimonial,balcon,vista,ameneties,disponible) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pHabitacion.getIdHabitacion(), pHabitacion.getCapacidad(), pHabitacion.isMatrimonial(), pHabitacion.isAireAcondicionado(), pHabitacion.isBalcon(), pHabitacion.isVista(),pHabitacion.getAmenities(),pHabitacion.isDisponible()));

        try{
            if(conexion.consulta(sql, parametros)){
                System.out.println("Se realizó el agregado con éxito");
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }
        return false;

    }
    public static boolean eliminarHabitacion(int pCi){
        String sql = "DELETE FROM habitaciones WHERE IdHabitacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pCi));

        try{
            if(conexion.consulta(sql, parametros)){
                System.out.println("Se realizó la eliminacion con éxito");
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }
        return false;
    }

    public static boolean modificarHabitacion(Habitacion ha){
        String sql = "UPDATE habitaciones SET capacidad=?, matrimonial=?, balcon=?, vista=? , ameneties=?, disponible=? WHERE Idhabiotacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(ha.getCapacidad(), ha.isMatrimonial(), ha.isBalcon(), ha.isVista(), ha.getAmenities(), ha.isDisponible()));

        try{
            if(conexion.consulta(sql, parametros)){
                System.out.println("Se realizó la modificacion con éxito");
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }
        return false;
    }

    public static Huesped conseguirHabitacion(int pIdHabitacion){
        String sql = "SELECT IdHabitacion,capacidad,matrimonial,balcon,vista,ameneties,disponible WHERE IdHabitacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHabitacion));

        List<List<Object>> resultado =conexion.seleccion(sql, parametros);

        int IdHuesped = (int) resultado.get(0).get(0);
        String Nombre = String.valueOf(resultado.get(0).get(1));
        String pApellido = String.valueOf(resultado.get(0).get(2));
        String mApellido = String.valueOf(resultado.get(0).get(3));
        String TipoDoc = String.valueOf(resultado.get(0).get(4));
        int Ci = (int) resultado.get(0).get(5);
        String Fnac = String.valueOf(resultado.get(0).get(6));
        int Tel = (int) resultado.get(0).get(7);
        String Pais = String.valueOf(resultado.get(0).get(8));


        return new Huesped(IdHuesped,Nombre,pApellido,mApellido,TipoDoc,Ci,Fnac,Tel,Pais);

    }

    public static ArrayList<Huesped> listarHuespedes(){
        String sql = "SELECT * FROM huespedes";
        List<List<Object>> registros = conexion.seleccion(sql, null);
        ArrayList<Huesped> huespedes = new ArrayList<>();

        for(List<Object> registro : registros){
            int IdHuesped = (int) registro.get(0);
            String Nombre = String.valueOf(registro.get(1));
            String pApellido = String.valueOf(registro.get(2));
            String mApellido = String.valueOf(registro.get(3));
            String TipoDoc = String.valueOf(registro.get(4));
            int Ci = (int) registro.get(5);
            String Fnac = String.valueOf(registro.get(6));
            int Tel = (int) registro.get(7);
            String Pais = String.valueOf(registro.get(8));

            huespedes.add(new Huesped(IdHuesped,Nombre,pApellido,mApellido,TipoDoc,Ci,Fnac,Tel,Pais));
        }
        return huespedes;

    }
}
