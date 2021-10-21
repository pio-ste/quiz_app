package pl.ps.demo.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class IdField {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public IdField(Long id){
        this.id = id;
    }

    public IdField(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
