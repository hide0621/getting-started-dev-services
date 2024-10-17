package org.acme

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

/**
 * [Greeting]エンティティクラスです。
 * このクラスは、[PanacheEntity]を継承しています。
 * このクラスを使用することで、エンティティのCRUD操作を行うことができます。
 */

@Entity
class Greeting: PanacheEntity() {
    lateinit var name:String
}