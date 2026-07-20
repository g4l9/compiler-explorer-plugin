package com.github.g4l9.plugin.cep.action

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnActionEvent

class OpenCompilerExplorerInBrowserAction : AbstractCompilerExplorer("Compiler Explorer") {

    override fun handleSrc(e: AnActionEvent, url: String) {
        BrowserUtil.browse(url)
    }
}
