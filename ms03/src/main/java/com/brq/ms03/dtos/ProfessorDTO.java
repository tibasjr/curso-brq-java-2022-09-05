package com.brq.ms03.dtos;

import com.brq.ms03.models.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private int id;

    @NotEmpty(message = "Nome não pode ser em branco")
    @NotNull(message = "Preenchimento Obrigatório")
    private String nome;
    private String cpf;
    private String salario;
    private String telefone;

    public ProfessorModel toModel(){

        ModelMapper mapper = new ModelMapper();

        ProfessorModel model = mapper.map(this , ProfessorModel.class );

        return model;
    }
}