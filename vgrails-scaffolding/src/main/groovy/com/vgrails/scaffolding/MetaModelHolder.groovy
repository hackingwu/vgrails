package com.vgrails.scaffolding

import grails.compiler.GrailsCompileStatic
import grails.core.GrailsClass
import grails.core.GrailsDomainClass
import grails.util.Holders
import com.vgrails.demo.*

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

    static Map<String, MetaModel> metaModelMap=[:]

    boolean IsDomain(String domain){
        return true
    }

    /**
     * 获取领域模型元数据
     * @param model 首字母小写的模型名称，如：student获取领域模型(Student)的元数据
     * @return 模型元数据
     */

    synchronized static MetaModel GetModel(String model){
        if(metaModelMap[model]!=null){
            return metaModelMap[model]
        }
        MetaModel metaModel=new MetaModel()

        println Holders.applicationContext.containsBean("com.vgrails.demo.Organization")
        println Holders.grailsApplication.mappingContext.getPersistentEntity("com.vgrails.demo.Organization")
        println Holders.grailsApplication.mappingContext.getPersistentEntity("Organization")
        println Holders.grailsApplication.mappingContext.getPersistentEntity("organization")

        GrailsClass domainClass = Holders.grailsApplication.getArtefactByLogicalPropertyName("Domain", model)

        //模型不存在
        if(domainClass == null) {
            return null
        }

        println "==========================>"

        metaModelMap[model]=metaModel
        return metaModel
    }
}
