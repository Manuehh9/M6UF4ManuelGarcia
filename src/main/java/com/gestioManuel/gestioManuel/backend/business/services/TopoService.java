package com.gestioManuel.gestioManuel.backend.business.services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestioManuel.gestioManuel.backend.business.model.Topo;

@Service
public interface TopoService {

	Long create(Topo topo);           //C
	Optional<Topo> read(Long id);     //R
	List<Topo> getAll();
}
