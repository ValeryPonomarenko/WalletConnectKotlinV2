//apply plugin: signing
plugins {
    `maven-publish`
    signing
}

//afterEvaluate {
//    publishing {
//        publications {
//            register<MavenPublication>("mavenAndroid") {
//                afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
//                artifact(tasks.getByName("javadocJar"))
//                artifact(tasks.getByName("sourcesJar"))
//
//                artifactId = "sign"
//
//                pom {
//                    name.set("WalletConnect Sign")
//                    description.set("Sign SDK for WalletConnect.")
//                    url.set("https://github.com/WalletConnect/WalletConnectKotlinV2")
//
//                    licenses {
//                        license {
//                            name.set("The Apache License, Version 2.0")
//                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                        }
//                        license {
//                            name.set("SQLCipher Community Edition")
//                            url.set("https://www.zetetic.net/sqlcipher/license/")
//                        }
//                    }
//
//                    developers {
//                        developer {
//                            id.set("KotlinSDKTeam")
//                            name.set("WalletConnect Kotlin")
//                            email.set("Kotlin@WalletConnect.com")
//                        }
//                    }
//
//                    scm {
//                        connection.set("scm:git:git://github.com/WalletConnect/WalletConnectKotlinV2.git")
//                        developerConnection.set("scm:git:ssh://github.com/WalletConnect/WalletConnectKotlinV2.git")
//                        url.set("https://github.com/WalletConnect/WalletConnectKotlinV2")
//                    }
//
//                    withXml {
//                        fun groovy.util.Node.addDependency(dependency: Dependency, scope: String) {
//                            appendNode("dependency").apply {
//                                appendNode("groupId", dependency.group)
//                                appendNode("artifactId", dependency.name)
//                                appendNode("version", dependency.version)
//                                appendNode("scope", scope)
//                            }
//                        }
//
//                        asNode().appendNode("dependencies").let { dependencies ->
//                            // List all "api" dependencies as "compile" dependencies
//                            configurations.api.get().allDependencies.forEach {
//                                dependencies.addDependency(it, "compile")
//                            }
//                            // List all "implementation" dependencies as "runtime" dependencies
//                            configurations.implementation.get().allDependencies.forEach {
//                                dependencies.addDependency(it, "runtime")
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

//signing {
//
//}