import Dominio.Huesped;
import Persistencia.Conexion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner escaner = new Scanner(System.in);
    private static Controladora controladora = new Controladora();
    private static ControladoraFiltro controladoraF = new ControladoraFiltro();
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
                case 16:{
                    controladora.agregarTarifa();
                    break;
                }
                case 17:{
                    controladora.eliminarTarifa();
                    break;
                }
                case 18:{
                    controladora.modificarTarifa();
                    break;
                }
                case 19:{
                    controladora.listarTarifas();
                    break;
                }
                case 20:{
                    controladora.conseguirTarifa();
                    break;
                }
                case 21:{
                    controladora.agregarReserva();
                    break;
                }
                case 22:{
                    controladora.eliminarReserva();
                    break;
                }
                case 23:{
                    controladora.modificarReserva();
                    break;
                }
                case 24:{
                    controladora.listarReserva();
                    break;
                }
                case 25:{
                    controladora.conseguirReserva();
                    break;
                }
                case 26:{
                    controladoraF.BusquedaNombre();
                    break;
                }
                case 27:{
                    controladoraF.BusquedaCiudad();
                    break;
                }
                case 28:{
                    controladoraF.BusquedaEstrella();
                    break;
                }
                case 29:{
                    controladoraF.reservadas();
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
        System.out.println("16. Agregar Tarifa");
        System.out.println("17. Eliminar Tarifa");
        System.out.println("18. Modificar Tarifa");
        System.out.println("19. Listar Tarifa");
        System.out.println("20. Conseguir Tarifa");
        System.out.println("21. Agregar reserva");
        System.out.println("22. Eliminar reserva");
        System.out.println("23. Modificar reserva");
        System.out.println("24. Listar reserva");
        System.out.println("25. Conseguir reserva");
        System.out.println("26. Buscar Por Nombre");
        System.out.println("27. Buscar Por ciudad");
        System.out.println("28. Buscar Por estrellas");
        System.out.println("29. Buscar Por reservas");

    }
}