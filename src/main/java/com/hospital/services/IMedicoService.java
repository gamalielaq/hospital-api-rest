package com.hospital.services;

import java.util.List;

import com.hospital.models.entity.Medico;

public interface IMedicoService {
	public List<Medico> findAll();
	
	public Medico save(Medico medico);
	
	public void delete(Long id);
	
	public Medico findById(Long id);
}
