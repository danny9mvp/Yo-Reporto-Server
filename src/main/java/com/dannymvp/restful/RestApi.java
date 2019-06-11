package com.dannymvp.restful;

import com.dannymvp.entities.Reporte;
import com.dannymvp.entities.Usuario;
import com.dannymvp.entities.UsuarioResidencia;
import com.dannymvp.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/rest")
public class RestApi {
    @Autowired
    private IReporteService iReporteService;
    @Autowired
    private IUsuarioService iUsuarioService;
    @Autowired
    private IUsuarioResidenciaService iUsuarioResidenciaService;
    @Autowired
    private IDepartamentoService iDepartamentoService;
    @Autowired
    private IMunicipioService iMunicipioService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestParam("usuario") String jsonUsuario,
                                    @RequestParam("usuarioResidencia") String jsonUsuarioResidencia){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Usuario nuevoUsuario = mapper.readValue(jsonUsuario, Usuario.class);
            UsuarioResidencia usuarioResidencia = mapper.readValue(jsonUsuarioResidencia, UsuarioResidencia.class);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String passCifrada = passwordEncoder.encode(nuevoUsuario.getUsuPass());
            nuevoUsuario.setUsuPass(passCifrada);
            iUsuarioService.crearUsuario(nuevoUsuario);
            iUsuarioResidenciaService.crearUsuarioResidencia(usuarioResidencia);
            return ResponseEntity.ok("Tu cuenta ha sido creada exitosamente. Bienvenido a Yo Reporto.");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(500).body("Error en el servidor, por favor intente de nuevo.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam(value = "nick", required=false) String nick, @RequestParam(value="pass", required=false) String pass){
        try{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Optional<Usuario> usuarioEncontrado = iUsuarioService.buscarUsuario(nick);
            if(usuarioEncontrado.isPresent() && bCryptPasswordEncoder.matches(pass, usuarioEncontrado.get().getUsuPass()))
                if(usuarioEncontrado.get().getUsuActivo()) {
                    return ResponseEntity.ok(usuarioEncontrado.get().getUsuNick());
                }
                else
                    return ResponseEntity.status(404).body("Su cuenta se encuentra inactiva. Por favor contacte con el " +
                            "administrador para gestionar su reactivación.");
            else
                return ResponseEntity.status(404).body("El usuario y la contraseña no coinciden.");
        }
        catch(Exception ex){
            return ResponseEntity.status(500).body("Error en el servidor.");
        }
    }
    @PostMapping("/crearReporte")
    public ResponseEntity<?> crearReporte(@RequestBody Reporte reporte){
        try{
            iReporteService.crearReporte(reporte);
            return ResponseEntity.ok("Reporte creado.");
        }
        catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/reportes")
    public ResponseEntity<?> reportes(){
        List<Reporte> reportes = iReporteService.listarReportes();
        return ResponseEntity.ok(reportes);
    }
    @GetMapping("/reportes/{nick}")
    public ResponseEntity<?> reportesPorUsuario(@PathParam("nick") String nick){
        try {
            List<Reporte> reportes = iReporteService.listarReportesPorUsuario(nick);
            if(reportes.isEmpty())
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(reportes);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/departamentos")
    public ResponseEntity<?> departamentos(){
        try{
            return ResponseEntity.ok(iDepartamentoService.listarDepartamentos());
        }
        catch (Exception ex){
            return ResponseEntity.status(500).body("Ha ocurrido un error al listar departamentos.");
        }
    }
    @GetMapping("/municipios")
    public ResponseEntity<?> municipios(){
        try{
            return ResponseEntity.ok(iMunicipioService.listarMunicipios());
        }
        catch (Exception ex){
            return ResponseEntity.status(500).body("Ha ocurrido un error al listar municipios.");
        }
    }
}
