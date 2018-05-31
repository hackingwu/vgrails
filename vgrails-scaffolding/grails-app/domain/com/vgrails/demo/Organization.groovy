package com.vgrails.demo

import com.vgrails.scaffolding.MetaFieldAssociation
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Organization {

    static transients = ['label']
    static m = [
            locale: "组织",
            search: [type: "ajax", fields:['name']],
            layout: [
                    ['parent', 'level'],
                    ['name']
            ]
    ]

    String              label
    String              name
    long                level
    Organization        parent

    static constraints = {
        parent          attributes:[locale: "上级", associationType: MetaFieldAssociation.one_to_many, associationDomain: 'organization'], nullable: true
        label           attributes:[locale: "标签"], nullable: true
        name            attributes:[locale: "名称"], size: 2..32, unique: true
        level           attributes:[locale: "层级"], min:0l, max: 32l
    }

    String getLabel(){
        return "(${level})${name}"
    }

    String toString(){
        return name
    }
}