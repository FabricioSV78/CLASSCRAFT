package com.classcraft.demo.controller;

import com.classcraft.demo.model.Curso;
import com.classcraft.demo.model.usuarios.Estudiante;
import com.classcraft.demo.model.usuarios.Maestro;
import com.classcraft.demo.model.usuarios.Padre;
import com.classcraft.demo.model.usuarios.Usuario;
import com.classcraft.demo.service.UsuarioService;
import com.classcraft.demo.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        Usuario usuarioAuten;
        usuarioAuten= usuarioService.iniciarSesion(loginRequest.getCorreo(),loginRequest.getContrasena());
        return new LoginResponse(usuarioAuten.getCorreoElectronico(), usuarioAuten.getNombreU());
    }

    @PostMapping("/registro")
    public RegistroResponse registro(@RequestBody RegistroRequest registroRequest){
        Usuario usuario;
        if(registroRequest.getTipo().equals("Estudiante")){
            Padre padre=usuarioService.buscarPadre(registroRequest.getIdPadre());
            usuario= new Estudiante(registroRequest.getCorreo(),registroRequest.getNombre(),registroRequest.getContrasena(),padre);
            usuarioService.registrarUsuario(usuario);
        }
        if(registroRequest.getTipo().equals("Padre")){
            usuario= new Padre(registroRequest.getNombre(),registroRequest.getCorreo(),registroRequest.getContrasena());
            usuarioService.registrarUsuario(usuario);
        }
        if(registroRequest.getTipo().equals("Maestro")){
            usuario= new Maestro(registroRequest.getCorreo(),registroRequest.getNombre(),registroRequest.getContrasena());
            usuarioService.registrarUsuario(usuario);
        }
        return new RegistroResponse(registroRequest.getNombre());
    }

    @GetMapping("/listar")
    public List<LoginResponse> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/cambiarClave/{idUsuario}")
    public ResponseEntity<?> cambiarClave(@PathVariable Long idUsuario, @RequestBody CambioClaveDTO cambioClaveDTO) {
        try {
            usuarioService.cambiarClaveUsuario(
                    idUsuario,
                    cambioClaveDTO.getClaveActual(),
                    cambioClaveDTO.getNuevaClave()
            );
            return ResponseEntity.ok("Contraseña actualizada correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error interno del servidor");
        }
    }


}
