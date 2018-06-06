package rest.api.demo

import com.vgrails.demo.Employee
import com.vgrails.demo.Org

class BootStrap {

    def init = { servletContext ->

        Org root = new Org(name: "金色嘉园", parent: null).save()
        Org mini = new Org(name: "小小班", parent: root).save()
        Org mid = new Org(name: "中二班", parent: root).save()

        Employee yy= new Employee(name: "圆圆", owner: mid).save()
        Employee mm= new Employee(name: "满满", owner: mini).save()
    }
    def destroy = {
    }
}
