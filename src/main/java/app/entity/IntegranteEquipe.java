package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela INTEGRANTEEQUIPE
* @generated
*/
@Entity
@Table(name = "\"INTEGRANTEEQUIPE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.IntegranteEquipe")
public class IntegranteEquipe implements Serializable {

    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private User user;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_equipe", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private Equipe equipe;

    /**
    * Construtor
    * @generated
    */
    public IntegranteEquipe(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    
    public java.lang.String getId(){
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public IntegranteEquipe setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém user
    * return user
    * @generated
    */
    
    public User getUser(){
        return this.user;
    }

    /**
    * Define user
    * @param user user
    * @generated
    */
    public IntegranteEquipe setUser(User user){
        this.user = user;
        return this;
    }
    /**
    * Obtém equipe
    * return equipe
    * @generated
    */
    
    public Equipe getEquipe(){
        return this.equipe;
    }

    /**
    * Define equipe
    * @param equipe equipe
    * @generated
    */
    public IntegranteEquipe setEquipe(Equipe equipe){
        this.equipe = equipe;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
IntegranteEquipe object = (IntegranteEquipe)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}