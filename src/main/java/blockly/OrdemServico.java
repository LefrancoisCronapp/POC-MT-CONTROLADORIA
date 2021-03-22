package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class OrdemServico {

public static final int TIMEOUT = 300;

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var cadastrarOrdemServico(@ParamMetaData(description = "json_os") Var json_os) throws Exception {
 return new Callable<Var>() {

   private Var erro = Var.VAR_NULL;
   private Var id_os = Var.VAR_NULL;
   private Var orgao = Var.VAR_NULL;
   private Var equipe = Var.VAR_NULL;
   private Var anexo = Var.VAR_NULL;
   private Var ret = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        cronapi.database.Operations.beginTransaction(Var.valueOf("app.entity.OrdemServico"));

        cronapi.database.Operations.beginTransaction(Var.valueOf("app.entity.OrdemServicoOrgao"));

        cronapi.database.Operations.beginTransaction(Var.valueOf("app.entity.OrdemServicoEquipe"));

        cronapi.database.Operations.beginTransaction(Var.valueOf("app.entity.Anexo"));

        id_os =
        cronapi.math.Operations.sum(
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.OrdemServico"),Var.valueOf("select MAX(o.id) from OrdemServico o")))),
        Var.valueOf(1));

        cronapi.database.Operations.insert(Var.valueOf("app.entity.OrdemServico"),Var.valueOf("conteudo",
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("conteudo"))),Var.valueOf("ano",
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("ano"))),Var.valueOf("previsao_inicio",
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("data_inicio"))),Var.valueOf("data_inclusao",
        cronapi.dateTime.Operations.getNowNoHour()),Var.valueOf("id",id_os),Var.valueOf("previsao_fim",
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("data_termino"))),Var.valueOf("user",
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))))),Var.valueOf("descricao",
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("descricao"))));

        for (Iterator it_orgao =
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("orgaos_selecionados")).iterator(); it_orgao.hasNext();) {
            orgao = Var.valueOf(it_orgao.next());

            cronapi.database.Operations.insert(Var.valueOf("app.entity.OrdemServicoOrgao"),Var.valueOf("orgao",
            cronapi.json.Operations.getJsonOrMapField(orgao,
            Var.valueOf("id"))),Var.valueOf("id",
            cronapi.util.Operations.generateUUID()),Var.valueOf("ordemServico",id_os));
        } // end for

        for (Iterator it_equipe =
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("equipes_selecionadas")).iterator(); it_equipe.hasNext();) {
            equipe = Var.valueOf(it_equipe.next());

            cronapi.database.Operations.insert(Var.valueOf("app.entity.OrdemServicoEquipe"),Var.valueOf("id",
            cronapi.util.Operations.generateUUID()),Var.valueOf("ordemServico",id_os),Var.valueOf("equipe",
            cronapi.json.Operations.getJsonOrMapField(equipe,
            Var.valueOf("id"))),Var.valueOf("responsavel",
            /*# sourceMappingStart=:{{4BPhRH,F_E#R@]26O */
            Var.valueOf(
            cronapi.json.Operations.getJsonOrMapField(equipe,
            Var.valueOf("nome")).equals(
            cronapi.json.Operations.getJsonOrMapField(
            cronapi.json.Operations.getJsonOrMapField(json_os,
            Var.valueOf("equipe_responsavel")),
            Var.valueOf("nome")))).getObjectAsBoolean() ?
            Var.VAR_TRUE :
            Var.VAR_FALSE));
        } // end for

        for (Iterator it_anexo =
        cronapi.json.Operations.getJsonOrMapField(json_os,
        Var.valueOf("anexos")).iterator(); it_anexo.hasNext();) {
            anexo = Var.valueOf(it_anexo.next());

            cronapi.json.Operations.setJsonOrMapField(anexo,
            Var.valueOf("$$hashKey"),
            Var.valueOf(""));

            anexo =
            cronapi.text.Operations.replace(anexo,
            Var.valueOf(",\"$$hashKey\":\"\""),
            Var.valueOf(""));

            cronapi.database.Operations.insert(Var.valueOf("app.entity.Anexo"),Var.valueOf("extensao",
            cronapi.json.Operations.getJsonOrMapField(anexo,
            Var.valueOf("fileExtension"))),Var.valueOf("nome_arquivo",
            cronapi.json.Operations.getJsonOrMapField(anexo,
            Var.valueOf("name"))),Var.valueOf("path",
            cronapi.json.Operations.getJsonOrMapField(anexo,
            Var.valueOf("path"))),Var.valueOf("arquivo",anexo),Var.valueOf("id",
            cronapi.util.Operations.generateUUID()),Var.valueOf("ordemServico",id_os));
        } // end for

        cronapi.database.Operations.commitTransaction(Var.valueOf("app.entity.OrdemServico"));

        cronapi.database.Operations.commitTransaction(Var.valueOf("app.entity.OrdemServicoOrgao"));

        cronapi.database.Operations.commitTransaction(Var.valueOf("app.entity.OrdemServicoEquipe"));

        cronapi.database.Operations.commitTransaction(Var.valueOf("app.entity.Anexo"));

        ret =
        Var.VAR_TRUE;
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

        cronapi.database.Operations.rollbackTransaction(Var.valueOf("app.entity.OrdemServico"));

        cronapi.database.Operations.rollbackTransaction(Var.valueOf("app.entity.OrdemServicoOrgao"));

        cronapi.database.Operations.rollbackTransaction(Var.valueOf("app.entity.OrdemServicoEquipe"));

        cronapi.database.Operations.rollbackTransaction(Var.valueOf("app.entity.Anexo"));

        ret =
        Var.VAR_FALSE;
     }
    return ret;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var recuperarListaEquipes(@ParamMetaData(description = "id2") Var id2) throws Exception {
 return new Callable<Var>() {

   private Var lista_equipes = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        lista_equipes =
        cronapi.database.Operations.query(Var.valueOf("app.entity.OrdemServicoEquipe"),Var.valueOf("select o from OrdemServicoEquipe o where o.ordemServico.id = :ordemServicoId"),Var.valueOf("ordemServicoId",id2));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Erro ao recuperar Ordem de Serviço!"));
     }
    return lista_equipes;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var recuperarOrdemServicoById(@ParamMetaData(description = "id2") Var id2) throws Exception {
 return new Callable<Var>() {

   private Var erro = Var.VAR_NULL;
   private Var os = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        os =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.OrdemServico"),Var.valueOf("select o from OrdemServico o where o.id = :id"),Var.valueOf("id",id2))));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Erro ao recuperar Ordem de Serviço!"));
     }
    return os;
   }
 }.call();
}

}

