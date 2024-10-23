package com.example.processorplugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class ProcessorPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyPlugins()
        target.doAfterEvaluate()
    }

    private fun Project.applyPlugins() {
        plugins.apply("idea")
    }

    private fun Project.doAfterEvaluate() {
        afterEvaluate {
            applyDependencies()
        }
    }

    private fun Project.applyDependencies() {
        this.dependencies {
            add("kspJs", project(":processor"))
        }
    }
}