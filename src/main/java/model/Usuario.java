/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author oscar
 */
public class Usuario
{
    private String _id;
    private String nombre;
    private String ap_pat;
    private String ap_mat;
    private String correo;
    private String nickname;
    private String contrasenia;
    private String genero;
    private String localidad;
    private String profesion;
    private Date fech_nac;
    private Date fecha_registro;
    private int estatus;

    /**
     * @return the _id
     */
    public String getId()
    {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(String _id)
    {
        this._id = _id;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the ap_pat
     */
    public String getAp_pat()
    {
        return ap_pat;
    }

    /**
     * @param ap_pat the ap_pat to set
     */
    public void setAp_pat(String ap_pat)
    {
        this.ap_pat = ap_pat;
    }

    /**
     * @return the ap_mat
     */
    public String getAp_mat()
    {
        return ap_mat;
    }

    /**
     * @param ap_mat the ap_mat to set
     */
    public void setAp_mat(String ap_mat)
    {
        this.ap_mat = ap_mat;
    }


    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the nickname
     */
    public String getNickname()
    {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia()
    {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the genero
     */
    public String getGenero()
    {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad()
    {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    /**
     * @return the profesion
     */
    public String getProfesion()
    {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion)
    {
        this.profesion = profesion;
    }

    /**
     * @return the fech_nac
     */
    public Date getFech_nac()
    {
        return fech_nac;
    }

    /**
     * @param fech_nac the fech_nac to set
     */
    public void setFech_nac(Date fech_nac)
    {
        this.fech_nac = fech_nac;
    }

    /**
     * @return the fecha_registro
     */
    public Date getFecha_registro()
    {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(Date fecha_registro)
    {
        this.fecha_registro = fecha_registro;
    }

    /**
     * @return the estatus
     */
    public int getEstatus()
    {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus)
    {
        this.estatus = estatus;
    }
    public Object[] toArray() {
        Object[] array = new Object[13]; // Ajusta el tamaño según la cantidad de atributos

        // Asigna los valores de los atributos al arreglo
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        array[0] = getId();
        array[1] = getNombre();
        array[2] = getAp_pat();
        array[3] = getAp_mat();
        array[4] = getCorreo();
        array[5] = getNickname();
        array[6] = getContrasenia();
        array[7] = getGenero();
        array[8] = getLocalidad();
        array[9] = getProfesion();
        array[10] = formatoFecha.format(getFech_nac());
        array[11] = formatoFecha.format(getFecha_registro());
        array[12] = getEstatus();

        return array;
    }
    
}
