package com.ecommerce.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompraArticuloId implements Serializable {

    private Long compraId;
    private Integer articuloId;

    public CompraArticuloId() {}

    public CompraArticuloId(Long compraId, Integer articuloId) {
        this.compraId = compraId;
        this.articuloId = articuloId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraArticuloId that = (CompraArticuloId) o;
        return Objects.equals(compraId, that.compraId) &&
               Objects.equals(articuloId, that.articuloId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compraId, articuloId);
    }

    public Long getCompraId() { return compraId; }
    public void setCompraId(Long compraId) { this.compraId = compraId; }
    public Integer getArticuloId() { return articuloId; }
    public void setArticuloId(Integer articuloId) { this.articuloId = articuloId; }
}