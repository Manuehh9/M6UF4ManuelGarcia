package com.gestioManuel.gestioManuel.backend.business.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.gestioManuel.gestioManuel.backend.business.model.Topo;
import com.gestioManuel.gestioManuel.backend.business.services.TopoService;

@Service
public class TopoServiceImplement implements TopoService {

private TreeMap<Long, Topo> topo = new TreeMap<>();
	
	public TopoServiceImplement() {
		init();
	}

	@Override
	public Long create(Topo tapa) {
		Long id = topo.lastKey() + 1;
		
		tapa.setId(id);
		
		topo.put(tapa.getId(), tapa);
		
		return id;
	}

	@Override
	public Optional<Topo> read(Long id) {
		return Optional.ofNullable(topo.get(id));
	}

	@Override
	public List<Topo> getAll() {
		return new ArrayList<>(topo.values());
	}
	
	// ***************************************************************
	//
	// Private Methods
	//
	// ***************************************************************

	private void init() {
		
		Topo p1 = new Topo();
        Topo p2 = new Topo();
        Topo p3 = new Topo();

        p1.setId(10L);
        p1.setNombre("Topo Común");
        p1.setPrecio(150.0);
        p1.setDescripcion("El topo común es un mamífero pequeño que vive bajo tierra y es conocido por su habilidad para cavar túneles.");
        p1.setDescatalogado(false);
        p1.setFamilia("Mamífero");
        p1.setFechaAlta(new Date(100000000L));

        p2.setId(11L);
        p2.setNombre("Topo de Nariz Estrellada");
        p2.setPrecio(560.0);
        p2.setDescripcion("El topo de nariz estrellada es fácilmente reconocible por sus apéndices nasales que le permiten detectar presas rápidamente.");
        p2.setDescatalogado(false);
        p2.setFamilia("Mamífero");
        p2.setFechaAlta(new Date(100000100L));

        p3.setId(12L);
        p3.setNombre("Topo Dorado");
        p3.setPrecio(90.0);
        p3.setDescripcion("El topo dorado es una especie de topo que se encuentra en el sur de África y es conocido por su pelaje brillante y dorado.");
        p3.setDescatalogado(false);
        p3.setFamilia("Mamífero");
        p3.setFechaAlta(new Date(100000600L));

        topo.put(p1.getId(), p1);
        topo.put(p2.getId(), p2);
        topo.put(p3.getId(), p3);
		
	}
}