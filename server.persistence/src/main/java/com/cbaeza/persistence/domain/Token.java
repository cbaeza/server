package com.cbaeza.persistence.domain;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
@Entity
@Table(name = "token", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
public class Token {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long userId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String token;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouch;

    @Basic(optional = false)
    @NotNull
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean valid;

    public Token() {
    }

    public Token(Long id) {
        this.id = id;
    }

    public Token(/*Long id,*/ Long userId, String token, Date creationDate, Date lastTouch, boolean valid) {
        //this.id = id;
        this.userId = userId;
        this.token = token;
        this.creationDate = creationDate;
        this.lastTouch = lastTouch;
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastTouch() {
        return lastTouch;
    }

    public void setLastTouch(Date lastTouch) {
        this.lastTouch = lastTouch;
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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
        if (!(object instanceof Token)) {
            return false;
        }
        Token other = (Token) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cbaeza.agenda.model.Token[ id=" + id + " ]";
    }

}
