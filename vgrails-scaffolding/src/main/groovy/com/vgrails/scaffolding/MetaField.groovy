package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic
import grails.gorm.validation.DefaultConstrainedProperty

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
    String propertyName
    /** 类型 */
    String type
    /** 本地化，如：propertyName='propertyName' locale='姓名' */
    String locale
    /** 表格列宽占比 */
    int flex=1
    /** 是否支持排序 */
    int sort=0
    /** 是否唯一 */
    boolean unique
    /** 是否可编辑 */
    boolean editable

    /**
     * 不设置本地化，则使用名称
     * @return
     */
    String getLocale(){
        if(locale == null || locale == "" || locale.trim()=="") {
            return propertyName
        }else{
            return locale
        }
    }

    /**
     * 从Constraint拷贝约束条件到自身
     * @param cp
     *
     * @note 通过命名一致约定，只要COPY属性的交集
     */
    void CopyFromConstraint(DefaultConstrainedProperty cp){

        //生成待拷贝键值列表needToCopyKeySet
        Set<String> fieldKeySet=properties.keySet()
        Set<String> constraintKeySet=cp.properties.keySet() + cp.attributes.keySet()
        Set<String> needToCopyKeySet=fieldKeySet.intersect(constraintKeySet)
        needToCopyKeySet.remove("class")

        for(String key : needToCopyKeySet ){
            try {
                //仅拷贝非空值
                if (cp.properties.containsKey(key) && cp.properties.containsKey(key)!=null) {
                    this[key] = cp[key]
                }else if(cp.attributes[key]!=null){
                    this[key] = cp.attributes[key]
                }
            }catch(Exception e){
                println e.message
                println key
            }
        }

        //复制类型名称
        type=cp.propertyType.simpleName
    }
}
