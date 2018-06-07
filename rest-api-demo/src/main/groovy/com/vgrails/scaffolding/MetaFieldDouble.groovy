package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * double元数据
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 */

@GrailsCompileStatic
class MetaFieldDouble extends MetaField{

    /** 最大值 */
    double max
    /** 最小值 */
    double min
      /** 默认值 */
    double defaults = Double.MIN_VALUE

    /** 保留小数点 */
    int decimals = 4
}
