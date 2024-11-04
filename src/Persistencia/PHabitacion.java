package Persistencia;

import Dominio.Habitacion;
import Dominio.Huesped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHabitacion {
    private static Conexion conexion = new Conexion();
    public static boolean agregarHabitacion(Habitacion pHabitacion){
        String sql = "INSERT INTO habitaciones(IdHabitacion,capacidad,matrimonial,aireAcondicionado,balcon,vista,amenities,disponible) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "UPDATE habitaciones SET capacidad=?, matrimonial=?, aireAcondicionado=? ,  balcon=?, vista=? , ameneties=?, disponible=? WHERE IdHabitacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(ha.getCapacidad(), ha.isMatrimonial(), ha.isAireAcondicionado(), ha.isBalcon(), ha.isVista(), ha.getAmenities(), ha.isDisponible()));

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

    public static Habitacion conseguirHabitacion(int pIdHabitacion){
        String sql = "SELECT IdHabitacion,capacidad,matrimonial,balcon,vista,amenities,disponible from habitaciones WHERE IdHabitacion=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHabitacion));


        try{
            List<List<Object>> resultado =conexion.seleccion(sql, parametros);
            if(!resultado.isEmpty()){
                System.out.println("Se encontro esta habitacion");
                int IdHabitacion = (int) resultado.get(0).get(0);
                int capacidad = (int) resultado.get(0).get(1);
                boolean matrimonial =(boolean) resultado.get(0).get(2);
                boolean aireAcondicionado =(boolean) resultado.get(0).get(3);
                boolean balcon = (boolean) resultado.get(0).get(4);
                boolean vista = (boolean)resultado.get(0).get(5);
                String amenities = String.valueOf(resultado.get(0).get(6));
                boolean disponible = (boolean)resultado.get(0).get(7);
                return new Habitacion(IdHabitacion,capacidad,matrimonial,aireAcondicionado,balcon,vista,amenities,disponible);
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }
        return null;

    }

    public static ArrayList<Habitacion> listarHabitacion(){
        String sql = "SELECT * FROM habitaciones";
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        try{
            List<List<Object>> registros = conexion.seleccion(sql, null);
            if(!registros.isEmpty()){
                System.out.println("Se realizó la modificacion con éxito");
                for(List<Object> registro : registros){
                    int IdHabitacion = (int) registro.get(0);
                    int capacidad = (int) registro.get(1);
                    boolean matrimonial =(boolean) registro.get(2);
                    boolean aireAcondicionado =(boolean) registro.get(3);
                    boolean balcon = (boolean) registro.get(4);
                    boolean vista = (boolean)registro.get(5);
                    String amenities = String.valueOf(registro.get(6));
                    boolean disponible = (boolean)registro.get(7);

                    habitaciones.add(new Habitacion(IdHabitacion,capacidad,matrimonial,aireAcondicionado,balcon,vista,amenities,disponible));
                }
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }

        return habitaciones;

    }
}
