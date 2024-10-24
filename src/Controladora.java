import Dominio.Huesped;
import Persistencia.PHuesped;
import Dominio.Hotel;
import Persistencia.PHotel;
import Dominio.Habitacion;
import Persistencia.PHabitacion;
import java.util.Scanner;

public class Controladora {
    private static Scanner escaner = new Scanner(System.in);

    public void agregarHuesped() {
        System.out.println("Agregar Huesped");

        String nombre;
        do {
            System.out.println("Ingrese nombre del huésped:");
            nombre = escaner.nextLine();
        } while (nombre.isEmpty());

        String pApellido;
        do {
            System.out.println("Ingrese primer apellido del huésped:");
            pApellido = escaner.nextLine();
        } while (pApellido.isEmpty());

        String mApellido;
        do {
            System.out.println("Ingrese segundo apellido del huésped:");
            mApellido = escaner.nextLine();
        } while (mApellido.isEmpty());

        String tipoDoc;
        do {
            System.out.println("Ingrese tipo de documento del huésped (DNI, Pasaporte, etc.):");
            tipoDoc = escaner.nextLine();
        } while (tipoDoc.isEmpty());

        int ci;
        do {
            System.out.println("Ingrese cédula del huésped:");
            try {
                ci = Integer.parseInt(escaner.nextLine());
            } catch (Exception e) {
                ci = 0;
            }
        } while (ci == 0);

        String fnac;
        do {
            System.out.println("Ingrese fecha de nacimiento del huésped (formato YYYY-MM-DD):");
            fnac = escaner.nextLine();
        } while (fnac.isEmpty());

        int tel;
        do {
            System.out.println("Ingrese teléfono del huésped (solo números):");
            try {
                tel = Integer.parseInt(escaner.nextLine());
            } catch (NumberFormatException e) {
                tel = 0;
            }
        } while (tel == 0);

        String pais;
        do {
            System.out.println("Ingrese país del huésped:");
            pais = escaner.nextLine();
        } while (pais.isEmpty());

        Huesped unHuesped = new Huesped(0, nombre, pApellido, mApellido, tipoDoc, ci, fnac, tel, pais);

        if (PHuesped.agregarHuesped(unHuesped))
            System.out.println("Se agregó el huésped con éxito.");
        else
            System.out.println("Hubo un problema al agregar el huésped.");
    }

    public void eliminarHuesped() {
        System.out.println("Eliminar huésped");
        System.out.println("Ingrese la cédula del huésped:");
        int ci = Integer.parseInt(escaner.nextLine());

        if (PHuesped.eliminarHuesped(ci)) {
            System.out.println("Se eliminó con éxito.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }

    public void modificarHuesped() {
        System.out.println("Modificar huésped");

        System.out.println("Ingrese la cédula del huésped a modificar:");
        int ci = Integer.parseInt(escaner.nextLine());

        Huesped h = buscarHuesped(ci);

        System.out.println("Ingrese el nombre del huésped (" + h.getNombre() + "):");
        String nombre = escaner.nextLine();
        if (!nombre.isEmpty())
            h.setNombre(nombre);

        System.out.println("Ingrese el primer apellido del huésped (" + h.getpApellido() + "):");
        String pApellido = escaner.nextLine();
        if (!pApellido.isEmpty())
            h.setpApellido(pApellido);

        System.out.println("Ingrese el segundo apellido del huésped (" + h.getmApellido() + "):");
        String mApellido = escaner.nextLine();
        if (!mApellido.isEmpty())
            h.setmApellido(mApellido);

        System.out.println("Ingrese el tipo de documento del huésped (" + h.getTipoDoc() + "):");
        String tipoDoc = escaner.nextLine();
        if (!tipoDoc.isEmpty())
            h.setTipoDoc(tipoDoc);

        System.out.println("Ingrese la fecha de nacimiento del huésped (" + h.getFnac() + "):");
        String fnac = escaner.nextLine();
        if (!fnac.isEmpty())
            h.setFnac(fnac);

        System.out.println("Ingrese el teléfono del huésped (" + h.getTel() + "):");
        String tel = escaner.nextLine();
        if (!tel.isEmpty())
            h.setTel(Integer.parseInt(tel));

        System.out.println("Ingrese el país del huésped (" + h.getPais() + "):");
        String pais = escaner.nextLine();
        if (!pais.isEmpty())
            h.setPais(pais);

        PHuesped.modificarHuesped(h);
    }

    private Huesped buscarHuesped(int ci) {
        return PHuesped.conseguirHuesped(ci);
    }

    public void conseguirHuesped() {
        System.out.println("Ingrese cédula del huésped:");
        int ci = Integer.parseInt(escaner.nextLine());
        System.out.println(buscarHuesped(ci).toString());
    }

    public void listarHuespedes() {
        System.out.println("Listado de huéspedes:");
        for (Huesped h : PHuesped.listarHuespedes()) {
            System.out.println(h.toString());
        }
    }
public void agregarHabitacion() {
    System.out.println("Agregar Habiitacion");

    int IdHabitacion;
    do {
        System.out.println("Ingrese Id de Habitacion (solo números):");
        try {
            IdHabitacion = Integer.parseInt(escaner.nextLine());
        } catch (NumberFormatException e) {
            IdHabitacion = 0;
        }
    } while (IdHabitacion == 0);

    int capacidad;
    do {
        System.out.println("Ingrese la capacidad de la Habitacion (solo números):");
        try {
            capacidad = Integer.parseInt(escaner.nextLine());
        } catch (NumberFormatException e) {
            capacidad = 0;
        }
    } while (capacidad == 0);

    boolean matrimonial;
    String respuesta;
    do {
        System.out.print("¿La habitación tiene cama matrimonial? (si/no): ");
        respuesta = escaner.nextLine().trim().toLowerCase();
    } while (!respuesta.equals("si") && !respuesta.equals("no"));
    matrimonial = respuesta.equals("si");

    boolean aireAcondicionado;
    do {
        System.out.print("¿La habitación tiene aire acondicionado? (si/no): ");
        respuesta = escaner.nextLine().trim().toLowerCase();
    } while (!respuesta.equals("si") && !respuesta.equals("no"));
    aireAcondicionado = respuesta.equals("si");

    boolean balcon;
    do {
        System.out.print("¿La habitación tiene balcon? (si/no): ");
        respuesta = escaner.nextLine().trim().toLowerCase();
    } while (!respuesta.equals("si") && !respuesta.equals("no"));
    balcon = respuesta.equals("si");

    boolean vista;
    do {
        System.out.print("¿La habitación tiene vista? (si/no): ");
        respuesta = escaner.nextLine().trim().toLowerCase();
    } while (!respuesta.equals("si") && !respuesta.equals("no"));
    vista = respuesta.equals("si");

    String amenities;
    do {
        System.out.println("Ingrese los amenities:");
        amenities = escaner.nextLine();
    } while (amenities.isEmpty());

    boolean disponible;
    do {
        System.out.print("¿La habitación esta disponible? (si/no): ");
        respuesta = escaner.nextLine().trim().toLowerCase();
    } while (!respuesta.equals("si") && !respuesta.equals("no"));
    disponible = respuesta.equals("si");



    Habitacion unaHabitacion = new Habitacion(IdHabitacion,capacidad,matrimonial,aireAcondicionado,balcon,vista,amenities,disponible);

    if (PHabitacion.agregarHabitacion(unaHabitacion))
        System.out.println("Se agregó la habitacion con éxito.");
    else
        System.out.println("Hubo un problema al agregar la habitacion.");
}

    public void eliminarHabitacion() {
        System.out.println("Eliminar habitacion");
        System.out.println("Ingrese el id de habitacion:");
        int IdHabitacion = Integer.parseInt(escaner.nextLine());

        if (PHabitacion.eliminarHabitacion(IdHabitacion)) {
            System.out.println("Se eliminó con éxito.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }

    public void modificarHabitacion() {
        System.out.println("Modificar hbaitacion");

        System.out.println("Ingrese el id de la habitacion a modificar:");
        int IdHabitacion = Integer.parseInt(escaner.nextLine());

        Habitacion ha = buscarHabitacion(IdHabitacion);

        System.out.println("Ingrese el id de la habitacion (" + ha.getIdHabitacion() + "):");
        int IdHuepsed = Integer.parseInt(escaner.nextLine());
        if (IdHuepsed!=0)
            ha.setIdHabitacion(IdHabitacion);

        System.out.println("Ingrese la capacidad de la Habitacion (" + ha.getCapacidad() + "):");
        int capacidad = Integer.parseInt(escaner.nextLine());
        if (capacidad !=0)
            ha.setCapacidad(capacidad);

        System.out.println(("Tiene cama matrimonial si/no (" + ha.isMatrimonial() + "):"));
        String respuesta = escaner.nextLine().toLowerCase();
        boolean matrimonial = respuesta.equals("si");

        ha.setMatrimonial(matrimonial);  // Asigna directamente el valor booleano



        System.out.println(("Tiene aire acondicionado si/no (" + ha.isAireAcondicionado() + "):"));
        boolean aireAcondicionado = respuesta.equals("si");

        ha.setAireAcondicionado(aireAcondicionado);  // Asigna directamente el valor booleano


        System.out.println(("Tiene balcon si/no (" + ha.isBalcon() + "):"));
        boolean balcon = respuesta.equals("si");

        ha.setBalcon(balcon);  // Asigna directamente el valor booleano

        System.out.println(("Tiene Vista si/no (" + ha.isVista() + "):"));
        boolean vista = respuesta.equals("si");

        ha.setVista(vista);  // Asigna directamente el valor booleano


        System.out.println("Ingrese los amenities (" + ha.getAmenities() + "):");
        String amenities = escaner.nextLine();
        if (!amenities.isEmpty())
            ha.setAmenities(amenities);

        PHabitacion.modificarHabitacion(ha);
    }

    private Habitacion buscarHabitacion(int IdHabitacion) {
        return PHabitacion.conseguirHabitacion(IdHabitacion);
    }

    public void conseguirHabitacion() {
        System.out.println("Ingrese id de la habitacion:");
        int IdHabitacion = Integer.parseInt(escaner.nextLine());
        System.out.println(buscarHabitacion(IdHabitacion).toString());
    }

    public void listarHabitacion() {
        System.out.println("Listado de habitaciones:");
        for (Habitacion ha : PHabitacion.listarHabitacion()) {
            System.out.println(ha.toString());
        }

    }
public void agregarHotel() {
    System.out.println("Agregar Hotel");

    int IdHotel;
    do {
        System.out.println("Ingrese Id del hotel:");
        try {
            IdHotel = Integer.parseInt(escaner.nextLine());
        } catch (Exception e) {
            IdHotel = 0;
        }
    } while (IdHotel == 0);

    String nombre;
    do {
        System.out.println("Ingrese nombre del hotel:");
        nombre = escaner.nextLine();
    } while (nombre.isEmpty());

    String ciudad;
    do {
        System.out.println("Ingrese la ciudad del hotel:");
        ciudad = escaner.nextLine();
    } while (ciudad.isEmpty());

    String pais;
    do {
        System.out.println("Ingrese el pais del hotel:");
        pais = escaner.nextLine();
    } while (pais.isEmpty());


    int estrellas;
    do {
        System.out.println("Ingrese las estrellas del hotel:");
        try {
            estrellas = Integer.parseInt(escaner.nextLine());
        } catch (Exception e) {
            estrellas = 0;
        }
    } while (estrellas == 0);

    String direccion;
    do {
        System.out.println("Ingrese la direccion del hotel):");
        direccion = escaner.nextLine();
    } while (direccion.isEmpty());

    int IdHabitacion;
    do {
        System.out.println("Ingrese el id de la Habitacion:");
        try {
            IdHabitacion = Integer.parseInt(escaner.nextLine());
        } catch (NumberFormatException e) {
            IdHabitacion = 0;
        }
    } while (IdHabitacion == 0);



    Hotel unHotel = new Hotel(IdHotel, nombre, ciudad, pais, estrellas, direccion, IdHabitacion);

    if (PHotel.agregarHotel(unHotel))
        System.out.println("Se agregó el hotel con éxito.");
    else
        System.out.println("Hubo un problema al agregar el hotel.");
}

    public void eliminarHotel() {
        System.out.println("Eliminar hotel");
        System.out.println("Ingrese el id del hotel:");
        int IdHotel = Integer.parseInt(escaner.nextLine());

        if (PHotel.eliminarHotel(IdHotel)) {
            System.out.println("Se eliminó con éxito.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }

    public void modificarHotel() {
        System.out.println("Modificar hotel");

        System.out.println("Ingrese el id del hotel a modificar:");
        int IdHotel = Integer.parseInt(escaner.nextLine());

        Hotel ho = buscarHotel(IdHotel);

        System.out.println("Ingrese el nombre del hotel (" + ho.getNombre() + "):");
        String nombre = escaner.nextLine();
        if (!nombre.isEmpty())
            ho.setNombre(nombre);

        System.out.println("Ingrese la ciudad del hotel (" + ho.getCiudad() + "):");
        String ciudad = escaner.nextLine();
        if (!ciudad.isEmpty())
            ho.setCiudad(ciudad);

        System.out.println("Ingrese el pais del hotel (" + ho.getPais() + "):");
        String pais = escaner.nextLine();
        if (!pais.isEmpty())
            ho.setPais(pais);

        System.out.println("Ingrese la cantidad de estrellas (" + ho.getEstrellas() + "):");
        int estrellas = Integer.parseInt(escaner.nextLine());
        if (estrellas !=0)
            ho.setEstrellas(estrellas);

        System.out.println("Ingresela direccion del hotel (" + ho.getDireccion() + "):");
        String direccion = escaner.nextLine();
        if (!direccion.isEmpty())
            ho.setDireccion(pais);

        System.out.println("Ingrese el Id de Habitacion(" + ho.getIdHabitacion() + "):");
        int IdHabitacion = Integer.parseInt(escaner.nextLine());
        if (IdHabitacion !=0)
            ho.setIdHabitacion(estrellas);



        PHotel.modificarHotel(ho);
    }

    private Hotel buscarHotel(int IdHotel) {
        return PHotel.conseguirHotel(IdHotel);
    }

    public void conseguirHotel() {
        System.out.println("Ingrese Id del Hotel:");
        int IdHotel = Integer.parseInt(escaner.nextLine());
        System.out.println(buscarHotel(IdHotel).toString());
    }

    public void listarHotel() {
        System.out.println("Listado de hoteles:");
        for (Hotel ho : PHotel.listarHotel()) {
            System.out.println(ho.toString());
        }
    }
}
