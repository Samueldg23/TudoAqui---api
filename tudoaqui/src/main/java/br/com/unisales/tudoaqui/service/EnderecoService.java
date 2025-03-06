package br.com.unisales.tudoaqui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.tudoaqui.dto.EnderecoCadastroDTO;
import br.com.unisales.tudoaqui.dto.EnderecoDTO;
import br.com.unisales.tudoaqui.model.Endereco;
import br.com.unisales.tudoaqui.repository.EnderecoRepository;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repo;

    public EnderecoDTO cadastrarEndereco(EnderecoCadastroDTO enderecoCadastroDTO) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoCadastroDTO.getRua());
        endereco.setNumero(enderecoCadastroDTO.getNumero());
        endereco.setBairro(enderecoCadastroDTO.getBairro());
        endereco.setCidade(enderecoCadastroDTO.getCidade());
        endereco.setEstado(enderecoCadastroDTO.getEstado());
        endereco.setCep(enderecoCadastroDTO.getCep());

        endereco = repo.save(endereco);
        return converterParaDTO(endereco);
    }

    public EnderecoDTO buscarEnderecoPorId(Long id) { 
        Optional<Endereco> enderecoOptional = repo.findById(id);
        if (enderecoOptional.isPresent()) {
            return converterParaDTO(enderecoOptional.get());
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    public EnderecoDTO atualizarEndereco(Long id, EnderecoCadastroDTO enderecoCadastroDTO) {
        Optional<Endereco> enderecoOptional = repo.findById(id);
        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get();
            endereco.setRua(enderecoCadastroDTO.getRua());
            endereco.setNumero(enderecoCadastroDTO.getNumero());
            endereco.setBairro(enderecoCadastroDTO.getBairro());
            endereco.setCidade(enderecoCadastroDTO.getCidade());
            endereco.setEstado(enderecoCadastroDTO.getEstado());
            endereco.setCep(enderecoCadastroDTO.getCep());

            endereco = repo.save(endereco);
            return converterParaDTO(endereco);
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    public void deletarEndereco(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    private EnderecoDTO converterParaDTO(Endereco endereco) {
        return new EnderecoDTO(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep());
    }
}