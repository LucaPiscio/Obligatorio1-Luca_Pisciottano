package Persistencia;

import Dominio.Hotel;
import Dominio.Huesped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHotel {
    private static Conexion conexion = new Conexion();
    public static boolean agregarHotel(Hotel pHotel){
        String sql = "INSERT INTO hoteles(IdHotel,nombre,ciudad,pais,estrellas,direccion,IdHabitacion) VALUES(?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pHotel.getIdHotel(), pHotel.getNombre(), pHotel.getCiudad(), pHotel.getPais(), pHotel.getEstrellas(), pHotel.getDireccion(),pHotel.getIdHabitacion()));

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
    public static boolean eliminarHotel(int pIdHotel){
        String sql = "DELETE FROM hoteles WHERE IdHotel=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHotel));

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

    public static boolean modificarHotel(Hotel ho){
        String sql = "UPDATE hoteles SET nombre=?, ciudad=?, pais=?, estrellas=? , direccion=?, IdHabitacion=? WHERE IdHuesped=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(ho.getNombre(), ho.getCiudad(), ho.getPais(), ho.getEstrellas(), ho.getDireccion(), ho.getIdHabitacion(),ho.getIdHotel()));

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

    public static Hotel conseguirHotel(int pIdHotel){
        String sql = "SELECT IdHotel,nombre,ciudad,pais,estrellas,direccion,IdHabitacion WHERE IdHotel=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pIdHotel));


        try{
            List<List<Object>> resultado =conexion.seleccion(sql, parametros);
            if(!resultado.isEmpty()){
                System.out.println("Se encontro este hotel");
                int IdHotel = (int) resultado.get(0).get(0);
                String nombre = String.valueOf(resultado.get(0).get(1));
                String ciudad = String.valueOf(resultado.get(0).get(2));
                String pais = String.valueOf(resultado.get(0).get(3));
                int estrellas = (int) resultado.get(0).get(4);
                String direccion = String.valueOf(resultado.get(0).get(5));
                int IdHabitacion = (int) resultado.get(0).get(6);
                return new Hotel(IdHotel,nombre,ciudad,pais,estrellas,direccion,IdHabitacion);
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }
        return null;



    }

    public static ArrayList<Hotel> listarHotel(){
        String sql = "SELECT * FROM hoteles";
        ArrayList<Hotel> hoteles = new ArrayList<>();

        try{
            List<List<Object>> registros = conexion.seleccion(sql, null);
            if(!registros.isEmpty()){
                System.out.println("Se realizó la modificacion con éxito");
                for(List<Object> registro : registros){
                    int IdHotel = (int) registro.get(0);
                    String nombre = String.valueOf(registro.get(1));
                    String ciudad = String.valueOf(registro.get(2));
                    String pais = String.valueOf(registro.get(3));
                    int estrellas = (int) registro.get(4);
                    String direccion = String.valueOf(registro.get(5));
                    int IdHabitacion = (int) registro.get(6);

                    hoteles.add(new Hotel(IdHotel,nombre,ciudad,pais,estrellas,direccion,IdHabitacion));
                }
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }

        return hoteles;

    }
}
