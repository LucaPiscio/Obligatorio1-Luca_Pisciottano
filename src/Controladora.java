import Dominio.Huesped;
import Persistencia.PHuesped;
import Dominio.Habitacion;
import Persistencia.PHabitacion;
import java.util.Scanner;

public class Controladora {
    private static Scanner escaner = new Scanner(System.in);

//    public void agregarHuesped() {
//        System.out.println("Agregar Huesped");
//
//        String nombre;
//        do {
//            System.out.println("Ingrese nombre del huésped:");
//            nombre = escaner.nextLine();
//        } while (nombre.isEmpty());
//
//        String pApellido;
//        do {
//            System.out.println("Ingrese primer apellido del huésped:");
//            pApellido = escaner.nextLine();
//        } while (pApellido.isEmpty());
//
//        String mApellido;
//        do {
//            System.out.println("Ingrese segundo apellido del huésped:");
//            mApellido = escaner.nextLine();
//        } while (mApellido.isEmpty());
//
//        String tipoDoc;
//        do {
//            System.out.println("Ingrese tipo de documento del huésped (DNI, Pasaporte, etc.):");
//            tipoDoc = escaner.nextLine();
//        } while (tipoDoc.isEmpty());
//
//        int ci;
//        do {
//            System.out.println("Ingrese cédula del huésped:");
//            try {
//                ci = Integer.parseInt(escaner.nextLine());
//            } catch (Exception e) {
//                ci = 0;
//            }
//        } while (ci == 0);
//
//        String fnac;
//        do {
//            System.out.println("Ingrese fecha de nacimiento del huésped (formato YYYY-MM-DD):");
//            fnac = escaner.nextLine();
//        } while (fnac.isEmpty());
//
//        int tel;
//        do {
//            System.out.println("Ingrese teléfono del huésped (solo números):");
//            try {
//                tel = Integer.parseInt(escaner.nextLine());
//            } catch (NumberFormatException e) {
//                tel = 0;
//            }
//        } while (tel == 0);
//
//        String pais;
//        do {
//            System.out.println("Ingrese país del huésped:");
//            pais = escaner.nextLine();
//        } while (pais.isEmpty());
//
//        Huesped unHuesped = new Huesped(0, nombre, pApellido, mApellido, tipoDoc, ci, fnac, tel, pais);
//
//        if (PHuesped.agregarHuesped(unHuesped))
//            System.out.println("Se agregó el huésped con éxito.");
//        else
//            System.out.println("Hubo un problema al agregar el huésped.");
//    }
//
//    public void eliminarHuesped() {
//        System.out.println("Eliminar huésped");
//        System.out.println("Ingrese la cédula del huésped:");
//        int ci = Integer.parseInt(escaner.nextLine());
//
//        if (PHuesped.eliminarHuesped(ci)) {
//            System.out.println("Se eliminó con éxito.");
//        } else {
//            System.out.println("No se pudo eliminar.");
//        }
//    }
//
//    public void modificarHuesped() {
//        System.out.println("Modificar huésped");
//
//        System.out.println("Ingrese la cédula del huésped a modificar:");
//        int ci = Integer.parseInt(escaner.nextLine());
//
//        Huesped h = buscarHuesped(ci);
//
//        System.out.println("Ingrese el nombre del huésped (" + h.getNombre() + "):");
//        String nombre = escaner.nextLine();
//        if (!nombre.isEmpty())
//            h.setNombre(nombre);
//
//        System.out.println("Ingrese el primer apellido del huésped (" + h.getpApellido() + "):");
//        String pApellido = escaner.nextLine();
//        if (!pApellido.isEmpty())
//            h.setpApellido(pApellido);
//
//        System.out.println("Ingrese el segundo apellido del huésped (" + h.getmApellido() + "):");
//        String mApellido = escaner.nextLine();
//        if (!mApellido.isEmpty())
//            h.setmApellido(mApellido);
//
//        System.out.println("Ingrese el tipo de documento del huésped (" + h.getTipoDoc() + "):");
//        String tipoDoc = escaner.nextLine();
//        if (!tipoDoc.isEmpty())
//            h.setTipoDoc(tipoDoc);
//
//        System.out.println("Ingrese la fecha de nacimiento del huésped (" + h.getFnac() + "):");
//        String fnac = escaner.nextLine();
//        if (!fnac.isEmpty())
//            h.setFnac(fnac);
//
//        System.out.println("Ingrese el teléfono del huésped (" + h.getTel() + "):");
//        String tel = escaner.nextLine();
//        if (!tel.isEmpty())
//            h.setTel(Integer.parseInt(tel));
//
//        System.out.println("Ingrese el país del huésped (" + h.getPais() + "):");
//        String pais = escaner.nextLine();
//        if (!pais.isEmpty())
//            h.setPais(pais);
//
//        PHuesped.modificarHuesped(h);
//    }
//
//    private Huesped buscarHuesped(int ci) {
//        return PHuesped.conseguirHuesped(ci);
//    }
//
//    public void conseguirHuesped() {
//        System.out.println("Ingrese cédula del huésped:");
//        int ci = Integer.parseInt(escaner.nextLine());
//        System.out.println(buscarHuesped(ci).toString());
//    }
//
//    public void listarHuespedes() {
//        System.out.println("Listado de huéspedes:");
//        for (Huesped h : PHuesped.listarHuespedes()) {
//            System.out.println(h.toString());
//        }
//    }
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
    do {
        System.out.println("Ingrese la capacidad de la Habitacion (solo números):");
        try {
            capacidad = Integer.parseInt(escaner.nextLine());
        } catch (NumberFormatException e) {
            capacidad = 0;
        }
    } while (capacidad == 0);

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
    } public void agregarHuesped() {
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
}
