package com.kevinlitwack.ssg

import com.github.rjeschke.txtmark.Processor

object MainScript extends App {

  val markdown =
    """
      |This is some *markdown*. It contains:
      |
      |* Lists
      |* _Italics_
      |* `code snippets`
      |* [hyperlinks](http://www.wikipedia.org/wiki/hyperlink)
    """.stripMargin
  val generatedHtml = Processor.process(markdown)

  val templateHtml =
    """
      |<html>
      |<head>
      |  <title>${title}</title>
      |</head>
      |<body>
      |  <h1>${title}</h1>
      |  ${contents}
      |</body>
      |</html>
    """.stripMargin

  val finalHtml = Template(templateHtml, generatedHtml)
  println(finalHtml)

}
