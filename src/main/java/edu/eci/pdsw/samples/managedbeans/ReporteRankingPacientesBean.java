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

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ServiceFacadeException;
import java.io.Serializable;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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

    public ReporteRankingPacientesBean(){
        respuestas = new ArrayList<Paciente>();
        N = 1;
        year = 2000;
    }
    /**
     * @return the respuestas
     */
    public List<Paciente> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(List<Paciente> respuestas) {
        this.respuestas = respuestas;
    }
  
    private ServicesFacade sp =ServicesFacade.getInstance("applicationconfig.properties");
    private List<Paciente> respuestas;
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
            respuestas = new ArrayList<Paciente>();
            List<Paciente> x = sp.topNPacientesPorAnyo(N, year);
            for(Paciente ee:x){
                if(ee.getConsultas().size()<=N)
                    respuestas.add(ee);
            }
        }catch(ServiceFacadeException ex){
        }
    }
    
            
}
