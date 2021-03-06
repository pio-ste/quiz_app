package pl.ps.demo.model.entity;

import javax.persistence.*;

@MappedSuperclass
public class IdField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public IdField(Long id) {
        this.id = id;
    }

    public IdField() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected IdField(final Builder<?> builder) {
        this.id = builder.id;
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }


    public abstract static class Builder<T extends Builder<T>> {

        private Long id;

        public abstract T getThis();

        public T id(final Long id) {
            this.id = id;
            return this.getThis();
        }

        public IdField build() {
            IdField idField = new IdField();
            idField.id = this.id;
            return idField;
        }
    }
}
