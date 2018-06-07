package com.vgrails.demo

import grails.rest.Resource
import rest.api.demo.VRestfulController

@Resource(uri = '/org', superClass = VRestfulController)
class Org {

    Org parent
    String name

    static constraints = {
        parent          nullable: true
        name            unique: true
    }

    String toString(){
        return name
    }
}