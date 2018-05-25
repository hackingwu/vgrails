package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class MetaModel {
    /** 领域模型元数据 */
    MetaDomain metaDomain
    /** 属性清单 */
    List<MetaField> fields=[]
    /** 非持久化的属性 */
    List<String> transients=[]
}
