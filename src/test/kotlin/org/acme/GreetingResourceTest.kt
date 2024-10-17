package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            // クエリパラメーターを用いるテストの場合は以下の記述が必須みたい
            .queryParam("name", "world")
          .`when`().get("/hello")
          .then()
             .statusCode(200)
            .body(containsString("hello"))
    }

}