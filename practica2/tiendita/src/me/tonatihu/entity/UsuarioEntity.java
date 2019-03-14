package me.tonatihu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author tonatihu
 * Created on 3/13/19
 */
@Entity
@Table(name = "usuario", schema = "public", catalog = "tiendita")
public class UsuarioEntity implements Serializable {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
