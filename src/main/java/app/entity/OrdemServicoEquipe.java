package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela ORDEMSERVICOEQUIPE
* @generated
*/
@Entity
@Table(name = "\"ORDEMSERVICOEQUIPE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.OrdemServicoEquipe")
public class OrdemServicoEquipe implements Serializable {

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
    @JoinColumn(name="fk_equipe", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private Equipe equipe;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_ordemServico", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private OrdemServico ordemServico;

    /**
    * @generated
    */
    @Column(name = "responsavel", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean responsavel;

    /**
    * Construtor
    * @generated
    */
    public OrdemServicoEquipe(){
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
    public OrdemServicoEquipe setId(java.lang.String id){
        this.id = id;
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
    public OrdemServicoEquipe setEquipe(Equipe equipe){
        this.equipe = equipe;
        return this;
    }
    /**
    * Obtém ordemServico
    * return ordemServico
    * @generated
    */
    
    public OrdemServico getOrdemServico(){
        return this.ordemServico;
    }

    /**
    * Define ordemServico
    * @param ordemServico ordemServico
    * @generated
    */
    public OrdemServicoEquipe setOrdemServico(OrdemServico ordemServico){
        this.ordemServico = ordemServico;
        return this;
    }
    /**
    * Obtém responsavel
    * return responsavel
    * @generated
    */
    
    public java.lang.Boolean getResponsavel(){
        return this.responsavel;
    }

    /**
    * Define responsavel
    * @param responsavel responsavel
    * @generated
    */
    public OrdemServicoEquipe setResponsavel(java.lang.Boolean responsavel){
        this.responsavel = responsavel;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
OrdemServicoEquipe object = (OrdemServicoEquipe)obj;
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