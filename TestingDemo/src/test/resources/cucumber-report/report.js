$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/com/abi/ontap/automation/integration/is_loginInicial.feature");
formatter.feature({
  "name": "Efetuar login no Sales Force",
  "description": "    I as a user\n    I want to log into the system\n    To access your account information",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@loginInicial"
    },
    {
      "name": "@Regressao"
    }
  ]
});
formatter.scenarioOutline({
  "name": "[LOGIN - SALESFORCE] \"\u003cScenario\u003e\"-\"\u003cDescricaoDoCenario\u003e\"",
  "description": "",
  "keyword": "Scenario Template"
});
formatter.step({
  "name": "I fill out the login form",
  "keyword": "And "
});
formatter.step({
  "name": "I activate the button Login",
  "keyword": "When "
});
formatter.step({
  "name": "the user is redirected to the home page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Scenario",
        "DescricaoDoCenario",
        "url",
        "user",
        "password",
        "profile"
      ]
    },
    {
      "cells": [
        "CT01.1",
        "Sales Force Login",
        "https://test.salesforce.com",
        "bdrqauser@everis.com.afrdev",
        "password",
        "TZ BDR"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I\u0027m in login screen",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_m_in_login_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "[LOGIN - SALESFORCE] \"CT01.1\"-\"Sales Force Login\"",
  "description": "",
  "keyword": "Scenario Template",
  "tags": [
    {
      "name": "@loginInicial"
    },
    {
      "name": "@Regressao"
    }
  ]
});
formatter.step({
  "name": "I fill out the login form",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_fill_out_the_login_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I activate the button Login",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_activate_the_button_Login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is redirected to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.the_user_is_redirected_to_the_home_page()"
});
