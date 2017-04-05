package motherchild;

import java.util.*;
import javax.persistence.*;

@Entity
public class Mother {
    @Id
    private String id;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL)    
    private final List<Child> children;

    public Mother() {
        id = UUID.randomUUID().toString();
        children = new ArrayList<>();
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

    public List<Child> getChildren() {
        return children;
    }  
}
