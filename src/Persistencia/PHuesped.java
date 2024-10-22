package Persistencia;

import Dominio.Huesped;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;


public class PHuesped {

    private static Conexion conexion = new Conexion();
    public static boolean agregarHuesped(Huesped pHuesped){
        String sql = "INSERT INTO huespedes(IdHuesped,Nombre,pApellido,mApellido,TipoDoc,Ci,Fnac,Tel,Pais) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pHuesped.getIdHuesped(), pHuesped.getNombre(), pHuesped.getpApellido(), pHuesped.getmApellido(), pHuesped.getTipoDoc(), pHuesped.getCi(),pHuesped.getFnac(),pHuesped.getTel(),pHuesped.getPais()));

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
    public static boolean eliminarHuesped(int pCi){
        String sql = "DELETE FROM huespedes WHERE IdHuesped=?";
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

    public static boolean modificarHuesped(Huesped h){
        String sql = "UPDATE huespedes SET Nombre=?, pApellido=?, mApellido=?, TipoDoc=? , Ci=?, Fnac=?, Tel=?, Pais=?WHERE IdHuesped=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(h.getNombre(), h.getpApellido(), h.getmApellido(), h.getTipoDoc(), h.getCi(), h.getFnac(), h.getTel(),h.getPais(),h.getIdHuesped()));

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

    public static Huesped conseguirHuesped(int pCi){
        String sql = "SELECT IdHuesped,Nombre,pApellido,mApellido,TipoDoc,Ci,Fnac,Tel,Pais WHERE IdHuesped=?";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(pCi));


        try{
            List<List<Object>> resultado =conexion.seleccion(sql, parametros);
            if(!resultado.isEmpty()){
                System.out.println("Se encontro este huesped");
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
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }
        return null;



    }

    public static ArrayList<Huesped> listarHuespedes(){
        String sql = "SELECT * FROM huespedes";
        ArrayList<Huesped> huespedes = new ArrayList<>();

        try{
            List<List<Object>> registros = conexion.seleccion(sql, null);
            if(!registros.isEmpty()){
                System.out.println("Se realizó la modificacion con éxito");
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
            }
        }
        catch(AppSQLException ase){
            System.out.println(ase.getMessage());
        }

        return huespedes;

    }
}