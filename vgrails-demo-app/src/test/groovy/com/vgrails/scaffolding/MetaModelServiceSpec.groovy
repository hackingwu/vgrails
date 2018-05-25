package com.vgrails.scaffolding

import grails.testing.mixin.integration.Integration
import grails.transaction.*
import grails.util.Holders
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
}
