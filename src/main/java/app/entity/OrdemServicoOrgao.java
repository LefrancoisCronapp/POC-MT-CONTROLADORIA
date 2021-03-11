package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela ORDEMSERVICOORGAO
* @generated
*/
@Entity
@Table(name = "\"ORDEMSERVICOORGAO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.OrdemServicoOrgao")
public class OrdemServicoOrgao implements Serializable {

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
    @JoinColumn(name="fk_ordemServico", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private OrdemServico ordemServico;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_orgao", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private Orgao orgao;

    /**
    * Construtor
    * @generated
    */
    public OrdemServicoOrgao(){
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
    public OrdemServicoOrgao setId(java.lang.String id){
        this.id = id;
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
    public OrdemServicoOrgao setOrdemServico(OrdemServico ordemServico){
        this.ordemServico = ordemServico;
        return this;
    }
    /**
    * Obtém orgao
    * return orgao
    * @generated
    */
    
    public Orgao getOrgao(){
        return this.orgao;
    }

    /**
    * Define orgao
    * @param orgao orgao
    * @generated
    */
    public OrdemServicoOrgao setOrgao(Orgao orgao){
        this.orgao = orgao;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
OrdemServicoOrgao object = (OrdemServicoOrgao)obj;
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