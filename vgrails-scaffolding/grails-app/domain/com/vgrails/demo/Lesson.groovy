package com.vgrails.demo

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Lesson {

    static m = [
            locale: "课程",
            search: [type: "ajax", fields:['name']],
            layout: [
                    ['name'],
                    ['remark']
            ]
    ]

    static hasMany = [students: Student]

    String              name
    String              remark
    static constraints = {
        name            attributes:[locale: "名称"], size: 2..32, unique: true
        remark          attributes:[locale: "简介"], size: 2..255
    }

    String toString(){
        return name
    }
}
