package com.brq.ms03.models;

import com.brq.ms03.dtos.ProfessorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.sql.DecimalTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

/*
 * @Data, que faz o papel dos Getters, Setters e toString()
 * @Entity "diz" que a classe UsuarioModel vai ser mapeada com uma tabela no banco de dados
 * @Table especifica o nome da tabela que esta classe vai mapear
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professor")
public class ProfessorModel {

    // UUID -> é um conjunto de letras e números para identificar unicamente um registro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "nome_user")
    private String nome;

    @Column(name = "cpf_user")
    private String cpf;

    @Column(name = "salario_user")
    private String salario;

    @Column(name = "telefone_user")
    private String telefone;

    public ProfessorDTO toDTO(){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, ProfessorDTO.class);
    }
}