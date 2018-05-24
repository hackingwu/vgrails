package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * 关系属性(Association)元数据
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 */

@GrailsCompileStatic
class MetaFieldAssociation extends MetaField{

    static int ONE_TO_ONE=1
    static int MANY_TO_ONE=2
    static int MANY_TO_MANY=4

    /** 是否可空 */
    boolean nullable=false
    /** 关系类型 */
    int associationType=MANY_TO_ONE
    /** 关联模型 */
    String associationDomain
}
