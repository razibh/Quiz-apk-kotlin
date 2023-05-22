package com.example.quiz

class MOdelQuestion (ques: String, opt1:String,opt2:String,opt3:String,opt4:String, ans:String, selectedAns: String=" ") {

    lateinit var mqus: String
    lateinit var mopt1: String
    lateinit var mopt2: String
    lateinit var mopt3: String
    lateinit var mopt4: String
    lateinit var mans: String
    lateinit var mselans: String


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