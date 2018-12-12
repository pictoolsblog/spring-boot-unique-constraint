package com.pictools.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static com.pictools.constraint.Constraints.UNIQUE_STATUS_NAME;

@Entity
@Table(name = "Status", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}, name = UNIQUE_STATUS_NAME))
public class Status {
    @Id
    @Column(name = "nID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id) &&
                Objects.equals(name, status.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
