package DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@Entity
@Table(name = "user_log")
public class UserLogDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    
    @ManyToOne
    private UserDTO User;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "access_timestamp")
    private java.util.Date Timestamp;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public UserDTO getUser() {
        return User;
    }

    public void setUser(UserDTO User) {
        this.User = User;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.Timestamp = timestamp;
    }
    
    
}