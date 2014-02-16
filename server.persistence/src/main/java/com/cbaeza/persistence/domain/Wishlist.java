package com.cbaeza.persistence.domain;

/**
 * User: cbaeza
 * Since: 16.02.14
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cbaeza
 */
@Entity
@Table(name = "wishlist")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w"),
        @NamedQuery(name = "Wishlist.findById", query = "SELECT w FROM Wishlist w WHERE w.id = :id"),
        @NamedQuery(name = "Wishlist.findByUserid", query = "SELECT w FROM Wishlist w WHERE w.userid = :userid"),
        @NamedQuery(name = "Wishlist.findByProductid", query = "SELECT w FROM Wishlist w WHERE w.productid = :productid"),
        @NamedQuery(name = "Wishlist.findByProducttype", query = "SELECT w FROM Wishlist w WHERE w.producttype = :producttype"),
        @NamedQuery(name = "Wishlist.findByCreationdate", query = "SELECT w FROM Wishlist w WHERE w.creationdate = :creationdate")})
public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String productid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String producttype;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;

    public Wishlist() {
    }

    public Wishlist(Long id) {
        this.id = id;
    }

    public Wishlist(Long id, Long userid, String productid, String producttype, Date creationdate) {
        this.id = id;
        this.userid = userid;
        this.productid = productid;
        this.producttype = producttype;
        this.creationdate = creationdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cbaeza.agenda.model.Wishlist[ id=" + id + " ]";
    }

}

