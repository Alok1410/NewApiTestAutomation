Feature: User API Testing

  Scenario: Get all users
    Given the API base URI is set
    When I send a GET request to "/users"
    Then the response status code should be 200

  Scenario: Create a new user
    Given the API base URI is set
    When I send a POST request to "/users" with the payload:
      """
      {
        "name": "John",
        "job": "developer"
      }
      """
    Then the response status code should be 201
    And the response should contain "id"

  Scenario Outline: Create a new user with dynamic data
    Given the API base URI is set
    When I send a POST request to "/users" with the payload:
      """
      {
        "name": "<name>",
        "job": "<job>"
      }
      """
    Then the response status code should be 201
    And the response should contain "id"

    Examples:
      | name   | job          |
      | Alice  | QA Engineer  |
      | Bob    | Developer    |
      | Carol  | Manager      |
