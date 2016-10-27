/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import edu.eci.pdsw.samples.persistence.PersistenceException;

/**
 *
 * @author 2105409
 */
public interface DAOPaciente {
    
     public void consultaDelRanking(int N, int year) throws PersistenceException;
}
