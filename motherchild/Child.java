package motherchild;

import java.util.UUID;
import javax.persistence.*;

@Entity
public class Child {

    @Id
    private String id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)   
    private final Mother mother;

    public Child() {
        this.mother = null;
    }
    
    

    public Child(Mother mother) {
        id = UUID.randomUUID().toString();
        this.mother = mother;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mother getMother() {
        return mother;
    }
}
