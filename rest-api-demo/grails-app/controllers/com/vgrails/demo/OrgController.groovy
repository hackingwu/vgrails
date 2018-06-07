package com.vgrails.demo

import com.vgrails.scaffolding.MetaModelService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrgController {

    OrgService orgService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orgService.list(params), model:[orgCount: orgService.count()]
    }

    def show(Long id) {
        respond orgService.get(id)
    }

    def save(Org org) {
        if (org == null) {
            render status: NOT_FOUND
            return
        }

        try {
            orgService.save(org)
        } catch (ValidationException e) {
            respond org.errors, view:'create'
            return
        }

        respond org, [status: CREATED, view:"show"]
    }

    def update(Org org) {
        if (org == null) {
            render status: NOT_FOUND
            return
        }

        try {
            orgService.save(org)
        } catch (ValidationException e) {
            respond org.errors, view:'edit'
            return
        }

        respond org, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        orgService.delete(id)

        render status: NO_CONTENT
    }

    def meta() {

        respond MetaModelService.GetModel("org")

        return
    }
}
