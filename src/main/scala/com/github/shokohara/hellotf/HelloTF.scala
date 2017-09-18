package com.github.shokohara.hellotf

import org.tensorflow.Graph
import org.tensorflow.Session
import org.tensorflow.Tensor
import org.tensorflow.TensorFlow

object HelloTF {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    println(hello)
  }

  def hello = {
    val g: Graph = new Graph()
    val value = "Hello from " + TensorFlow.version()

    // Construct the computation graph with a single operation, a constant
    // named "MyConst" with a value "value".
    val t: Tensor = Tensor.create(value.getBytes("UTF-8"))
    // The Java API doesn't yet include convenience functions for adding operations.
    g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build()

    // Execute the "MyConst" operation in a Session.
    val s: Session = new Session(g)
    val output: Tensor = s.runner().fetch("MyConst").run().get(0)
    new String(output.bytesValue(), "UTF-8")
  }
}
