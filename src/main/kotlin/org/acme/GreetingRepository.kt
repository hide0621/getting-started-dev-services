package org.acme

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

/**
 * [Greeting]エンティティのリポジトリクラスです。
 * このクラスは、[PanacheRepository]を拡張しています。
 * このクラスを使用することで、エンティティのCRUD操作を行うことができます。
 *
 * [listAll]メソッドを使用するには[PanacheRepository]を拡張したリポジトリクラス[GreetingRepository]が必要です。
 *
 * また、このクラスは、[ApplicationScoped]アノテーションが付与されているため、
 * アプリケーション全体でシングルトンとして利用されます。
 */

@ApplicationScoped
class GreetingRepository: PanacheRepository<Greeting> {
    fun findByName(name: String): Greeting? {
        return find("name", name).firstResult()
    }
}