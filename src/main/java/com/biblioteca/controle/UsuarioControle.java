package com.biblioteca.controle;



import java.security.InvalidParameterException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.dtos.RoleUsuarioForm;
import com.biblioteca.modelo.Role;
import com.biblioteca.modelo.Usuario;
import com.biblioteca.repositorio.UsuarioRepositorio;



@Controller
public class UsuarioControle {
	
	private PasswordEncoder encoder;
	private UsuarioRepositorio usuarioRepo;
	private final List<String> roles;
	
	public UsuarioControle(UsuarioRepositorio usuarioRepo, PasswordEncoder encoder) {
		this.encoder = encoder;
		this.usuarioRepo = usuarioRepo;
		this.roles = Role.getRoles();
	}
	
	@GetMapping("/login")
	public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "/login";
    }
	
	@GetMapping("/gerenciar/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("listaUsuarios", usuarioRepo.findAll());
		return "gerenciar/usuarios/index";
	}
	
	@GetMapping("/gerenciar/usuarios/novo")
	public String novoUsuario(Model model) {
		
		model.addAttribute("usuario", new Usuario("", ""));
		model.addAttribute("roles", roles);
		
		return "gerenciar/usuarios/novo";
	}
	
	@GetMapping("/gerenciar/usuarios/cadastro_user")
	public String CadastrarUsuario(Model model) {
		
		model.addAttribute("usuario", new Usuario("", ""));
		model.addAttribute("roles", usuarioRepo.findByUsername("USER"));
		return  "/gerenciar/usuarios/novo";
	}
	
	@PostMapping("/gerenciar/usuarios/salvar")
	public String salvarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
		
		Usuario usuarioEncontrado = usuarioRepo.findByUsername(usuario.getUsername());
		if (usuarioEncontrado != null && usuarioEncontrado.getId() != usuario.getId()) {
			bindingResult.addError(new FieldError("usuario", "username", "Nome de usu??rio j?? est?? em uso."));
		}
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("roles", roles);
			return "gerenciar/usuarios/novo";
		}
		
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		
		usuarioRepo.save(usuario);
		return "redirect:/gerenciar/usuarios";
	}
	
	@GetMapping("/gerenciar/usuarios/excluir/{id}")
	public String excluirUsuario(@PathVariable("id") long id) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(id);
		if (usuarioOpt.isEmpty()) {
			throw new IllegalArgumentException("Usu??rio inv??lido.");
		}
		
		usuarioRepo.delete(usuarioOpt.get());
		return "redirect:/gerenciar/usuarios";
	}
	
	@GetMapping("/gerenciar/usuarios/alterar/role/{id}")
	public String getAlterarPapelUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findById(id);
		if (!usuarioOpt.isPresent()) {
			throw new IllegalArgumentException("Usu??rio inv??lido.");
		}
		
		RoleUsuarioForm roleUsuarioForm = new RoleUsuarioForm(usuarioOpt.get());
		
		model.addAttribute("roleUsuarioForm", roleUsuarioForm);
		model.addAttribute("roles", roles);
		
		return "gerenciar/usuarios/alterar_role";
	}
	
	@PostMapping("/gerenciar/usuarios/alterar/role")
	public String alterarPapelUsuario(@Valid @ModelAttribute("roleUsuarioForm") RoleUsuarioForm roleUsuarioForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("roles", roles);
			return "gerenciar/usuarios/alterar_role";
		}
		
		Usuario usuarioAlterado = usuarioRepo.findById(roleUsuarioForm.getId()).orElseThrow(() -> new InvalidParameterException("Usu??rio Inv??lido!"));
		usuarioAlterado.setRole(roleUsuarioForm.getRole());
		
		usuarioRepo.save(usuarioAlterado);
		
		return "redirect:/gerenciar/usuarios";
	}
}
