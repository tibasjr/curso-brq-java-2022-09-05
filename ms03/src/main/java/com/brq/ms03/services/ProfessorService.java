package com.brq.ms03.services;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProfessorService {

    // ESTE ARRAYLIST É DIDÁTICO, POIS ESTÁ SIMULANDO UM BANCO DE DADOS
    private ArrayList<ProfessorModel> professores = new ArrayList<>();
    private int counter = 1;

    @Autowired
    private ProfessorRepository profRepository;

    public void mostrarMensagemService(){
        System.out.println("Mensagem do serviço");
    }

    public List<ProfessorDTO> getAllPofessores(){
        List<ProfessorModel> list = profRepository.findAll();

// como converter uma LISTA DE MODEL PARA LISTA DE DTO?
        List<ProfessorDTO> listDTO = new ArrayList<>();

// Tipo de variável -
        for (ProfessorModel balde : list) {
            listDTO.add( balde.toDTO() );

        }
        return listDTO;
    }

    public ProfessorDTO create(ProfessorDTO professor){

        ProfessorModel professorSalvo = profRepository.save( professor.toModel() );
        return professorSalvo.toDTO();
    }

    public ProfessorDTO update(int id, ProfessorDTO professorBody)  {

        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Professor não localizado") );


        professor.setNome( professorBody.getNome() );
        professor.setTelefone( professorBody.getTelefone() );
        professor.setCpf( professorBody.getCpf() );
        professor.setSalario( professorBody.getSalario() );

        return profRepository.save(professor).toDTO();

    }

    public String delete(int id){

        profRepository.deleteById(id);
        return "Usuário delatado com sucesso!";
    }

    public ProfessorDTO getOne(int id){

        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Professor não localizado"));

        return professor.toDTO();
    }
}