package consumer

import api.Service
import org.osgi.service.component.annotations.{Activate, Component, Reference}

import scala.collection.JavaConverters._

@Component(name = "Consumer", immediate = true)
class Consumer {

  var service: Service = null

  @Reference
  def setService(service: Service): Unit = {
    this.service = service
  }

  def unsetService(service: Service): Unit = {}

  @Activate
  def activate(): Unit = {
    val model = service.getModel
    model.asScala.foreach(println)
  }
}
