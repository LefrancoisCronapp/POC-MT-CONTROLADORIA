package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela ANEXO
* @generated
*/
@Entity
@Table(name = "\"ANEXO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Anexo")
public class Anexo implements Serializable {

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
    @Column(name = "descricao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String descricao;

    /**
    * @generated
    */
    @Column(name = "conteudo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String conteudo;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_ordemServico", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private OrdemServico ordemServico;

    /**
    * Construtor
    * @generated
    */
    public Anexo(){
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
    public Anexo setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém descricao
    * return descricao
    * @generated
    */
    
    public java.lang.String getDescricao(){
        return this.descricao;
    }

    /**
    * Define descricao
    * @param descricao descricao
    * @generated
    */
    public Anexo setDescricao(java.lang.String descricao){
        this.descricao = descricao;
        return this;
    }
    /**
    * Obtém conteudo
    * return conteudo
    * @generated
    */
    
    public java.lang.String getConteudo(){
        return this.conteudo;
    }

    /**
    * Define conteudo
    * @param conteudo conteudo
    * @generated
    */
    public Anexo setConteudo(java.lang.String conteudo){
        this.conteudo = conteudo;
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
    public Anexo setOrdemServico(OrdemServico ordemServico){
        this.ordemServico = ordemServico;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Anexo object = (Anexo)obj;
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