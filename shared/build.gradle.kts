@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
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
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosapp/Podfile")
        framework {
            baseName = "shared"
            isStatic = false
            export(projects.mvvm)
            export(projects.components)
            transitiveExport = true
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
    namespace = "polkovnik.max.kmp_thermometer"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}