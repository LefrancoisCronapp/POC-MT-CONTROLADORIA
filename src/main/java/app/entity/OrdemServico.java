package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela ORDEMSERVICO
* @generated
*/
@Entity
@Table(name = "\"ORDEMSERVICO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.OrdemServico")
public class OrdemServico implements Serializable {

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
    @Temporal(TemporalType.DATE)
    @Column(name = "ano", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date ano;

    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "previsao_inicio", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date previsao_inicio;

    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "previsao_fim", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date previsao_fim;

    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inclusao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data_inclusao;

    /**
    * @generated
    */
    @Column(name = "conteudo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String conteudo;

    /**
    * @generated
    */
    @Column(name = "descricao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String descricao;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private User user;

    /**
    * Construtor
    * @generated
    */
    public OrdemServico(){
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
    public OrdemServico setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém ano
    * return ano
    * @generated
    */
    
    public java.util.Date getAno(){
        return this.ano;
    }

    /**
    * Define ano
    * @param ano ano
    * @generated
    */
    public OrdemServico setAno(java.util.Date ano){
        this.ano = ano;
        return this;
    }
    /**
    * Obtém previsao_inicio
    * return previsao_inicio
    * @generated
    */
    
    public java.util.Date getPrevisao_inicio(){
        return this.previsao_inicio;
    }

    /**
    * Define previsao_inicio
    * @param previsao_inicio previsao_inicio
    * @generated
    */
    public OrdemServico setPrevisao_inicio(java.util.Date previsao_inicio){
        this.previsao_inicio = previsao_inicio;
        return this;
    }
    /**
    * Obtém previsao_fim
    * return previsao_fim
    * @generated
    */
    
    public java.util.Date getPrevisao_fim(){
        return this.previsao_fim;
    }

    /**
    * Define previsao_fim
    * @param previsao_fim previsao_fim
    * @generated
    */
    public OrdemServico setPrevisao_fim(java.util.Date previsao_fim){
        this.previsao_fim = previsao_fim;
        return this;
    }
    /**
    * Obtém data_inclusao
    * return data_inclusao
    * @generated
    */
    
    public java.util.Date getData_inclusao(){
        return this.data_inclusao;
    }

    /**
    * Define data_inclusao
    * @param data_inclusao data_inclusao
    * @generated
    */
    public OrdemServico setData_inclusao(java.util.Date data_inclusao){
        this.data_inclusao = data_inclusao;
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
    public OrdemServico setConteudo(java.lang.String conteudo){
        this.conteudo = conteudo;
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
    public OrdemServico setDescricao(java.lang.String descricao){
        this.descricao = descricao;
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
    public OrdemServico setUser(User user){
        this.user = user;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
OrdemServico object = (OrdemServico)obj;
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