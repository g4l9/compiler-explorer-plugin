package com.github.g4l9.plugin.cep.client

interface CompilerExplorer {
    val languages: List<Language>
    fun languageByExt(ext: String): Language?
    fun url(source: String, lang: Language): String

    companion object {
        operator fun invoke(): CompilerExplorer = InMemoryCompilerExplorer
    }
}
