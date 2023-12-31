plugins {
    application
    alias(libs.plugins.ktor)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.graphql.server)
    implementation(libs.ktor.server.netty)
    implementation(libs.kubernetes.client)
}

application {
    mainClass.set("org.sourcegrade.yougrade.operator.MainKt")
}
