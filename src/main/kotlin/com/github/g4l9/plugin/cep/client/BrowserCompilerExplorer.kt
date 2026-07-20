package com.github.g4l9.plugin.cep.client

import net.minidev.json.JSONValue
import java.util.*

interface BrowserCompilerExplorer : CompilerExplorer {

    override fun url(source: String, lang: Language): String {
        val json = """
            {
              "sessions": [
                {
                  "id": 1,
                  "language": "${lang.id}",
                  "source": "${JSONValue.escape(source)}",
                  "compilers": [
                    {
                      "id": "${lang.defaultCompiler}",
                      "options": ""
                    }
                  ]
                }
              ]
            }
        """.trimIndent()

        val base64 = Base64.getEncoder().encodeToString(json.toByteArray())

        return "https://godbolt.org/clientstate/$base64?hideEditorPanel=true&&readOnly=true"
    }

}
