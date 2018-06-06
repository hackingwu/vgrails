package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * 属性基类
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 *
 *  @note 字段表格宽度占比 = 字段的flex/所有字段的flex值累加*100%，flex值默认为：1
 *
 */

@GrailsCompileStatic
class MetaDomain {

    /** 名称(首字母小写名称) */
    String name
    /** 类型(首字母大写类名) */
    String type
    /** 本地化名称 */
    String locale
    /** 包名 */
    String packageName
    /** 搜索类型，取值：ajax, standard, advanced */
    String searchType
    /** 搜索属性列表 */
    List<String> searchFields

    /** 表单布局 */
    List<List<String>> layout

    /**
     * 不设置本地化，则使用名称
     * @return
     */
    String getLocale(){
        if(locale == null || locale == "" || locale.trim()=="") {
            return name
        }else{
            return locale
        }
    }
}
