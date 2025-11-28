package com.ecommerce.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "INFORMACION_FISCAL")
public class InformacionFiscal {

    @Id
    @Column(name = "nif_cif", length = 20)
    private String nifCif;

    @Column(name = "direccion_fiscal", nullable = false)
    private String direccionFiscal;

    private String telefono;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", unique = true, nullable = false)
    private Cliente cliente;

    public InformacionFiscal() {}

    public InformacionFiscal(String nifCif, String direccionFiscal, String telefono) {
        this.nifCif = nifCif;
        this.direccionFiscal = direccionFiscal;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNifCif() { return nifCif; }
    public void setNifCif(String nifCif) { this.nifCif = nifCif; }
    public String getDireccionFiscal() { return direccionFiscal; }
    public void setDireccionFiscal(String direccionFiscal) { this.direccionFiscal = direccionFiscal; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}