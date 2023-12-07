package com.br.apismartwatch.apismartwatch.controller;

import com.br.apismartwatch.apismartwatch.model.Aparelho;
import com.br.apismartwatch.apismartwatch.service.AparelhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aparelho")
public class AparelhoController {

    @Autowired
    private AparelhoService aparelhoService;

    @GetMapping
    public ResponseEntity<List<Aparelho>> getAllAparelho() {
        List<Aparelho> aparelho = aparelhoService.getAllAparelho();
        return new ResponseEntity<>(aparelho, HttpStatus.OK);
    }
}
