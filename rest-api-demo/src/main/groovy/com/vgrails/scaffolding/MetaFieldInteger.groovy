package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * int元数据
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 */

@GrailsCompileStatic
class MetaFieldInteger extends MetaField{

    /** 最大值 */
    int max
    /** 最小值 */
    int min
      /** 默认值 */
    int defaults = Integer.MIN_VALUE
}
