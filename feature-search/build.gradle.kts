@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
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
            baseName = "feature-search"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.mvvm)
            api(projects.components)
            implementation(libs.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "polkovnik.max.feature_search"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
