package com.vgrails.demo

import grails.rest.Resource

@Resource(uri = '/org')
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