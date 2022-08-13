package com.hospital.models.response;

import java.util.List;

import com.hospital.models.entity.Medico;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MedicoResponse {
	private List<Medico> medicos;
}
