plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.21"
    id("com.squareup.sqldelight")
    id("com.apollographql.apollo3") version "3.8.2"
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    jvm()

    val coroutinesVersion = "1.7.1"
    val ktorVersion = "2.3.2"
    val koinVersion = "3.3.2"
    val sqlDelightVersion = "1.5.5"

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                // Kotlin serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                // Ktor http client
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                // Use api so that android app can use it as well
                api("io.insert-koin:koin-core:$koinVersion")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")

                //Graph QL
                implementation("com.apollographql.apollo3:apollo-runtime:3.8.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")

                api("io.insert-koin:koin-android:$koinVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
    }
}

android {
    namespace = "dev.vengateshm.samplekmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "dev.vengateshm.samplekmm.shared.cache"
    }
}

apollo {
    service("service"){
        packageName.set("dev.vengateshm.samplekmm")
    }
}