plugins {
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

buildscript {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.dokka:dokka-core:$dokkaVersion")      // TODO: Leave version until AGP 7.3 https://github.com/Kotlin/dokka/issues/2472#issuecomment-1143604232
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:$dokkaVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$dokkaVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}

allprojects {
    repositories {
        google()
        maven(url = "https://jitpack.io")
        maven(url = "https://plugins.gradle.org/m2/")
        mavenLocal()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

subprojects {
    afterEvaluate {
        if (plugins.hasPlugin("maven-publish") && plugins.hasPlugin("signing")) {
            group = "com.walletconnect"
        }
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

nexusPublishing {
    repositories {
        sonatype {
            stagingProfileId.set(System.getenv("SONATYPE_STAGING_PROFILE_ID"))
            username.set(System.getenv("OSSRH_USERNAME"))
            password.set(System.getenv("OSSRH_PASSWORD"))
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}