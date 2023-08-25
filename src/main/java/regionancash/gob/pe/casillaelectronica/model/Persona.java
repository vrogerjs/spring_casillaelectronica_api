package regionancash.gob.pe.casillaelectronica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    private Long id;

    @Column(nullable = false, length = 32)
    private String nroDocumento;

    @Column(nullable = true, length = 200)
    private String apellidoNombre;

    @Column(nullable = true, length = 512)
    private String direccion;

    @Column(nullable = true, length = 512)
    private String email;

    @Column(nullable = true, length = 16)
    private String celular;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

   /* @JsonIgnore
    @OneToMany(mappedBy="persona")
    private Set<Remitente> remitentes;

    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private Set<Destinatario> destinatarios;*/

    @JsonIgnore
    @OneToMany(mappedBy="persona")
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
