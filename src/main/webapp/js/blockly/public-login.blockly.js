window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PublicLogin = window.blockly.js.blockly.PublicLogin || {};

/**
 * public-login
 */
window.blockly.js.blockly.PublicLogin.ExecutarArgs = [];
window.blockly.js.blockly.PublicLogin.Executar = async function() {
 var username, password, manterLogado, item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PublicLogin.loginArgs = ['username', 'password', 'manterLogado'];
window.blockly.js.blockly.PublicLogin.login = async function(username, password, manterLogado) {
 var item;
  this.cronapi.util.getURLFromOthers('POST', 'application/x-www-form-urlencoded', String(this.cronapi.util.getBaseUrl()) + String('/auth'), this.cronapi.json.createObjectFromString(['{','\"username\": \"',username,'\", \"password\": \"',password,'\"}'].join('')), null, async function(sender_item) {
      item = sender_item;
    if (this.cronapi.conversion.toBoolean(manterLogado)) {
      this.cronapi.util.setLocalStorage('_u', this.cronapi.object.serializeObject(item));
    } else {
      this.cronapi.util.setSessionStorage('_u', this.cronapi.object.serializeObject(item));
    }
    this.cronapi.screen.changeView("#/home/logged/home",[  ]);
  }.bind(this), async function(sender_item) {
      item = sender_item;
    if (this.cronapi.object.getProperty(item, 'status') == '403' || this.cronapi.object.getProperty(item, 'status') == '401') {
      this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.invalidPassword",[  ]));
    } else if (this.cronapi.object.getProperty(item, 'status') == '502') {
      this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.ServerOff",[  ]));
    } else if (this.cronapi.object.getProperty(item, 'status') == '404') {
      this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.HostAppOff",[  ]));
    } else {
      this.cronapi.screen.notify('error',this.cronapi.object.getProperty(item, 'responseJSON.message'));
    }
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PublicLogin.iniciarPaginaArgs = [];
window.blockly.js.blockly.PublicLogin.iniciarPagina = async function() {
 var username, password, manterLogado, item;
}
