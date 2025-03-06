package br.com.unisales.tudoaqui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.tudoaqui.dto.ServicoCadastroDTO;
import br.com.unisales.tudoaqui.dto.ServicoDTO;
import br.com.unisales.tudoaqui.model.Servico;
import br.com.unisales.tudoaqui.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public ServicoDTO cadastrarServico(ServicoCadastroDTO servicoCadastroDTO) {
        Servico servico = new Servico();
        servico.setNome(servicoCadastroDTO.getNome());
        servico.setDescricao(servicoCadastroDTO.getDescricao());
        servico.setCategoria(Servico.CategoriaServico.valueOf(servicoCadastroDTO.getCategoria()));
        servico.setPreco(servicoCadastroDTO.getPreco()); 

        servico = repo.save(servico);
        return converterParaDTO(servico); 
    }

    public ServicoDTO buscarServicoPorId(Long id) {
        Optional<Servico> servicoOptional = repo.findById(id);
        if (servicoOptional.isPresent()) {
            return converterParaDTO(servicoOptional.get()); 
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }

    public ServicoDTO atualizarServico(Long id, ServicoCadastroDTO servicoCadastroDTO) {
        Optional<Servico> servicoOptional = repo.findById(id);
        if (servicoOptional.isPresent()) {
            Servico servico = servicoOptional.get();
            servico.setNome(servicoCadastroDTO.getNome());
            servico.setDescricao(servicoCadastroDTO.getDescricao());
            servico.setCategoria(Servico.CategoriaServico.valueOf(servicoCadastroDTO.getCategoria()));
            servico.setPreco(servicoCadastroDTO.getPreco());

            servico = repo.save(servico);
            return converterParaDTO(servico); 
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }

    public void deletarServico(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }

    public List<ServicoDTO> listarServicos() {
        return repo.findAll().stream()
                .map(this::converterParaDTO) 
                .collect(Collectors.toList());
    }

    private ServicoDTO converterParaDTO(Servico servico) {
        return new ServicoDTO(
            servico.getId(),
            servico.getNome(),
            servico.getDescricao(),
            servico.getCategoria().toString(),
            servico.getPreco() 
        );
    }
}