package com.moonlight.moonlightapp.services.materiasprimas;

import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.TipoMateriaPrimaDAO;
import com.moonlight.moonlightapp.daos.UnidadeMedidaDAO;
import com.moonlight.moonlightapp.dtos.BaseDTO;
import com.moonlight.moonlightapp.dtos.materiasprimas.AtualizarMateriaPrimaDTO;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.validators.dtos.UnidadeMedidaDTOValidator;
import com.moonlight.moonlightapp.validators.models.UnidadeMedidaValidator;

public class AtualizarMateriaPrimaService {
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final UnidadeMedidaDAO unidadeMedidaDAO;
    private final TipoMateriaPrimaDAO tipoMateriaPrimaDAO;
    private final UnidadeMedidaDTOValidator unidadeMedidaDTOValidator;
    
    public AtualizarMateriaPrimaService(){
        materiaPrimaDAO = new MateriaPrimaDAO();
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        tipoMateriaPrimaDAO = new TipoMateriaPrimaDAO();
        unidadeMedidaDTOValidator = new UnidadeMedidaDTOValidator();
    }

 

}
