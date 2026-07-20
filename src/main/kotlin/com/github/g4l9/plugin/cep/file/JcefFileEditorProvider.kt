package com.github.g4l9.plugin.cep.file

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class JcefFileEditorProvider : FileEditorProvider, DumbAware {

    override fun accept(project: Project, file: VirtualFile): Boolean {
        return file is JcefVirtualFile
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return JcefFileEditor(project, file as JcefVirtualFile)
    }

    override fun getEditorTypeId(): String = EDITOR_TYPE_ID

    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.HIDE_DEFAULT_EDITOR

    companion object {
        const val EDITOR_TYPE_ID = "jcef-browser"
    }
}