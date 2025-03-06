package br.com.unisales.tudoaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unisales.tudoaqui.dto.EnderecoCadastroDTO;
import br.com.unisales.tudoaqui.dto.EnderecoDTO;
import br.com.unisales.tudoaqui.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoCadastroDTO enderecoCadastroDTO) {
        EnderecoDTO enderecoDTO = service.cadastrarEndereco(enderecoCadastroDTO);
        return ResponseEntity.ok(enderecoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        EnderecoDTO enderecoDTO = service.buscarEnderecoPorId(id);
        return ResponseEntity.ok(enderecoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(
            @PathVariable Long id,
            @RequestBody EnderecoCadastroDTO enderecoCadastroDTO) {
        EnderecoDTO enderecoDTO = service.atualizarEndereco(id, enderecoCadastroDTO);
        return ResponseEntity.ok(enderecoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        service.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}