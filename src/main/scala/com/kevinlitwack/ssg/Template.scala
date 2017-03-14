package com.kevinlitwack.ssg

import java.io.{StringReader, StringWriter}
import java.util.Locale

import freemarker.template.{Configuration, Template => FreeMarkerTemplate, TemplateExceptionHandler}

import scala.collection.JavaConversions.mapAsJavaMap

object Template {

  def apply(templateStr: String, contents: String): String = {
    // Create the configuration.
    val config = new Configuration(Configuration.VERSION_2_3_25)
    config.setDefaultEncoding("UTF-8")
    config.setLocale(Locale.US)
    config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)

    // Create the template.
    val template = new FreeMarkerTemplate("the_template", new StringReader(templateStr), config)

    // Create the input map.
    val input = mapAsJavaMap(Map(
      "title" -> "The Title",
      "contents" -> contents
    ))

    // Process the template and return the resulting string.
    val stringWriter = new StringWriter()
    template.process(input, stringWriter)
    stringWriter.close()
    stringWriter.toString
  }

}
