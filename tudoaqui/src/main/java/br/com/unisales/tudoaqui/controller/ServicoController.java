package br.com.unisales.tudoaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unisales.tudoaqui.dto.ServicoCadastroDTO;
import br.com.unisales.tudoaqui.dto.ServicoDTO;
import br.com.unisales.tudoaqui.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping
    public ResponseEntity<ServicoDTO> cadastrarServico(@RequestBody ServicoCadastroDTO servicoCadastroDTO) {
        ServicoDTO servicoDTO = service.cadastrarServico(servicoCadastroDTO);
        return ResponseEntity.ok(servicoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> buscarServicoPorId(@PathVariable Long id) {
        ServicoDTO servicoDTO = service.buscarServicoPorId(id);
        return ResponseEntity.ok(servicoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> atualizarServico(
            @PathVariable Long id,
            @RequestBody ServicoCadastroDTO servicoCadastroDTO) {
        ServicoDTO servicoDTO = service.atualizarServico(id, servicoCadastroDTO);
        return ResponseEntity.ok(servicoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        service.deletarServico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listarServicos() {
        List<ServicoDTO> servicos = service.listarServicos();
        return ResponseEntity.ok(servicos);
    }
}