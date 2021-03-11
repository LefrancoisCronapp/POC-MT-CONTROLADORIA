window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.LoggedHome = window.blockly.js.blockly.LoggedHome || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.LoggedHome.abrirPainelFiltros = async function() {

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
window.blockly.js.blockly.LoggedHome.fecharPainelFiltros = async function() {

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
window.blockly.js.blockly.LoggedHome.carregarTotalPesquisadas = async function() {

  console.log(this.cronapi.screen.quantityRecords("GerenciadorDeUsuarios"));
}
