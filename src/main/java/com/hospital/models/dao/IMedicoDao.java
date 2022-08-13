package com.hospital.models.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.models.entity.Medico;

public interface IMedicoDao extends JpaRepository<Medico, Long> {
	
	public List<Medico> findAll();
}
