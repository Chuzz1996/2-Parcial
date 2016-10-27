/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.services.ServiceFacadeException;
import java.io.Serializable;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name="RegistroBean")
@SessionScoped
public class ReporteRankingPacientesBean implements Serializable{
  
   private static ServicesFacade sp =ServicesFacade.getInstance("applicationconfig_1.properties");

    /**
     * @return the sp
     */
    public static ServicesFacade getSp() {
        return sp;
    }

    /**
     * @param aSp the sp to set
     */
    public static void setSp(ServicesFacade aSp) {
        sp = aSp;
    }
    
    private int idPaciente;
    private String tipoID;
    private String nombrePaciente;
    private Date fechaNacimiento;
    private Date Fecha_Y_hora;
    private String resumen;
    


    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the tipoID
     */
    public String getTipoID() {
        return tipoID;
    }

    /**
     * @param tipoID the tipoID to set
     */
    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    /**
     * @return the nombrePaciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * @param nombrePaciente the nombrePaciente to set
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the Fecha_Y_hora
     */
    public Date getFecha_Y_hora() {
        return Fecha_Y_hora;
    }

    /**
     * @param Fecha_Y_hora the Fecha_Y_hora to set
     */
    public void setFecha_Y_hora(Date Fecha_Y_hora) {
        this.Fecha_Y_hora = Fecha_Y_hora;
    }

    /**
     * @return the resumen
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * @param resumen the resumen to set
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    private int N;
    private int year;

    /**
     * @return the N
     */
    public int getN() {
        return N;
    }

    /**
     * @param N the N to set
     */
    public void setN(int N) {
        this.N = N;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    public void MirarTop(){
        try{
            sp.topNPacientesPorAnyo(N, year);
        }catch(ServiceFacadeException ex){
        }
    }
    
            
}
