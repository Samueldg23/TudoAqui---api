package br.com.unisales.tudoaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unisales.tudoaqui.dto.PedidoCadastroDTO;
import br.com.unisales.tudoaqui.dto.PedidoDTO;
import br.com.unisales.tudoaqui.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody PedidoCadastroDTO pedidoCadastroDTO) {
        PedidoDTO pedidoDTO = service.cadastrarPedido(pedidoCadastroDTO);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPedidoPorId(@PathVariable Long id) {
        PedidoDTO pedidoDTO = service.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(
            @PathVariable Long id,
            @RequestBody PedidoCadastroDTO pedidoCadastroDTO) {
        PedidoDTO pedidoDTO = service.atualizarPedido(id, pedidoCadastroDTO);
        return ResponseEntity.ok(pedidoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        service.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        List<PedidoDTO> pedidos = service.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }
}