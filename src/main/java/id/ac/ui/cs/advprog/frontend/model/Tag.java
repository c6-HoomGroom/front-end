package id.ac.ui.cs.advprog.frontend.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class Tag {
    private UUID id;
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this();
        this.setName(name);
    }
}