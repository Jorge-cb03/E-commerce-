package com.ecommerce.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ARTICULO")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Usamos Integer porque la DB admite negativos para tu lógica de borrado

    @Column(nullable = false)
    private String nombre;

    @Lob
    private String descripcion;

    @Column(name = "precio_actual", nullable = false)
    private BigDecimal precioActual;

    @Column(nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "articulo", fetch = FetchType.LAZY)
    private Set<CompraArticulo> detalleCompras = new HashSet<>();

    public Articulo() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getPrecioActual() { return precioActual; }
    public void setPrecioActual(BigDecimal precioActual) { this.precioActual = precioActual; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Set<CompraArticulo> getDetalleCompras() { return detalleCompras; }
    public void setDetalleCompras(Set<CompraArticulo> detalleCompras) { this.detalleCompras = detalleCompras; }
}