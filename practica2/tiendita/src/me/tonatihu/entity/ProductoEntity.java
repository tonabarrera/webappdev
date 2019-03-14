package me.tonatihu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author tonatihu
 * Created on 3/13/19
 */

@Entity
@Table(name = "producto", schema = "public", catalog = "tiendita")
public class ProductoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id", nullable = false)
    private int productoId;
    @Basic
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    @Basic
    @Column(name = "existencia", nullable = false)
    private int existencia;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id",
            nullable = false)
    private CategoriaEntity categoria;


    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
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


    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return productoId == that.productoId && existencia == that.existencia && Objects.equals(
                nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, nombre, descripcion, precio, existencia);
    }

    public CategoriaEntity getCategoriasByCategoriaId() {
        return categoria;
    }

    public void setCategoriasByCategoriaId(CategoriaEntity categoriasByCategoriaId) {
        this.categoria = categoriasByCategoriaId;
    }

    @Override
    public String toString() {
        return "ProductoEntity{" + "productoId=" + productoId + ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' + ", precio=" + precio + ", existencia=" +
                existencia + ", categoria=" + categoria + '}';
    }
}
