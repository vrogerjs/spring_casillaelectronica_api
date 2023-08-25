package regionancash.gob.pe.casillaelectronica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dependencias")
public class Dependencia {
    @Id
    private Long id;

    @Column(nullable = false, length = 256, unique = true)
    private String name;

    @Column(length = 32)
    private String abreviatura;

   /* @Column(length = 256)
    private String apellidoNombreResponsable;

    @Column(length = 256)
    private String cargoResponsable;

    @Column(length = 256)
    private String emailResponsable;*/

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

    @JsonIgnore
    @OneToMany(mappedBy="dependencia")
    private Set<Notificacion> notificacions;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date updatedAt;

}
