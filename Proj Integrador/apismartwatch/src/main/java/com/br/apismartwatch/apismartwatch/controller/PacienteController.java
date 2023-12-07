package com.br.apismartwatch.apismartwatch.controller;

import com.br.apismartwatch.apismartwatch.dao.PacienteDaoImpl;
import com.br.apismartwatch.apismartwatch.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteDaoImpl pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPaciente() {
        List<Paciente> paciente = pacienteService.getAllPaciente();
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteService.createPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente criado com sucesso!");
    }
}

