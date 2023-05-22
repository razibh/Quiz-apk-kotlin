package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val question = listOf<MOdelQuestion>( MOdelQuestion(
        "বঙ্গবন্ধু শেখ মুজিবুর রহমান পাকিস্তানের কারাগার থেকে মুক্তি পান কতো তারিখে?",
        "৯ জানুয়ারী ১৯৭২",
        "১৬ ডিসেম্বর ১৯৭২",
        "৮ জানুয়ারি ১৯৭২ ",
        "১০ জানুয়ারি ১৯৭২",
        "c"
    ),
        MOdelQuestion(
            "গ্রীষ্মকাল কোন মাসে পরে?",
            "বৈশাখ",
            "জ্যৈষ্ট",
            "ফাল্গুন",
            "কার্তিক",
            "C"
            ),
        MOdelQuestion(
            "আন্তর্জাতিক মহিলা দিবস পালন করা হয় কত তারিখে?",
            "8 মার্চ",
            "8 মে",
            "8 জুন",
            "জুলাই",
            "A"
        ),
        MOdelQuestion(
            "নিচের কোনটির কোষে কোনো এনজাইম নেই?",
            "লাইকেন",
            "ভাইরাস",
            "ব্যাকটেরিয়া",
            "এর কোনটিই নয়",
            "D"
        ),
        MOdelQuestion(
            "বাংলাদেশের জাতীয় বৃহত্তম নদী কোনটি?",
            "পদ্মা",
            "জমুনা",
            "তেতুলিয়া",
            "কর্ণফুলি",
            "A"
        ),
        MOdelQuestion(
            " মানবদেহের কোন অঙ্গে লিম্ফোসাইট গঠিত হয়?",
            "  যকৃত",
            "অস্থি মজ্জা",
            " প্লীহা",
            " অগ্ন্যাশয়.",
            "B"
        ),
        MOdelQuestion(
            " ধাতুর রাজা কি?",
            " স্বর্ণ।",
            "রূপা।",
            " লোহা।",
            "অ্যালুমিনিয়াম",
            "A"
        ),
        MOdelQuestion(
            " মানুষের নখ কি দিয়ে তৈরি?",
            " রঙ্গক",
            " ইলাস্টিন",
            "অ্যালবামিন",
            "কেরাটিন.",
            "D"
        ),
        MOdelQuestion(
            "পিঁপড়ার মধ্যে কোন এসিড পাওয়া যায়?",
            " ফরমিক এসিড।",
            "অক্সালিক এসিড।",
            "সালফিউরিক এসিড।",
            "অ্যাসিটিক অ্যাসিড", "A"
        ),
        MOdelQuestion(
            " প্রথম আলোর চুলে আবিষ্কারক কে?",
            " আলবার্ট আইনস্টাইন",
            "থমসন আলভা এডিসন",
            "  নিকোলা টেসলা",
            " ইসাক নিউটন",
            "A"
        )

    )
    var index = 0

    lateinit var tvQusNo : TextView


    lateinit var rlopt1 :RelativeLayout
    lateinit var rlopt2 :RelativeLayout
    lateinit var rlopt3 :RelativeLayout
    lateinit var rlopt4 :RelativeLayout

    lateinit var tvQus : TextView
    lateinit var tvop1 : TextView
    lateinit var tvop2 : TextView
    lateinit var tvop3 : TextView
    lateinit var tvop4 : TextView


    lateinit var ivopt1: ImageView
    lateinit var ivopt2: ImageView
    lateinit var ivopt3: ImageView
    lateinit var ivopt4: ImageView


    lateinit var btnNex : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rlopt1 = findViewById(R.id.rl_1)
        rlopt2 = findViewById(R.id.rl_2)
        rlopt3 = findViewById(R.id.rl_3)
        rlopt4 = findViewById(R.id.rl_4)


        tvQus = findViewById(R.id.tv_quiz_id)
        tvop1 = findViewById(R.id.tv_opt1)
        tvop2 = findViewById(R.id.tv_opt2)
        tvop3 = findViewById(R.id.tv_opt3)
        tvop4 = findViewById(R.id.tv_opt4)


        ivopt1 = findViewById(R.id.imgv_1)
        ivopt2 = findViewById(R.id.imgv_2)
        ivopt3 = findViewById(R.id.imgv_3)
        ivopt4 = findViewById(R.id.imgv_4)


        btnNex = findViewById(R.id.btn_next)
        tvQusNo= findViewById(R.id.tv_quiz)


        tvQus.text = question[index].mqus
        tvop1.text = question[index].mopt1
        tvop2.text = question[index].mopt2
        tvop3.text = question[index].mopt3
        tvop4.text = question[index].mopt4
        tvQusNo.text = "${index +1 }/ ${question.size}"


        rlopt1.setOnClickListener{
            ivopt1.visibility = View.VISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.INVISIBLE
            question[index].mselans = "A"
        }

        rlopt2.setOnClickListener{
            ivopt1.visibility = View.VISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.INVISIBLE
            question[index].mselans = "B"
        }

        rlopt3.setOnClickListener{
            ivopt1.visibility = View.VISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.INVISIBLE
            question[index].mselans = "C"
        }

        rlopt4.setOnClickListener{
            ivopt1.visibility = View.VISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.INVISIBLE
            question[index].mselans = "D"
        }

        btnNex.setOnClickListener{
            if (index <question.size -1){
                index++


                ivopt1.visibility = View.INVISIBLE
                ivopt2.visibility = View.INVISIBLE
                ivopt3.visibility = View.INVISIBLE
                ivopt4.visibility = View.INVISIBLE


                tvQus.text=question[index].mqus
                tvop1.text = question[index].mopt1
                tvop2.text = question[index].mopt2
                tvop3.text = question[index].mopt3
                tvop4.text = question[index].mopt4
                tvQusNo.text = "${index + 1} / ${question.size}"

                if (index == question.size-1) btnNex.text = "Submit"
            }


            else{
                question.forEach {

                }
            }


            }
        }
    }
