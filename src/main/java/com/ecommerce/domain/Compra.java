package com.ecommerce.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPRA")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCompra estado;

    @Column(name = "fecha_realizada")
    private LocalDateTime fechaRealizada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CompraArticulo> items = new HashSet<>();

    public enum EstadoCompra {
        PENDIENTE, ENVIADO, ENTREGADO
    }

    public Compra() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }
    public EstadoCompra getEstado() { return estado; }
    public void setEstado(EstadoCompra estado) { this.estado = estado; }
    public LocalDateTime getFechaRealizada() { return fechaRealizada; }
    public void setFechaRealizada(LocalDateTime fechaRealizada) { this.fechaRealizada = fechaRealizada; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Set<CompraArticulo> getItems() { return items; }
    public void setItems(Set<CompraArticulo> items) { this.items = items; }
}