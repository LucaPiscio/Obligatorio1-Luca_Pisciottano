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
                case 6:{
                    controladora.agregarHabitacion();
                    break;
                }
                case 7:{
                    controladora.eliminarHabitacion();
                    break;
                }
                case 8:{
                    controladora.modificarHabitacion();
                    break;
                }
                case 9:{
                    controladora.listarHabitacion();
                    break;
                }
                case 10:{
                    controladora.conseguirHabitacion();
                    break;
                }
                case 11:{
                    controladora.agregarHotel();
                    break;
                }
                case 12:{
                    controladora.eliminarHotel();
                    break;
                }
                case 13:{
                    controladora.modificarHotel();
                    break;
                }
                case 14:{
                    controladora.listarHotel();
                    break;
                }
                case 15:{
                    controladora.conseguirHotel();
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
        System.out.println("6. Agregar habitacion");
        System.out.println("7. Eliminar habitacion");
        System.out.println("8. Modificar habitacion");
        System.out.println("9. Listar habitacion");
        System.out.println("10. Conseguir habitacion");
        System.out.println("11. Agregar hotel");
        System.out.println("12. Eliminar hotel");
        System.out.println("13. Modificar hotel");
        System.out.println("14. Listar hotel");
        System.out.println("15. Conseguir hotel");

    }
}