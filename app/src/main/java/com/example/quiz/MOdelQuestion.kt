package com.example.quiz

class MOdelQuestion (ques: String, opt1:String,opt2:String,opt3:String,opt4:String, ans:String, selectedAns: String=" ") {

    var mqus: String
    var mopt1: String
    var mopt2: String
    var mopt3: String
    var mopt4: String
    var mans: String
    var mselans: String


    init {
        mqus = ques
        mopt1 = opt1
        mopt2 = opt2
        mopt3 = opt3
        mopt4 = opt4
        mans= ans
        mselans = selectedAns

    }
}