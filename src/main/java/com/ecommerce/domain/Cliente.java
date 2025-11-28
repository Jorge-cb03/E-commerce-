package com.ecommerce.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // Relación 1:1 con Cascada total. Si borras Cliente, se lleva la Info Fiscal.
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    private InformacionFiscal informacionFiscal;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Compra> compras = new HashSet<>();

    public Cliente() {}

    public Cliente(String nombreCompleto, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaRegistro = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public InformacionFiscal getInformacionFiscal() { return informacionFiscal; }
    
    public void setInformacionFiscal(InformacionFiscal informacionFiscal) {
        if (informacionFiscal == null) {
            if (this.informacionFiscal != null) {
                this.informacionFiscal.setCliente(null);
            }
        } else {
            informacionFiscal.setCliente(this);
        }
        this.informacionFiscal = informacionFiscal;
    }
    
    public Set<Compra> getCompras() { return compras; }
    public void setCompras(Set<Compra> compras) { this.compras = compras; }
}