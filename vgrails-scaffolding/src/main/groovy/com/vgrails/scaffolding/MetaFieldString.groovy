package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * String元数据
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 */

@GrailsCompileStatic
class MetaFieldString extends MetaField{
    /** 是否可空 */
    boolean nullable=false
    /** 是否允许仅用空格 */
    boolean blank=false
    /** 允许列表值 */
    List<String> inList
    /** 长度范围 */
    Range<Integer> size
    /** 匹配正则 */
    String matches
    /** 手机 */
    boolean mobile
    /** 密码 */
    boolean password
    /** URL */
    boolean url
    /** 不等于 */
    String notEqual
}
