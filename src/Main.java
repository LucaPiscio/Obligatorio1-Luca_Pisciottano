import Dominio.Huesped;
import Persistencia.Conexion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner escaner = new Scanner(System.in);
    private static Controladora controladora = new Controladora();
    public static void main(String[] args) {

        int opcion;
        do{
            menu();
            System.out.println("Ingrese la opción del menú");
            opcion = Integer.parseInt(escaner.nextLine());

            switch(opcion){
                case 1:{
                    controladora.agregarHuesped();
                    break;
                }
                case 2:{
                    controladora.eliminarHuesped();
                    break;
                }
                case 3:{
                    controladora.modificarHuesped();
                    break;
                }
                case 4:{
                    controladora.listarHuespedes();
                    break;
                }
                case 5:{
                    controladora.conseguirHuesped();
                    break;
                }
            }
        }
        while(opcion!=-1);
    }
    private static void menu(){
        System.out.println("MENU");
        System.out.println("1. Agregar huesped");
        System.out.println("2. Eliminar huesped");
        System.out.println("3. Modificar huesped");
        System.out.println("4. Listar huesped");
        System.out.println("5. Conseguir huesped");

    }
}