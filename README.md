# getting-started-dev-services

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

以下のサイトの内容に基づくものです

[2つ目のQuarkusアプリケーション](https://ja.quarkus.io/guides/getting-started-dev-services)

## このプロジェクトの作成方法

以下のコマンドを用いて作成しています

`quarkus create app org.acme:getting-started-dev-services \
    --extension='rest' --kotlin --gradle`

## PanacheEntityの導入方法

以下のコマンドを使って依存先を注入（ただしquarkusのバージョンは**3.15.1**にあげておくこと）

`quarkus extension add hibernate-orm-panache-kotlin jdbc-postgresql`

その後、Android Studioの画面右上に表示されている**Gradleアイコン**（**左斜め下向きの矢印付きのもの**）をタップして、同期させる

Kotlin + quarkusでPanacheEntityを用いたコードの書き方は以下を参照

[シンプルになったHibernate ORM with PanacheとKotlin](https://ja.quarkus.io/guides/hibernate-orm-panache-kotlin)

## listAllメソッドを使うには

メソッドの中には`PanacheEntity`クラスではなく`PanacheRepository`クラスを拡張している必要がある場合もある（その一つが`listAll`メソッド）

上記のようなメソッドを使うには[このコミットの書き方を参考にする](https://github.com/hide0621/getting-started-dev-services/commit/11d4419780d024dfac4a7badb672fc7251c6d951)

## application.propertiesについて

Dev services([このコミットを参照](https://github.com/hide0621/getting-started-dev-services/commit/fc6cae34c450b68a8753fb77cf03e2e38d81e5d1))を使わない場合はこのファイルに指定されたDBを使用することになる

使い方については[このコミットを参照](https://github.com/hide0621/getting-started-dev-services/commit/fc6cae34c450b68a8753fb77cf03e2e38d81e5d1)

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/getting-started-dev-services-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
