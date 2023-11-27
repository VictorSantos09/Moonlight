package com.moonlight.moonlightapp.services.materiasprimas;
import java.util.List;
import com.moonlight.moonlightapp.models.MateriaPrimaModel;
import com.moonlight.moonlightapp.daos.MateriaPrimaDAO;

public class BuscarMateriaPrimaService {
    private final MateriaPrimaDAO materiaPrimaDAO;

    public BuscarMateriaPrimaService(){
        materiaPrimaDAO = new MateriaPrimaDAO();
    }

    public List<MateriaPrimaModel> buscarTodos(){
        return materiaPrimaDAO.buscarTodos();
    }

    public MateriaPrimaModel buscarPorNome(String nome){
        return materiaPrimaDAO.buscarPorNome(nome);
    }
}
