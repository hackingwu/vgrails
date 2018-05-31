package com.vgrails.demo

class StudentCard {
    static m = [
            locale: "学生证",
            search: [type: "ajax", fields:['name']],
            layout: [
                    ['studentNumber','name'],
                    ['photo']
            ]
    ]

    String              studentNumber
    String              name
    String              photo

    static constraints = {
        studentNumber       attributes:[locale: "学生证号"], size: 2..32, unique: true
        name                attributes:[locale: "姓名"], size: 2..32
        photo               attributes:[locale: "照片"], size: 2..255
    }

    String toString(){
        return name
    }
}
