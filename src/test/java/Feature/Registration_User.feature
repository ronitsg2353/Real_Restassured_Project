Feature: verify mutliple post request

  @test1
  Scenario Outline: create post request and validate the success response
   Given open the pet store url <url>
    And Enter the request body of user
      | id         | 1                     |
      | UserName   | Ronitg2353            |
      | FirstName  | Ronit                 |
      | LastName   | Gaikwad               |
      | Email      | ronitsg2353@gmail.com |
      | Password   | Ronit@2353            |
      | Phone      | 9922922308            |
      | UserStatus | 0                     |

    When hit the post request
    Then validate the <status_code> of post request
    Examples:
      | url      | status_code |
      | post_URL | 200         |


@test2
Scenario Outline: create post request by POJO getter n setter
  Given open the pet store url <url>
  And Enter the POJO request body of user
  And Enter POJO request body to the requestSpecc
  When hit the post request for POJO
  Then validate the <status_code> of post POJO request
  Examples:
    | url      | status_code |
    | post_URL | 200         |


  @test3
  Scenario Outline: create post request by JSONobject
    Given open the pet store url <url>
    And Enter the request body of user
      | id         | 1                     |
      | UserName   | Ronitg2353            |
      | FirstName  | Ronit                 |
      | LastName   | Gaikwad               |
      | Email      | ronitsg2353@gmail.com |
      | Password   | Ronit@2353            |
      | Phone      | 9922922308            |
      | UserStatus | 0                     |
    When hit the post request for JSONBject
    Then validate the <status_code> of JSONobject
    Examples:
      | url      | status_code |
      | post_URL |200          |



    @test4
    Scenario Outline: create post request by map
      Given open the pet store url <url>
      And Enter the request body of user
        | id         | 1                     |
        | UserName   | Ronitg2353            |
        | FirstName  | Ronit                 |
        | LastName   | Gaikwad               |
        | Email      | ronitsg2353@gmail.com |
        | Password   | Ronit@2353            |
        | Phone      | 9922922308            |
        | UserStatus | 0                     |
      When hit the post request for map body
      Then validate the <status_code> for map request
      Examples:
        | url      | status_code |
        | post_URL | 200         |

      @test5
      Scenario Outline: create post request by external json file
        Given open the pet store url <url>
        And Enter the request body by external json file
        When hit the post request for external json body
        Then validate the <status_code> for map json_file
        Examples:
          | url      | status_code |
          | post_URL | 200         |


