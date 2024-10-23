plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)

    kotlin("plugin.serialization") version "2.0.20"

    id("com.google.devtools.ksp") version "2.0.20-1.0.25"
}

kotlin {
    androidTarget {
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
            isStatic = true
        }
    }

    js(IR) {
        browser()
        generateTypeScriptDefinitions()
        binaries.library()
    }

    sourceSets {
        all {
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)

            }
        }
    }
}

dependencies {
    add("kspJs", project(":processor"))
}

android {
    namespace = "com.example.kotlinkspversiontest"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
