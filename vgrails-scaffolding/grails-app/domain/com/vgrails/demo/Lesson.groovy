package com.vgrails.demo

import com.vgrails.scaffolding.MetaFieldAssociation
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Lesson {

    static transients = ['selfSelected', 'suggestSelected']

    List<Student> selfSelected
    List<Student> suggestSelected

    static constraints = {
        selfSelected        attributes:[associationType: MetaFieldAssociation.many_to_many, associationDomain: 'student']
        suggestSelected     attributes:[associationType: MetaFieldAssociation.many_to_many, associationDomain: 'student']
    }
}
