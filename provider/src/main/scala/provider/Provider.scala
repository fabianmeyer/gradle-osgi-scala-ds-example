package provider

import api.Service
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.ComponentContext

import org.eclipse.rdf4j.model.Model
import org.eclipse.rdf4j.model.impl.LinkedHashModel
import org.eclipse.rdf4j.rio.turtle.TurtleParser
import org.eclipse.rdf4j.rio.helpers.StatementCollector

@Component(name="Provider")
class Provider extends Service {

  val model = new LinkedHashModel()

  @Activate
  def activate(ctx : ComponentContext ) {
    	val input = ctx.getBundleContext.getBundle.getEntry("ontologies/owl.ttl").openStream
      val parser = new TurtleParser()
      parser.setRDFHandler(new StatementCollector(model))
      parser.parse(input, "")
      input.close
  }

  override def getModel() : Model = {
    model
  }
}
