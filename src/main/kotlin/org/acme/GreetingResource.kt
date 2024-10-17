package org.acme

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @Inject
    lateinit var greetingRepository: GreetingRepository

    @GET // 本来はPOSTなどのHTTPメソッドを指定する
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@QueryParam("name") name:String):String {
        val greeting = Greeting()
        greeting.name = name
        /**
         * persistメソッドは、エンティティ（今回は[Greeting]エンティティ）をデータベース（今回はquarkusフレームワークがPostgreSQLのコンテナの作成、起動、停止を行っている）に保存します。
         * 新しいエンティティの場合は挿入操作を行い、既存のエンティティの場合は更新操作を行います。
         *
         * また、今回のようなDBの使われ方のことをquarkusでは「Dev Services」と言う。
         */
        greeting.persist()
        return "hello $name"
    }

    @GET
    @Path("names")
    @Produces(MediaType.TEXT_PLAIN)
    fun names(): String {
        /**
         * listAllメソッドは、エンティティのリストを返します。
         * このメソッドは、エンティティのクラスに対して呼び出される必要があります。
         * また[listAll]メソッドを使用するには[PanacheRepository]を拡張したリポジトリクラス[GreetingRepository]が必要です。
         */
        val greetings = greetingRepository.listAll()
        val names = greetings.joinToString(",") {it.name}
        return "I've said hello to $names"
    }
}