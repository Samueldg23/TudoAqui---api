package br.com.unisales.tudoaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unisales.tudoaqui.dto.MensagemCadastroDTO;
import br.com.unisales.tudoaqui.dto.MensagemDTO;
import br.com.unisales.tudoaqui.service.MensagemService;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @PostMapping
    public ResponseEntity<MensagemDTO> enviarMensagem(@RequestBody MensagemCadastroDTO mensagemCadastroDTO) {
        MensagemDTO mensagemDTO = mensagemService.enviarMensagem(mensagemCadastroDTO);
        return new ResponseEntity<>(mensagemDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensagemDTO> buscarMensagemPorId(@PathVariable Long id) {
        MensagemDTO mensagemDTO = mensagemService.buscarMensagemPorId(id);
        return new ResponseEntity<>(mensagemDTO, HttpStatus.OK);
    }

    @GetMapping("/enviadas/{idRemetente}")
    public ResponseEntity<List<MensagemDTO>> listarMensagensEnviadas(@PathVariable Long idRemetente) {
        List<MensagemDTO> mensagens = mensagemService.listarMensagensEnviadas(idRemetente);
        return new ResponseEntity<>(mensagens, HttpStatus.OK);
    }

    @GetMapping("/recebidas/{idDestinatario}")
    public ResponseEntity<List<MensagemDTO>> listarMensagensRecebidas(@PathVariable Long idDestinatario) {
        List<MensagemDTO> mensagens = mensagemService.listarMensagensRecebidas(idDestinatario);
        return new ResponseEntity<>(mensagens, HttpStatus.OK);
    }

    @PatchMapping("/{id}/marcar-como-lida")
    public ResponseEntity<MensagemDTO> marcarMensagemComoLida(@PathVariable Long id) {
        MensagemDTO mensagemDTO = mensagemService.marcarMensagemComoLida(id);
        return new ResponseEntity<>(mensagemDTO, HttpStatus.OK);
    }
}