package com.kevinlitwack.ssg

import java.io.File
import java.nio.charset.StandardCharsets

import com.typesafe.scalalogging.LazyLogging
import org.apache.commons.io.FileUtils

object MainScript extends App with LazyLogging {

  val markdown =
    """[$PROFILE$]: extended
      |This is some markdown. It contains:
      |
      |* Lists
      |  1. With numbered sub-lists
      |  2. With multiple items
      |* _Italics_
      |* **Bold**
      |* **Bolt with _italics_**
      |* `code snippets`
      |* [hyperlinks](http://www.wikipedia.org/wiki/hyperlink)
      |
      |```scala
      |object Hello {
      |  def apply(name: String, xs: Seq[Int]): String = {
      |    val greeting = s"Hello, $name!"
      |    xs.foreach { x => println(s"$x: $greeting") }
      |  }
      |}
      |```""".stripMargin
  logger.info(s"Markdown:\n$markdown\n\n")

  val generatedHtml = MarkdownRenderer.render(markdown)
  logger.info(s"Generated HTML:\n$generatedHtml\n\n")

  val templateHtml =
    """<html>
      |<head>
      |  <title>${title}</title>
      |  <link rel="stylesheet" href="../highlight/styles/default.css">
      |  <script src="../highlight/highlight.pack.js"></script>
      |  <script>hljs.initHighlightingOnLoad();</script>
      |</head>
      |<body>
      |  <h1>${title}</h1>
      |  ${contents}
      |</body>
      |</html>""".stripMargin
  logger.info(s"Template HTML:\n$templateHtml\n\n")

  val finalHtml = Template(templateHtml, generatedHtml)
  logger.info(s"Final HTML:\n$finalHtml\n\n")
  FileUtils.writeStringToFile(new File("tmp.html"), finalHtml, StandardCharsets.UTF_8)

}
