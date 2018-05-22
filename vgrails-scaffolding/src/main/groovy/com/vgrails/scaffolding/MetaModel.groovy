package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class MetaModel {
    MetaDomain metaDomain
    List<MetaField> fields

    Set<MetaField> transientsFields
    Set<MetaField> oneToManyFields
    Set<MetaField> manyToManyFields
    Set<MetaField> objectsFields
    Set<MetaField> enumsFields
}
