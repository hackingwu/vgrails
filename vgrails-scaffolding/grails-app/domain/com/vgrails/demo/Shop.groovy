package com.vgrails.demo

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Shop {

    static transients = ['address']
    static m = [
            locale: "门店",
            search: [type: "ajax", fields:['name']],
            layout: [
                    ['parent', 'level'],
                    ['name']
            ]
    ]

    String              address
    String              name
    Organization        owner

    static constraints = {
        owner          attributes:[locale: "上级"], nullable: true
        address        attributes:[locale: "标签"], nullable: true
        name           attributes:[locale: "名称"], size: 2..32, unique: true
    }

    String toString(){
        return name
    }
}