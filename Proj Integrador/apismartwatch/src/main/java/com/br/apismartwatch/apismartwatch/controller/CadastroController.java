package com.br.apismartwatch.apismartwatch.controller;

import com.br.apismartwatch.apismartwatch.model.Cadastro;
import com.br.apismartwatch.apismartwatch.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    public ResponseEntity<List<Cadastro>> getAllCadastros() {
        List<Cadastro> cadastros = cadastroService.getAllCadastros();
        return new ResponseEntity<>(cadastros, HttpStatus.OK);
    }
}
