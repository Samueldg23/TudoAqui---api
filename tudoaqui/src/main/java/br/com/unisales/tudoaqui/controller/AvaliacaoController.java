package br.com.unisales.tudoaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unisales.tudoaqui.dto.AvaliacaoCadastroDTO;
import br.com.unisales.tudoaqui.dto.AvaliacaoDTO;
import br.com.unisales.tudoaqui.service.AvaliacaoService;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> cadastrarAvaliacao(@RequestBody AvaliacaoCadastroDTO avaliacaoCadastroDTO) {
        AvaliacaoDTO avaliacaoDTO = service.cadastrarAvaliacao(avaliacaoCadastroDTO);
        return new ResponseEntity<>(avaliacaoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> buscarAvaliacaoPorId(@PathVariable Long id) {
        AvaliacaoDTO avaliacaoDTO = service.buscarAvaliacaoPorId(id);
        return new ResponseEntity<>(avaliacaoDTO, HttpStatus.OK);
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<AvaliacaoDTO>> listarAvaliacoesPorPedido(@PathVariable Long idPedido) {
        List<AvaliacaoDTO> avaliacoes = service.listarAvaliacoesPorPedido(idPedido);
        return new ResponseEntity<>(avaliacoes, HttpStatus.OK);
    }

    @GetMapping("/prestador/{idPrestador}")
    public ResponseEntity<List<AvaliacaoDTO>> listarAvaliacoesPorPrestador(@PathVariable Long idPrestador) {
        List<AvaliacaoDTO> avaliacoes = service.listarAvaliacoesPorPrestador(idPrestador);
        return new ResponseEntity<>(avaliacoes, HttpStatus.OK);
    }
}