package com.digilivros.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.digilivros.models.Aluno;
import com.digilivros.models.Aula;
import com.digilivros.models.Frequencia;
import com.digilivros.repository.AlunoRepository;
import com.digilivros.repository.AulaRepository;
import com.digilivros.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.digilivros.date.HandleDate;

@RestController
@RequestMapping(value = "/api")
public class FrequenciaController {
    @Autowired
    FrequenciaRepository frequenciaRepository;
        
        @Autowired
        private AlunoRepository alunoRepository;

        @Autowired
        private AulaRepository aulaRepository;;


    HandleDate handleDate;
    Frequencia frequencia;

    @GetMapping("/frequencia")
    public List<FrequenciaOutDTO> ListFrequencia() {
        List<Frequencia> frequenciaList = frequenciaRepository.findAll();
        List<FrequenciaOutDTO> frequenciaOutDTOList = new ArrayList<>();

        // Formatar a data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Frequencia frequencia : frequenciaList) {
            // Buscar aluno e aula pelo ID
            Aluno aluno = alunoRepository.findById(frequencia.getAluno());
            Aula aula = aulaRepository.findById(frequencia.getAula());

            // Criar o DTO e preencher os dados
            FrequenciaOutDTO dto = new FrequenciaOutDTO();
            dto.setAluno(aluno != null ? aluno.getName() : "Aluno não encontrado");
            dto.setAula(aula != null ? aula.getTitle() : "Aula não encontrada");
            dto.setDataAula(frequencia.getDataAula().format(formatter));
            dto.setId(frequencia.getId());

            // Adicionar o DTO à lista
            frequenciaOutDTOList.add(dto);
        }

        return frequenciaOutDTOList;
    }

    @PostMapping("/frequencia")
    public Frequencia saveFrequencia(@RequestBody FrequenciaDTO frequenciaDto) {
        Frequencia frequencia = new Frequencia();
        frequencia.setDataAula(frequenciaDto.getDataAula());
        frequencia.setAula(frequenciaDto.getAula());
        frequencia.setAluno(frequenciaDto.getAluno());

        return frequenciaRepository.save(frequencia);

    }

    @DeleteMapping("/frequencia/{id}")
    public ResponseEntity<Void> deletarFrequencia(@PathVariable Long id) {
        Optional<Frequencia> frequencia = frequenciaRepository.findById(id);

        if (frequencia.isPresent()) {
            frequenciaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
