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
class MetaField {

    /** 排序从小到大 */
    static int VG_SORT_ASC = 2
    /** 排序从大到小 */
    static int VG_SORT_DESC = 1
    /** 排序关闭 */
    static int VG_SORT_OFF = 0

    /** 名称 */
    String name
    /** 类型 */
    String type
    /** 控件类型 */
    String widget
    /** 本地化，如：name='name' locale='姓名' */
    String locale
    /** 表格列宽占比 */
    int flex=1
    /** 是否支持排序 */
    int sort=0
    /** grid列显示自定义回调接口，场景：性别男女，用男女小图标表示 */
    String renderer
    /** 是否唯一 */
    boolean unique

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
