window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.LoggedHome = window.blockly.js.blockly.LoggedHome || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.validarArgs = [];
window.blockly.js.blockly.LoggedHome.validar = async function() {
 var os;
  ret = true;
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.ano"))) {
    this.cronapi.screen.changeContent("tab_dados", '<i class=\"glyphicon glyphicon-alert\"></i> Dados da O.S.', 'false');
    this.cronapi.screen.changeContent("label_ano", 'Ano <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"O ano não pode ser vazio.\" class=\"fa fa-exclamation\"></i>\n', 'false');
    ret = false;
  } else {
    if (this.cronapi.screen.getValueOfField("vars.ano") > 2021 || this.cronapi.screen.getValueOfField("vars.ano") < 2016) {
      this.cronapi.screen.changeContent("tab_dados", '<i class=\"glyphicon glyphicon-alert\"></i> Dados da O.S.', 'false');
      this.cronapi.screen.changeContent("label_ano", 'Ano <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"O ano deve compreender o período de 2016 a 2021.\" class=\"fa fa-exclamation\"></i>\n', 'false');
      ret = false;
    }
  }
  if (this.cronapi.dateTime.getDaysBetweenDates(this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.termino")), this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.inicio"))) < 0) {
    this.cronapi.screen.changeContent("tab_dados", '<i class=\"glyphicon glyphicon-alert\"></i> Dados da O.S.', 'false');
    this.cronapi.screen.changeContent("label_dataTermino", 'Previsão Término <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"A data de término não pode ser anterior a data de início.\" class=\"fa fa-exclamation\"></i>\n', 'false');
    ret = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.descricao"))) {
    this.cronapi.screen.changeContent("tab_dados", '<i class=\"glyphicon glyphicon-alert\"></i> Dados da O.S.', 'false');
    this.cronapi.screen.changeContent("label_descricao", 'Descrição <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"A descrição não pode ser vazia.\" class=\"fa fa-exclamation\"></i>\n', 'false');
    ret = false;
  }
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.conteudo"))) {
    this.cronapi.screen.changeContent("tab_dados", '<i class=\"glyphicon glyphicon-alert\"></i> Dados da O.S.', 'false');
    this.cronapi.screen.changeContent("label_conteudo", 'Conteúdo <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"O conteúdo não pode ser vazio.\" class=\"fa fa-exclamation\"></i>\n', 'false');
    ret = false;
  }
  if (this.cronapi.json.getProperty(this.cronapi.screen.getScopeVariable("ordem_servico"), 'orgaos_selecionados').length == 0) {
    this.cronapi.screen.changeContent("tab_orgaos", '<i class=\"glyphicon glyphicon-alert\"></i> Orgãos.', 'false');
    this.cronapi.screen.changeContent("label_orgaos", 'Orgão <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"Vincule pelo menos um orgão a uma Ordem de Serviço.\" class=\"fa fa-exclamation\"></i>\n', 'false');
    ret = false;
  }
  if (this.cronapi.json.getProperty(this.cronapi.screen.getScopeVariable("ordem_servico"), 'equipes_selecionadas').length == 0) {
    this.cronapi.screen.changeContent("tab_equipes", '<i class=\"glyphicon glyphicon-alert\"></i> Equipes.', 'false');
    this.cronapi.screen.changeContent("label_equipes", 'Equipes Escolhidas <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"Vincule pelo menos uma equipe a uma Ordem de Serviço.\" class=\"fa fa-exclamation\"></i>\n', 'false');
    ret = false;
  } else {
    if (this.cronapi.logic.isNullOrEmpty(this.cronapi.json.getProperty(this.cronapi.screen.getScopeVariable("ordem_servico"), 'equipe_responsavel'))) {
      this.cronapi.screen.changeContent("tab_equipes", '<i class=\"glyphicon glyphicon-alert\"></i> Equipes.', 'false');
      this.cronapi.screen.changeContent("label_responsavel", 'Responsável <i data-toggle=\"tooltip\" data-placement=\"right\" title=\"É necessário escolher a equipe responsável pela Ordem de Serviço.\" class=\"fa fa-exclamation\"></i>\n', 'false');
      ret = false;
    }
  }
  return ret;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.iniciarPaginaArgs = [];
window.blockly.js.blockly.LoggedHome.iniciarPagina = async function() {
 var os;
  this.cronapi.screen.createScopeVariable('orgaos_selecionados', '');
  this.cronapi.screen.changeValueOfField('orgaos_selecionados', []);
  this.cronapi.screen.createScopeVariable('ordem_servico', this.cronapi.json.createObjectFromString(['{','\"id\": \"\", ','\"ano\": \"\", ','\"descricao\": \"\", ','\"data_inicio\": \"\", ','\"data_termino\": \"\", ','\"conteudo\": \"\", ','\"orgaos_selecionados\":  [], ','\"equipes_selecionadas\": [], ','\"equipe_responsavel\": \"\", ','\"anexos\": []','}'].join('')));
  this.cronapi.screen.changeValueOfField("vars.rb_tipo_conteudo", '1');
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.OrdemServico:teste', async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.changeAttrValue("editor_api", 'src', this.cronapi.json.getProperty(item, 'document_url'));
    this.cronapi.screen.changeAttrValue("link_editor_api", 'href', this.cronapi.json.getProperty(item, 'document_url'));
    this.cronapi.screen.createScopeVariable('document_url', '');
    this.cronapi.screen.changeValueOfField('document_url', this.cronapi.json.getProperty(item, 'document_url'));
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.cadastrarOrdemServicoArgs = [];
window.blockly.js.blockly.LoggedHome.cadastrarOrdemServico = async function() {
 var os;
  if (await this.blockly.js.blockly.LoggedHome.validar()) {
    resp = await this.cronapi.util.callServerBlockly('blockly.OrdemServico:cadastrarOrdemServico', this.cronapi.screen.getScopeVariable("ordem_servico"));
    if (resp) {
      this.cronapi.screen.notify('success','<i class=\"glyphicon glyphicon-ok-sign\"></i> Ordem de Serviço Cadastrada com sucesso!');
      await this.cronapi.util.sleep(500);
      this.cronapi.screen.changeView("#/home/logged/home",[  ]);
    } else {
      this.cronapi.screen.notify('error','<i class=\"glyphicon glyphicon-alert\"></i> Não foi possível cadastrar a Ordem de Serviço!');
    }
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.alterarValorOSArgs = ['key', 'value'];
window.blockly.js.blockly.LoggedHome.alterarValorOS = async function(key, value) {

  json_os = this.cronapi.screen.getScopeVariable("ordem_servico");
  if (key == 'orgaos_selecionados') {
    lista_orgaos = this.cronapi.json.getProperty(json_os, 'orgaos_selecionados');
    flag = false;
    if (lista_orgaos.length > 0) {
      var equipe_end = lista_orgaos.length;
      var equipe_inc = 1;
      if (1 > equipe_end) {
        equipe_inc = -equipe_inc;
      }
      for (equipe = 1; equipe_inc >= 0 ? equipe <= equipe_end : equipe >= equipe_end; equipe += equipe_inc) {
        console.log(lista_orgaos[(equipe - 1)]);
        if (this.cronapi.json.getProperty(lista_orgaos[(equipe - 1)], 'id') == this.cronapi.json.getProperty(value, 'id')) {
          lista_orgaos.splice((equipe - 1), 1);
          flag = true;
          console.log('Removendo');
          break;
        }
      }
    }
    if (flag == false) {
      lista_orgaos.push(value);
      console.log('Adicionando');
    }
    this.cronapi.json.setProperty(json_os, key, lista_orgaos);
    this.cronapi.screen.createScopeVariable('ordem_servico', json_os);
  } else if (key == 'anexos') {
    anexos = this.cronapi.json.getProperty(json_os, 'anexos');
    flag = false;
    if (anexos.length > 0) {
      var equipe_end = anexos.length;
      var equipe_inc = 1;
      if (1 > equipe_end) {
        equipe_inc = -equipe_inc;
      }
      for (equipe = 1; equipe_inc >= 0 ? equipe <= equipe_end : equipe >= equipe_end; equipe += equipe_inc) {
        console.log(anexos[(equipe - 1)]);
        if (this.cronapi.json.getProperty(anexos[(equipe - 1)], 'name') == this.cronapi.json.getProperty(value, 'name')) {
          anexos.splice((equipe - 1), 1);
          flag = true;
          console.log('Removendo');
          break;
        }
      }
    }
    if (flag == false) {
      anexos.push(this.cronapi.json.createObjectFromString(value));
    }
    this.cronapi.json.setProperty(json_os, key, anexos);
    this.cronapi.screen.createScopeVariable('ordem_servico', json_os);
    this.cronapi.screen.changeValueOfField("vars.anexo", '');
    this.cronapi.screen.hideModal("modalAnexos");
    lista_anexos = this.cronapi.screen.getValueOfField("ANEXOS");
    this.cronapi.json.setProperty(lista_anexos, 'data', anexos);
    this.cronapi.screen.changeValueOfField("ANEXOS", lista_anexos);
  } else if (key == 'equipes_selecionadas') {
    lista_equipes = this.cronapi.json.getProperty(json_os, 'equipes_selecionadas');
    flag = false;
    if (lista_equipes.length > 0) {
      var equipe_end = lista_equipes.length;
      var equipe_inc = 1;
      if (1 > equipe_end) {
        equipe_inc = -equipe_inc;
      }
      for (equipe = 1; equipe_inc >= 0 ? equipe <= equipe_end : equipe >= equipe_end; equipe += equipe_inc) {
        console.log(lista_equipes[(equipe - 1)]);
        if (this.cronapi.json.getProperty(lista_equipes[(equipe - 1)], 'id') == this.cronapi.json.getProperty(value, 'id')) {
          lista_equipes.splice((equipe - 1), 1);
          flag = true;
          console.log('Removendo');
          break;
        }
      }
    }
    if (flag == false) {
      lista_equipes.push(value);
      console.log('Adicionando');
    }
    this.cronapi.json.setProperty(json_os, key, lista_equipes);
    this.cronapi.screen.createScopeVariable('ordem_servico', json_os);
    EQUIPES_SELECIONADAS = this.cronapi.screen.getValueOfField("EQUIPES_SLECIONADAS");
    this.cronapi.json.setProperty(EQUIPES_SELECIONADAS, 'data', lista_equipes);
    this.cronapi.screen.changeValueOfField("EQUIPES_SLECIONADAS", EQUIPES_SELECIONADAS);
  } else {
    console.log('entrei');
    this.cronapi.json.setProperty(json_os, key, value);
    this.cronapi.screen.createScopeVariable('ordem_servico', json_os);
  }
  console.log(this.cronapi.screen.getScopeVariable("ordem_servico"));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.carregarTotalPesquisadasArgs = [];
window.blockly.js.blockly.LoggedHome.carregarTotalPesquisadas = async function() {
 var os;
  console.log(this.cronapi.screen.quantityRecords("GerenciadorDeUsuarios"));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.abrirPainelFiltrosArgs = [];
window.blockly.js.blockly.LoggedHome.abrirPainelFiltros = async function() {
 var os;
  this.cronapi.screen.hideComponent("open-icon");
  this.cronapi.screen.showComponent("dynamic-frame");
  this.cronapi.screen.showComponent("close-icon");
  this.cronapi.screen.showComponent("frame-action");
  this.cronapi.screen.showComponent("frame-info");
  this.cronapi.screen.changeAttrValue("close-icon", 'style', 'display: inline-block !important');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.fecharPainelFiltrosArgs = [];
window.blockly.js.blockly.LoggedHome.fecharPainelFiltros = async function() {
 var os;
  this.cronapi.screen.hideComponent("close-icon");
  this.cronapi.screen.hideComponent("dynamic-frame");
  this.cronapi.screen.hideComponent("frame-action");
  this.cronapi.screen.hideComponent("frame-info");
  this.cronapi.screen.showComponent("open-icon");
  this.cronapi.screen.changeAttrValue("open-icon", 'style', 'display: inline-block !important');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.filtrarOrdemServicosArgs = [];
window.blockly.js.blockly.LoggedHome.filtrarOrdemServicos = async function() {
 var os;
  this.cronapi.screen.changeValueOfField("vars.busca_ano_final", this.cronapi.screen.getValueOfField("vars.busca_ano"));
  this.cronapi.screen.changeValueOfField("vars.busca_equipe_final", this.cronapi.screen.getValueOfField("vars.busca_equipe"));
  this.cronapi.screen.changeValueOfField("vars.busca_numeroOs_final", this.cronapi.screen.getValueOfField("vars.busca_numeroOS"));
  this.cronapi.screen.changeValueOfField("vars.busca_situacao_final", this.cronapi.screen.getValueOfField("vars.busca_situacao"));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.limparFiltrosArgs = [];
window.blockly.js.blockly.LoggedHome.limparFiltros = async function() {
 var os;
  this.cronapi.screen.changeValueOfField("vars.busca_ano", '');
  this.cronapi.screen.changeValueOfField("vars.busca_ano_final", '');
  this.cronapi.screen.changeValueOfField("vars.busca_equipe", '');
  this.cronapi.screen.changeValueOfField("vars.busca_equipe_final", '');
  this.cronapi.screen.changeValueOfField("vars.busca_numeroOS", '');
  this.cronapi.screen.changeValueOfField("vars.busca_numeroOs_final", '');
  this.cronapi.screen.changeValueOfField("vars.busca_situacao", '');
  this.cronapi.screen.changeValueOfField("vars.busca_situacao_final", '');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.abrirModalVisualizarOSArgs = [];
window.blockly.js.blockly.LoggedHome.abrirModalVisualizarOS = async function() {
 var os;
  os = await this.cronapi.util.callServerBlockly('blockly.OrdemServico:recuperarOrdemServicoById', this.cronapi.screen.getValueOfField("GerenciadorDeUsuarios.active.ordemServico_id"));
  this.cronapi.screen.changeContent("info-ano", String('<b>Ano: </b>') + String(this.cronapi.json.getProperty(os, 'ano')), 'false');
  this.cronapi.screen.changeContent("info-idOS", String('<b>Número O.S.: </b>') + String(this.cronapi.json.getProperty(os, 'id')), 'false');
  this.cronapi.screen.changeContent("info-descricao", String('<b>Descrição: </b>') + String(this.cronapi.json.getProperty(os, 'descricao')), 'false');
  this.cronapi.screen.changeContent("info-previsaoInicio", String('<b>Previsão Início: </b>') + String(this.cronapi.dateTime.formatDateTime(this.cronapi.conversion.stringToDate(this.cronapi.json.getProperty(os, 'previsao_inicio')), 'DD/MM/YYYY')), 'false');
  this.cronapi.screen.changeContent("info-previsaoFim", String('<b>Previsão Fim: </b>') + String(this.cronapi.dateTime.formatDateTime(this.cronapi.conversion.stringToDate(this.cronapi.json.getProperty(os, 'previsao_fim')), 'DD/MM/YYYY')), 'false');
  this.cronapi.screen.changeContent("info-situacao", String('<b>Situação: </b>') + String(this.cronapi.json.getProperty(os, 'situacao')), 'false');
  this.cronapi.screen.changeContent("info-solicitante", String('<b>Solicitante: </b>') + String(this.cronapi.json.getProperty(this.cronapi.json.getProperty(os, 'user'), 'name')), 'false');
  this.cronapi.screen.changeContent("info-dataInclusao", String('<b>Data de Inclusão: </b>') + String(this.cronapi.dateTime.formatDateTime(this.cronapi.conversion.stringToDate(this.cronapi.json.getProperty(os, 'data_inclusao')), 'DD/MM/YYYY')), 'false');
  lista_equipes = [];
  var equipe_list = await this.cronapi.util.callServerBlockly('blockly.OrdemServico:recuperarListaEquipes', this.cronapi.screen.getValueOfField("GerenciadorDeUsuarios.active.ordemServico_id"));
  for (var equipe_index in equipe_list) {
    equipe = equipe_list[equipe_index];
    if (this.cronapi.json.getProperty(equipe, 'responsavel')) {
      this.cronapi.screen.changeContent("info-responsavel", String('<b>Equipe Responsável: </b>') + String(this.cronapi.json.getProperty(this.cronapi.json.getProperty(equipe, 'equipe'), 'nome')), 'false');
    }
    lista_equipes.unshift(['<li>',this.cronapi.json.getProperty(this.cronapi.json.getProperty(equipe, 'equipe'), 'nome'),'</li>'].join(''));
  }
  this.cronapi.screen.changeContent("info-listaEquipes", ['<b>Equipes Relacionadas: </b>','<ul>',lista_equipes.join(''),'</ul>'].join(''), 'false');
  this.cronapi.screen.showModal("modalVisualizarOS");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.testeArgs = [];
window.blockly.js.blockly.LoggedHome.teste = async function() {
 var os;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.abrirModalImpressaoArgs = [];
window.blockly.js.blockly.LoggedHome.abrirModalImpressao = async function() {
 var os;
  os = await this.cronapi.util.callServerBlockly('blockly.OrdemServico:recuperarOrdemServicoById', this.cronapi.screen.getValueOfField("GerenciadorDeUsuarios.active.ordemServico_id"));
  if (this.cronapi.json.getProperty(os, 'conteudo').indexOf('<!DOCTYPE html>') + 1 > 0) {
    this.cronapi.screen.changeValueOfField("vars.conteudo_impressao", this.cronapi.json.getProperty(os, 'conteudo'));
    this.cronapi.screen.showModal("modalImpressao");
  } else {
    this.cronapi.screen.openUrl(this.cronapi.json.getProperty(os, 'conteudo'), true, 0, 0);
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.buscaOrgaoArgs = ['value'];
window.blockly.js.blockly.LoggedHome.buscaOrgao = async function(value) {

  json_os = this.cronapi.screen.getValueOfField("orgaos_selecionados");
  flag = false;
  if (json_os.length > 0) {
    var equipe_end = json_os.length;
    var equipe_inc = 1;
    if (1 > equipe_end) {
      equipe_inc = -equipe_inc;
    }
    for (equipe = 1; equipe_inc >= 0 ? equipe <= equipe_end : equipe >= equipe_end; equipe += equipe_inc) {
      console.log(json_os[(equipe - 1)]);
      if (this.cronapi.json.getProperty(json_os[(equipe - 1)], 'id') == this.cronapi.json.getProperty(value, 'id')) {
        json_os.splice((equipe - 1), 1);
        flag = true;
        console.log('Removendo');
        break;
      }
    }
  }
  if (flag == false) {
    json_os.push(value);
    console.log('Adicionando');
  }
  console.log(json_os);
}
