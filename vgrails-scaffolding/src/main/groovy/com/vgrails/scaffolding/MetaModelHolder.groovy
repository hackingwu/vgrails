package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic

/**
 * 负责提供Domain的元模型数据，包括：
 * 1) 属性列表、类型和中文信息
 * 2) 不需要保存的属性列表(transients)
 * 3) 关系(Association)属性列表，如：一对多(OneToMany)、多对多(ManyToMany)、一对一(OneToOne)等
 * 4) 特殊属性列表：聚合(List、Set)、ENUM
 *
 *  @author bale_lin
 *
 *  @version 2018-05-21 新做成
 *
 *  @note 使用静态方法方便调用者
 */

@GrailsCompileStatic
class MetaModelHolder {

    /**
     * 获取领域模型元数据
     * @param domain 首字母小写的模型名称，如：student获取领域模型(Student)的元数据
     * @return 模型元数据
     */
    static MetaModel GetModel(String domain){

    }
}
