package api

import org.eclipse.rdf4j.model.Model

trait Service {
  def getModel : Model
}
