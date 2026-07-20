package com.github.g4l9.plugin.cep.client

object InMemoryCompilerExplorer : BrowserCompilerExplorer {

    override val languages: List<Language>
        get() = Languages.languages

    override fun languageByExt(ext: String): Language? =
        Languages.ext2language[ext]
}
