package rest.api.demo

import com.vgrails.scaffolding.MetaModelService
import grails.rest.*
import grails.converters.*

class VRestfulController extends RestfulController{

    Class resource

    VRestfulController(Class resource) {
        super(resource)
        this.resource = resource
    }

    VRestfulController(Class resource, boolean readOnly) {
        super(resource, readOnly)
        this.resource = resource
    }

    def meta() {
        respond MetaModelService.GetModel(resource.getSimpleName())

        return
    }
}
