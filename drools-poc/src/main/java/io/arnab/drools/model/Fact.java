package io.arnab.drools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fact {
    @Position(0)
    String element;

    @Position(1)
    String place;
}
