package com.vgrails.demo

import grails.rest.Resource

@Resource(uri = '/employee')
class Employee {

    Org owner
    String name

    static constraints = {
        owner           nullable: true
        name            unique: true
    }
}
