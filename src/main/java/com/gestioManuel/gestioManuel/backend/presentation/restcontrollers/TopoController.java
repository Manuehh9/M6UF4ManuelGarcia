package com.gestioManuel.gestioManuel.backend.presentation.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestioManuel.gestioManuel.backend.business.model.Topo;
import com.gestioManuel.gestioManuel.backend.business.services.TopoService;
import com.gestioManuel.gestioManuel.backend.presentation.config.RespuestaError;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topos")
public class TopoController {

    @Autowired
    private TopoService topoService;

    @GetMapping
    public List<Topo> getAll() {
        return topoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        if (id > 300) {
            throw new IllegalArgumentException("El número " + id + " no es válido.");
        }

        Optional<Topo> optional = topoService.read(id);

        if (optional.isEmpty()) {
            RespuestaError respuestaError = new RespuestaError("No se encuentra el topo con id " + id);
            return ResponseEntity.badRequest().body(respuestaError); // Cambiado a badRequest
        }

        return ResponseEntity.ok(optional.get());
    }

    @ExceptionHandler({IllegalArgumentException.class, ClassCastException.class})
    public ResponseEntity<?> handleBadRequest(Exception e) {
        RespuestaError respuestaError = new RespuestaError(e.getMessage());
        return ResponseEntity.badRequest().body(respuestaError);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleInternalServerError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RespuestaError("Error interno del servidor: " + e.getMessage()));
    }
}

