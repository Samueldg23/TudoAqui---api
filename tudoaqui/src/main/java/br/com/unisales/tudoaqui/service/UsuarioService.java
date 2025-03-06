package br.com.unisales.tudoaqui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.tudoaqui.dto.UsuarioCadastroDTO;
import br.com.unisales.tudoaqui.dto.UsuarioDTO;
import br.com.unisales.tudoaqui.model.Usuario;
import br.com.unisales.tudoaqui.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public UsuarioDTO cadastrarUsuario(UsuarioCadastroDTO usuarioCadastroDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCadastroDTO.getNome());
        usuario.setEmail(usuarioCadastroDTO.getEmail());
        usuario.setSenha(usuarioCadastroDTO.getSenha());
        usuario.setTelefone(usuarioCadastroDTO.getTelefone());
        usuario.setFotoPerfil(usuarioCadastroDTO.getFotoPerfil());
        usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(usuarioCadastroDTO.getTipoUsuario()));

        usuario = repo.save(usuario);
        return converterParaDTO(usuario); 
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOptional = repo.findById(id);
        if (usuarioOptional.isPresent()) {
            return converterParaDTO(usuarioOptional.get()); 
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioCadastroDTO usuarioCadastroDTO) {
        Optional<Usuario> usuarioOptional = repo.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioCadastroDTO.getNome());
            usuario.setEmail(usuarioCadastroDTO.getEmail());
            usuario.setSenha(usuarioCadastroDTO.getSenha());
            usuario.setTelefone(usuarioCadastroDTO.getTelefone());
            usuario.setFotoPerfil(usuarioCadastroDTO.getFotoPerfil());
            usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(usuarioCadastroDTO.getTipoUsuario()));

            usuario = repo.save(usuario);
            return converterParaDTO(usuario); 
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void deletarUsuario(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public List<UsuarioDTO> listarUsuarios() {
        return repo.findAll().stream()
                .map(this::converterParaDTO) 
                .collect(Collectors.toList());
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setFotoPerfil(usuario.getFotoPerfil());
        dto.setTipoUsuario(usuario.getTipoUsuario().toString());
        return dto;
    }
}