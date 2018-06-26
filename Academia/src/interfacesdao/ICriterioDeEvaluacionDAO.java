/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;

import clases.CriterioDeEvaluacion;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public interface ICriterioDeEvaluacionDAO {
    boolean agregarCriterioDeEvaluacion(CriterioDeEvaluacion criterioDeEvaluacion);
    ArrayList<CriterioDeEvaluacion> obtenerCriteriosDeEvaluacionPorExperienciaEducativa(String codigoEE);
}
