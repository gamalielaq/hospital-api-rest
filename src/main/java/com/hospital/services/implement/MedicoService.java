package com.hospital.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.dao.IMedicoDao;
import com.hospital.models.entity.Medico;
import com.hospital.services.IMedicoService;

@Service
public class MedicoService implements IMedicoService {

	@Autowired
	IMedicoDao clienteDao;
	
	@Override
	 @Transactional(readOnly = true)
	public List<Medico> findAll() {
		return (List<Medico>) this.clienteDao.findAll();
	}

	@Override
	public Medico save(Medico medico) {
		return this.clienteDao.save(medico);
	}

	@Override
	public void delete(Long id) {
		this.clienteDao.deleteById(id);
		
	}

	@Override
	public Medico findById(Long id) {
		return this.clienteDao.findById(id).orElse(null);
	}
	
}
