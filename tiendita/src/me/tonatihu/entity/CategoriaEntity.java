package me.tonatihu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author tonatihu
 * Created on 3/13/19
 */

@Entity
@Table(name = "categoria", schema = "public", catalog = "tiendita")
public class CategoriaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id", nullable = false)
    private int categoriaId;
    @Basic
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<ProductoEntity> productos = new ArrayList<>();

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
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


    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos) {
        this.productos = productos;
    }

    public void addProducto(ProductoEntity producto) {
        this.productos.add(producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return categoriaId == that.categoriaId && Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriaId, nombre, descripcion);
    }

    @Override
    public String toString() {
        return "CategoriaEntity{" + "categoriaId=" + categoriaId + ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' + '}';
    }
}
