#language: en
#/**
# * Autor: Fernando Lisboa
# * Empresa: Taking
# * Data: 25/06/2019
# * Caminho: Portal Sales Force
# */
@loginInicial  @Regressao
Feature: Efetuar login no Sales Force
  
    I as a user
    I want to log into the system
    To access your account information

  Background: 
    Given I'm in login screen

  Scenario Template: [LOGIN - SALESFORCE] "<Scenario>"-"<DescricaoDoCenario>"
    
    And I fill out the login form
    When I activate the button Login
    Then the user is redirected to the home page

    Examples: 
      | Scenario | DescricaoDoCenario | url                         | user                        | password | profile |
      | CT01.1   | Sales Force Login  | https://test.salesforce.com | bdrqauser@everis.com.afrdev | password | TZ BDR  |
