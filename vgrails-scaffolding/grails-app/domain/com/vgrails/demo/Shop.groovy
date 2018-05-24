package com.vgrails.demo

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Shop {

    static m = [
            locale: "门店",
            search: [type: "standard", fields:['name']],
            layout: [
                    ['parent', 'level'],
                    ['name']
            ]
    ]

    String              name
    String              address
    Organization        owner
    static constraints = {
        owner           attributes:[locale: "归属"], min:0, max: 32
        name            attributes:[locale: "名称"], size: 2..32, unique: true
        address         attributes:[locale: "地址"], nullable: true
    }

    String toString(){
        return name
    }
}
