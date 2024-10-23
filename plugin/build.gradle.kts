plugins {
    `kotlin-dsl`
    `maven-publish`
}

version = "0.0.1"
group = "test.processorplugin.RNPlugin"

gradlePlugin {
    plugins {
        create("ProcessorPlugin") {
            id = "com.example.processorplugin.ProcPlugin"
            implementationClass = "com.example.processorplugin.ProcessorPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}
