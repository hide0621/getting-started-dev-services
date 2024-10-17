package org.acme

import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestQuery

@Path("/hello")
class GreetingResource {

    @GET // 本来はPOSTなどのHTTPメソッドを指定する
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@QueryParam("name") name:String):String {
        val greeting = Greeting()
        greeting.name = name
        /**
         * persistメソッドは、エンティティ（今回は[Greeting]エンティティ）をデータベースに保存します。
         * 新しいエンティティの場合は挿入操作を行い、既存のエンティティの場合は更新操作を行います。
         */
        greeting.persist()
        return "hello $name"
    }
}