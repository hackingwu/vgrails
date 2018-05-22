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
    boolean nullable
    /** 是否允许仅用空格 */
    boolean blank
    /** 只允许列表值 */
    List<String> inList
    /** 最大长度 */
    int maxSize
    /** 最小长度 */
    int minSize
    /** 匹配正则 */
    String matches
    /** 手机 */
    boolean mobile
    /** 密码 */
    boolean password
    /** 默认值 */
    String defaults
}
