package com.github.g4l9.plugin.cep.action

import com.github.g4l9.plugin.cep.client.CompilerExplorer
import com.github.g4l9.plugin.cep.client.Language
import com.github.g4l9.plugin.cep.icons.ExplorerIcons
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.DumbAwareAction

abstract class AbstractCompilerExplorer(text: String) : DumbAwareAction(
    text,
    "",
    ExplorerIcons.Explorer,
) {

    protected val explorer = CompilerExplorer()

    abstract fun handleSrc(e: AnActionEvent, url: String)

    private fun languageId(e: AnActionEvent): Language? {
        val file = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return null
        val ext = file.extension ?: return null
        return explorer.languageByExt(ext)
    }

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val source = editor.document.text
        val lang = languageId(e) ?: return
        val url = explorer.url(source, lang)
        handleSrc(e, url)
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabled = languageId(e) != null
    }
}