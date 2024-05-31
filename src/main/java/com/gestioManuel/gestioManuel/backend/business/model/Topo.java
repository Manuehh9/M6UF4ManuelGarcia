package com.gestioManuel.gestioManuel.backend.business.model;

import java.util.Date;

public class Topo {

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String familia;

    private Date fechaAlta;

    private boolean descatalogado;

    public Topo() {
    }

    // Constructor con todos los campos
    public Topo(Long id, String nombre, String descripcion, Double precio, String familia, Date fechaAlta, boolean descatalogado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.familia = familia;
        this.fechaAlta = fechaAlta;
        this.descatalogado = descatalogado;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isDescatalogado() {
        return descatalogado;
    }

    public void setDescatalogado(boolean descatalogado) {
        this.descatalogado = descatalogado;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    // hashCode, equals y toString
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Topo other = (Topo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Topo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", familia=" + familia + ", fechaAlta=" + fechaAlta + ", descatalogado=" + descatalogado + "]";
    }
}
