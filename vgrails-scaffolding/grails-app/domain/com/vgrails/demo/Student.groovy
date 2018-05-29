package com.vgrails.demo

class Student {

    static m = [
            locale: "学生",
            search: [type: "ajax", fields:['name']],
            layout: [
                    ['studentNumber','name'],
                    ['remark']
            ]
    ]

    static hasMany = [lessons: Lesson]


    StudentCard         studentCard //one-to-one

    String              studentNumber
    String              name
    String              remark
    static constraints = {
        studentNumber   attributes:[locale: "学生证号"], size: 8..8
        name            attributes:[locale: "姓名"], size: 2..32
        remark          attributes:[locale: "备注"], size: 2..255
    }

    String toString(){
        return name
    }
}
