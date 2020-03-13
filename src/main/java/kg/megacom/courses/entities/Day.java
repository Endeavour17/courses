package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "days")
public class Day {
    @Id
    @Column(name = "day_id")
    private Long id;
    private String name;
    private boolean active;
}
