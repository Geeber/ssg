package com.kevinlitwack.ssg

import com.github.rjeschke.txtmark.Processor

object MainScript extends App {

  val input =
    """
      |This is some *markdown*. It contains:
      |* Lists
      |* _Italics_
      |* `code snippets`
      |* [hyperlinks](http://www.wikipedia.org/wiki/hyperlink)
    """.stripMargin

  val html = Processor.process(input)

  println(html)

}
