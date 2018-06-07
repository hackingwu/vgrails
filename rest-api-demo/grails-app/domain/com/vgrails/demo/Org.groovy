package com.vgrails.demo

import com.vgrails.scaffolding.MetaFieldAssociation
import grails.rest.Resource
import rest.api.demo.VRestfulController

@Resource(uri = '/org', superClass = VRestfulController)
class Org {

    static m = [
            locale: "班级"
    ]

    Org parent
    String name

    static constraints = {
        parent          nullable: true, attributes:[locale: "上级", associationType: MetaFieldAssociation.many_to_one, associationDomain: "org"]
        name            unique: true, attributes:[locale: "名称"]
    }

    String toString(){
        return name
    }
}