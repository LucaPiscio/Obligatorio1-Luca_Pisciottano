package Dominio;

import java.sql.Date;

public class Huesped {


    private int IdHuesped;
    private String Nombre;
    private String pApellido;
    private String mApellido;
    private String TipoDoc;
    private int Ci;

    public Huesped(int idHuesped, String nombre, String mApellido, String pApellido, String tipoDoc, int ci, String fnac, String tel, String pais) {
        IdHuesped = idHuesped;
        Nombre = nombre;
        this.pApellido = pApellido;
        this.mApellido = mApellido;
        TipoDoc = tipoDoc;
        Ci = ci;
        Fnac = fnac;
        Tel = tel;
        Pais = pais;
    }

    private String Fnac;
    private String Tel;
    private String Pais;


    public int getIdHuesped() {
        return IdHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        IdHuesped = idHuesped;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getmApellido() {
        return mApellido;
    }

    public void setmApellido(String mApellido) {
        this.mApellido = mApellido;
    }


    public String getTipoDoc() {
        return TipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        TipoDoc = tipoDoc;
    }

    public int getCi() {
        return Ci;
    }

    public void setCi(int ci) {
        Ci = ci;
    }

    public String getFnac() {
        return Fnac;
    }

    public void setFnac(String fnac) {
        Fnac = fnac;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }


}
