package com.github.g4l9.plugin.cep.action

import com.github.g4l9.plugin.cep.file.JcefVirtualFile
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx

class OpenCompilerExplorerInEmbeddedBrowserAction : AbstractCompilerExplorer("Compiler Explorer Embedded") {

    override fun handleSrc(
        e: AnActionEvent,
        url: String
    ) {
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val virtualFileLhs = editor.virtualFile ?: return
        val project = e.project ?: return
        val manager = FileEditorManager.getInstance(project) as FileEditorManagerEx
        val virtualFileRhs = JcefVirtualFile("${virtualFileLhs.name}.jcef", url)
        manager.openFile(virtualFileRhs)
    }
}
