package com.vgrails.demo

import com.vgrails.scaffolding.MetaFieldAssociation

class Student {

    static transients = ['selfSelected', 'suggestSelected']

    List<Lesson> selfSelected
    List<Lesson> suggestSelected

    Organization owner
    StudentCard         studentCard


    static constraints = {
        studentCard         attributes:[associationType: MetaFieldAssociation.one_to_one, associationDomain: 'studentCard'], nullable:true
        selfSelected        attributes:[associationType: MetaFieldAssociation.many_to_many, associationDomain: 'lesson'], nullable:true
        suggestSelected     attributes:[associationType: MetaFieldAssociation.many_to_many, associationDomain: 'lesson'], nullable:true
        owner               attributes:[associationType: MetaFieldAssociation.one_to_many, associationDomain: 'organization'], nullable:true
    }
}
