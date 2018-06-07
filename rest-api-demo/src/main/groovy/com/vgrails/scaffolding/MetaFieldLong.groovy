package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * long元数据
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 */

@GrailsCompileStatic
class MetaFieldLong extends MetaField{

    /** 最大值 */
    long max
    /** 最小值 */
    long min
      /** 默认值 */
    long defaults = Long.MIN_VALUE
}
