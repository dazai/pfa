package tn.epi.pfa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Bloc implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int orderValue;

    private Long lessonId;

}
