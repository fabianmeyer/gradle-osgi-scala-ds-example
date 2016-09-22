package consumer

import api.Service
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Reference
import org.osgi.service.component.annotations.Activate
import org.eclipse.rdf4j.model.Model

@Component(name="Consumer", immediate=true)
class Consumer {

  var service : Service = null

  @Reference
  def setService(service : Service) : Unit = {
    this.service = service
  }

  def unsetService(service : Service) : Unit = {
    this.service = service
  }

  @Activate
  def activate() : Unit = {
    println(service.getModel)
  }
}
