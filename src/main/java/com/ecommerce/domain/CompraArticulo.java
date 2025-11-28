package com.ecommerce.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "COMPRA_ARTICULO")
public class CompraArticulo {

    @EmbeddedId
    private CompraArticuloId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articuloId")
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    @Column(nullable = false)
    private Integer unidades;

    @Column(name = "precio_compra", nullable = false)
    private BigDecimal precioCompra;

    public CompraArticulo() {}

    // Getters y Setters
    public CompraArticuloId getId() { return id; }
    public void setId(CompraArticuloId id) { this.id = id; }
    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }
    public Articulo getArticulo() { return articulo; }
    public void setArticulo(Articulo articulo) { this.articulo = articulo; }
    public Integer getUnidades() { return unidades; }
    public void setUnidades(Integer unidades) { this.unidades = unidades; }
    public BigDecimal getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(BigDecimal precioCompra) { this.precioCompra = precioCompra; }
}