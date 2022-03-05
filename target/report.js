$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/MobileValidation.feature");
formatter.feature({
  "name": "Mobile",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user launches flipkart application",
  "keyword": "Given "
});
formatter.match({
  "location": "MobilevalidationSteps.user_launches_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login by entering valid crendentials",
  "keyword": "And "
});
formatter.match({
  "location": "MobilevalidationSteps.user_login_by_entering_valid_crendentials()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mobile Name validation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@smoke3"
    }
  ]
});
formatter.step({
  "name": "user search mobile",
  "keyword": "When "
});
formatter.match({
  "location": "MobilevalidationSteps.user_search_mobile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on the mobile name",
  "keyword": "And "
});
formatter.match({
  "location": "MobilevalidationSteps.user_click_on_the_mobile_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validate the mobile names",
  "keyword": "Then "
});
formatter.match({
  "location": "MobilevalidationSteps.user_validate_the_mobile_names()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});