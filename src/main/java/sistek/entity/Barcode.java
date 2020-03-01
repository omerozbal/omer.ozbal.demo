package sistek.entity;

import javax.persistence.*;

@Entity
public class Barcode {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String barcodeCode;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcodeCode() {
        return barcodeCode;
    }

    public void setBarcodeCode(String barcodeCode) {
        this.barcodeCode = barcodeCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
