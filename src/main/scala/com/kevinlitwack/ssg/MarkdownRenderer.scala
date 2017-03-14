package com.kevinlitwack.ssg

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser

object MarkdownRenderer {

  def render(input: String): String = {
    val parser = Parser.builder().build()
    val renderer = HtmlRenderer.builder().build()
    val document = parser.parse(input)
    renderer.render(document)
  }

}
