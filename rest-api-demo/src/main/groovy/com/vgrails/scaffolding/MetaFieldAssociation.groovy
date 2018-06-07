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

    static String one_to_one="one-to-one"
    static String one_to_many="one-to-many"
    static String many_to_one="many-to-one"
	static String many_to_many="many-to-many"

    /** 是否可空 */
    boolean nullable=false
    /** 关系类型 */
    String associationType
    /** 关联模型 */
    String associationDomain
}
