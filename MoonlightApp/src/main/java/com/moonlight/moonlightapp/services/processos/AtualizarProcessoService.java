package com.moonlight.moonlightapp.services.processos;

import com.moonlight.moonlightapp.converters.ProcessoConverter;
import com.moonlight.moonlightapp.daos.ProcessoDAO;
import com.moonlight.moonlightapp.validators.dtos.ProcessoDTOValidator;
import com.moonlight.moonlightapp.validators.models.ProcessoValidator;

public class AtualizarProcessoService {
    private final ProcessoDAO processoDAO;
    private final ProcessoValidator processoValidator;
    private final ProcessoConverter processoConverter;
    private final ProcessoDTOValidator processoDTOValidator;
    
    public AtualizarProcessoService() {
        processoDAO = new ProcessoDAO();
        processoConverter = new ProcessoConverter();
        processoValidator = new ProcessoValidator();
        processoDTOValidator = new ProcessoDTOValidator();
    }
    
}
