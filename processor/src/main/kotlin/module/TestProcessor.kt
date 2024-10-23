package module

import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import java.io.OutputStreamWriter

class TestProcessor(private val environment: SymbolProcessorEnvironment) : SymbolProcessor {
    private var invoked = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (invoked) {
            return emptyList()
        }

        invoked = true

        val symbols = resolver.getSymbolsWithAnnotation("com.example.kotlinkspversiontest.ToGenerate")

        environment.codeGenerator.createNewFileByPath(Dependencies(true), "generated/TestOutputFile")
            .use { output ->
                OutputStreamWriter(output).use { writer ->
                    writer.write("val a = 0")
                }
            }

        return emptyList()
    }
}