package vgrails.demo.app

import com.vgrails.scaffolding.MetaModelService


class BootStrap {

    def init = { servletContext ->

        println MetaModelService.GetModel("organization")
        println MetaModelService.GetModel("shop")
    }
    def destroy = {
    }
}
