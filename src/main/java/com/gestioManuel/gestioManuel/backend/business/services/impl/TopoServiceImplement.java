package com.gestioManuel.gestioManuel.backend.business.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioManuel.gestioManuel.backend.business.model.Topo;
import com.gestioManuel.gestioManuel.backend.business.services.TopoService;
import com.gestioManuel.gestioManuel.backend.repository.TopoRepository;

@Service
public class TopoServiceImplement implements TopoService {

	@Autowired
	private TopoRepository topoRepository;

	@Override
	public Long create(Topo topo) {
		if(topo.getId() != null) {
			throw new IllegalStateException("No se puede crear un producto con código not null");
		}
		
		Long id = System.currentTimeMillis();
		topo.setId(id);

		topoRepository.save(topo); 
		return id;
	}

	@Override
	public Optional<Topo> read(Long id) {
		return topoRepository.findById(id);
	}

	@Override
	public List<Topo> getAll() {
		return topoRepository.findAll();
	}
}