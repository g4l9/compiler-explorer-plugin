package com.github.g4l9.plugin.cep.file

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorLocation
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.jcef.JBCefBrowser
import java.beans.PropertyChangeListener
import javax.swing.JComponent

data class JcefFileEditor(
    val project: Project,
    val file: JcefVirtualFile
) : UserDataHolderBase(), FileEditor {

    val browser: JBCefBrowser = JBCefBrowser()

    init {
        browser.loadURL(file.jcefUrl)
    }

    override fun getComponent(): JComponent = browser.component

    override fun getPreferredFocusedComponent(): JComponent = browser.component

    override fun getName(): String = "JCEF Browser"

    override fun setState(state: FileEditorState) {}

    override fun isModified(): Boolean = false

    override fun isValid(): Boolean = true

    override fun addPropertyChangeListener(listener: PropertyChangeListener) {}

    override fun removePropertyChangeListener(listener: PropertyChangeListener) {}

    override fun dispose() {
        browser.dispose()
    }

    override fun getCurrentLocation(): FileEditorLocation? = null

    override fun getFile(): VirtualFile {
        return file
    }

}