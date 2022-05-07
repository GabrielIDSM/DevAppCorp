package DTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@Entity
@Table(name = "system_variable_conf")
public class SystemVariableDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String Name;
    
    @Column(name = "data_value", unique = true, nullable = false)
    private String Value;
    
    @ManyToOne
    private SystemVariableTypeDTO SystemVariableType;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public SystemVariableTypeDTO getSystemVariableType() {
        return SystemVariableType;
    }

    public void setSystemVariableType(SystemVariableTypeDTO SystemVariableType) {
        this.SystemVariableType = SystemVariableType;
    }
}