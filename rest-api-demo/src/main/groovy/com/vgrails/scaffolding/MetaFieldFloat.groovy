package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * float元数据
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 */

@GrailsCompileStatic
class MetaFieldFloat extends MetaField{

    /** 最大值 */
    float max
    /** 最小值 */
    float min
    /** 默认值 */
    float defaults = Float.MIN_VALUE
    /** 保留小数点 */
    int decimals = 4
}
