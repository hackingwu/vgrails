package com.vgrails.scaffolding

import grails.gorm.validation.DefaultConstrainedProperty
import grails.util.Holders

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
 *
 *  @note 尝试使用：grailsApplication.mappingContext.getPersistentEntity("demo.Organization")获取显示字段，稍麻烦
 */

class MetaModelService {

    static transactional = false
    static List<String> excludeProperites=['']
    static Map<String, MetaModel> metaModelMap=[:]

    /**
     * 获取领域模型元数据
     * @param model 首字母小写的模型名称，如：student获取领域模型(Student)的元数据
     * @return 模型元数据
     */

    static synchronized  MetaModel GetModel(String model){
        if(metaModelMap[model]!=null){
            return metaModelMap[model]
        }

        def clazz = Holders.grailsApplication.getArtefactByLogicalPropertyName("Domain", model).clazz
        //所查模型不存在
        if(clazz == null){
            return null
        }

        //------------------------------------------------------------------
        //读取domain元数据
        //------------------------------------------------------------------
        MetaModel metaModel=new MetaModel()
        MetaDomain domain= new MetaDomain()
        List<MetaField> fields=[]

        //TODO: 需要进一步确认是否需要排序，目测已经按照order(定义顺序)排序
        List<DefaultConstrainedProperty> constraints = clazz.getConstrainedProperties().values()*.property

        domain.name=model
        domain.type=clazz.simpleName
        domain.packageName=clazz.package.name

        Map m=clazz.m
        //如果m为空，填写默认值
        if(m==null)
        {
            domain.locale=m.locale
            domain.searchType=m.search?.type
            domain.searchFields=m.search?.fields
            domain.layout=m.layout
        }else{
            domain.locale=model
            domain.searchType="standard" //默认标准搜索
            domain.searchFields=['id']
            domain.layout=null
        }

        //------------------------------------------------------------------
        //查找适合显示的属性(基于约束顺序)
        //------------------------------------------------------------------
        for(int i=0;i<constraints.size();i++){

            MetaField field

            if(constraints[i].propertyType.simpleName == "String")
            {
                field=new MetaFieldString()
            }else if(constraints[i].propertyType.simpleName in ["Long", "long"])
            {
                field=new MetaFieldLong()
            }

            field.CopyFromConstraint(constraints[i])
            fields.add(field)
        }

        metaModel.metaDomain=domain
        metaModel.fields=fields
        metaModelMap[model]=metaModel
        return metaModel
    }
}


