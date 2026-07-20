package com.github.g4l9.plugin.cep.file

import com.intellij.testFramework.LightVirtualFile

class JcefVirtualFile(name: String, val jcefUrl: String) : LightVirtualFile(name, "text/html") {
    override fun isWritable(): Boolean = false
}