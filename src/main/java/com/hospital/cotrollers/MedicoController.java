package com.hospital.cotrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.exeption.ExceptionHandler;
import com.hospital.models.entity.Medico;
import com.hospital.services.IMedicoService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = { "/", "/api" })
public class MedicoController extends ExceptionHandler {

	@Autowired
	IMedicoService clienteService;

	@GetMapping("/medicos")
	public List<Medico> getAll() {
		return this.clienteService.findAll();
	}

	@GetMapping("/home")
	public String showUser() {
		throw new Error("Este correo electronico ya esta siendo usado OK");
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Medico.class)))
	})
	@PostMapping("/medicos")
	public ResponseEntity<?> save(@RequestBody Medico medico, BindingResult result) {
		return ResponseEntity.ok(this.clienteService.save(medico));
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Medico.class))),
			@ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content)
	})
	@GetMapping("/medicos/{id}")
	public ResponseEntity<?> getFindId(@PathVariable Long id) {
		Medico medico = this.clienteService.findById(id);
		if (medico != null) {
			return new ResponseEntity<Medico>(medico, HttpStatus.OK);
		}
		return new ResponseEntity<Medico>(HttpStatus.NOT_FOUND);
	}

	// public ResponseEntity<?> save(@RequestBody Medico medico, BindingResult
	// result) {
	// Medico newMedico = null;
	// Map<String, Object> response = new HashMap<>();
	// try {
	// newMedico = this.clienteService.save(medico);
	// } catch (Exception e) {
	// response.put("message", "Error al realizar el insert en la base de datos");
	// response.put("error", e.getMessage().concat(": "));
	// return new ResponseEntity<Map<String, Object>>(response,
	// HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	// response.put("medico", newMedico);
	// return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	//
	// }
}
