package com.vgrails.demo

import com.vgrails.scaffolding.MetaFieldAssociation
import grails.rest.Resource

@Resource(uri = '/employee')
class Employee {

    static m = [
            locale: "员工"
    ]

    Org owner
    String name

    static constraints = {
        owner           nullable: true, attributes:[locale: "班级", associationType: MetaFieldAssociation.many_to_one, associationDomain: "org"]
        name            unique: true, attributes:[locale: "姓名"]
    }

    String toString(){
        return name
    }
}