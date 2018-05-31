package com.vgrails.scaffolding

import grails.testing.mixin.integration.Integration
import grails.transaction.*
import grails.util.Holders
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class MetaModelServiceSpec extends Specification {


    def setup() {
    }

    def cleanup() {
    }

    void "正常: 获取grailsApplication"() {
        expect:"获取grailsApplication"
            Holders.grailsApplication != null
    }

    void "正常: 获取模型"() {
        expect:"获取模型"
            MetaModelService.GetModel("organization").metaDomain.locale=="组织"
            MetaModelService.GetModel("shop").metaDomain.locale=="门店"

            Set<String> transients=MetaModelService.GetModel("organization").transients
            transients.size() == 1
            transients[0]== "label"
    }

    void "正常: 获取模型关系"() {
        expect:"获取模型关系"
            MetaModelService.GetModel("lesson").fields.each{ MetaFieldAssociation f->
                assert f.associationType == MetaFieldAssociation.many_to_many
                assert f.associationDomain in [ 'lesson','student']
            }

            MetaModelService.GetModel("organization") != null
            MetaModelService.GetModel("student") != null
            MetaModelService.GetModel("studentCard") != null
    }

    void "异常: 获取不存在模型"() {
        expect:"获取NULL"
            MetaModelService.GetModel("org")==null
            MetaModelService.GetModel("")==null
            MetaModelService.GetModel(null)==null
    }

    void "并发: 获取模型"() {
        expect:"获取模型"
            int THREAD_NUM=4
            int THREAD_OP_TIMES=10000

            List<Thread> threads=[]

            Date start = new Date()
            for(int i=0;i<THREAD_NUM;i++){
                threads.add(Thread.start{
                    for(int j=0;j<THREAD_OP_TIMES;j++){
                        MetaModelService.GetModel(["organization", "shop"].get(j % 2)) != null
                    }
                })
            }

            threads*.join()
            Date stop= new Date()

            TimeDuration duration=TimeCategory.minus(stop, start)

            println "总数:${THREAD_OP_TIMES*THREAD_NUM} 耗时:${duration.toString()} ${THREAD_OP_TIMES*THREAD_NUM*1000/duration.toMilliseconds()} 操作/秒"

            THREAD_OP_TIMES*THREAD_NUM*1000/duration.toMilliseconds() > 1000
    }
}
