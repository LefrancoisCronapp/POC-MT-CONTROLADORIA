package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
    import cronapi.CronapiByteHeaderSignature;


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
    @Column(name = "arquivo", nullable = true, unique = false, insertable=true, updatable=true)
    @CronapiByteHeaderSignature
        
        private byte[] arquivo;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_ordemServico", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private OrdemServico ordemServico;

    /**
    * @generated
    */
    @Column(name = "path", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String path;

    /**
    * @generated
    */
    @Column(name = "nome_arquivo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome_arquivo;

    /**
    * @generated
    */
    @Column(name = "extensao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String extensao;

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
    * Obtém arquivo
    * return arquivo
    * @generated
    */
    
    public byte[] getArquivo(){
        return this.arquivo;
    }

    /**
    * Define arquivo
    * @param arquivo arquivo
    * @generated
    */
    public Anexo setArquivo(byte[] arquivo){
        this.arquivo = arquivo;
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
    * Obtém path
    * return path
    * @generated
    */
    
    public java.lang.String getPath(){
        return this.path;
    }

    /**
    * Define path
    * @param path path
    * @generated
    */
    public Anexo setPath(java.lang.String path){
        this.path = path;
        return this;
    }
    /**
    * Obtém nome_arquivo
    * return nome_arquivo
    * @generated
    */
    
    public java.lang.String getNome_arquivo(){
        return this.nome_arquivo;
    }

    /**
    * Define nome_arquivo
    * @param nome_arquivo nome_arquivo
    * @generated
    */
    public Anexo setNome_arquivo(java.lang.String nome_arquivo){
        this.nome_arquivo = nome_arquivo;
        return this;
    }
    /**
    * Obtém extensao
    * return extensao
    * @generated
    */
    
    public java.lang.String getExtensao(){
        return this.extensao;
    }

    /**
    * Define extensao
    * @param extensao extensao
    * @generated
    */
    public Anexo setExtensao(java.lang.String extensao){
        this.extensao = extensao;
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