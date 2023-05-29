package com.example.quiz


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val question = listOf(
        MOdelQuestion(
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
    private var index = 0
    private var right = 0
    private var isoptSelected = false

    private lateinit var tvQusNo: TextView
    private lateinit var btnNex: Button
   private lateinit var  countTime : TextView
   private var backprestime : Long=0

    private lateinit var rlopt1: RelativeLayout
    private lateinit var rlopt2: RelativeLayout
    private lateinit var rlopt3: RelativeLayout
    private lateinit var rlopt4: RelativeLayout

    private lateinit var tvQus: TextView
    private lateinit var tvop1: TextView
    private lateinit var tvop2: TextView
    private lateinit var tvop3: TextView
    private lateinit var tvop4: TextView


   private lateinit var ivopt1: ImageView
   private lateinit var ivopt2: ImageView
   private lateinit var ivopt3: ImageView
   private lateinit var ivopt4: ImageView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AlertDialog.Builder(this)
        val resultView = LayoutInflater.from(this).inflate(R.layout.showresult, null)
        builder.setView(resultView)
        builder.setCancelable(false)
        val tvTotalQuestion = resultView.findViewById<TextView>(R.id.tv_total)
        val tvRightAns = resultView.findViewById<TextView>(R.id.tv_result)
        val btnClose = resultView.findViewById<Button>(R.id.btn_close)
        val alertDialog = builder.create()

//
//
//            //relation lauout id identify
        countTime = findViewById(R.id.time)


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
        tvQusNo = findViewById(R.id.tv_quiz)


        tvQus.text = question[index].mqus
        tvop1.text = question[index].mopt1
        tvop2.text = question[index].mopt2
        tvop3.text = question[index].mopt3
        tvop4.text = question[index].mopt4
        tvQusNo.text = "${index + 1}/ ${question.size}"

//


        rlopt1.setOnClickListener {

            rlopt1.setBackgroundColor(Color.parseColor("#34d408"))
            rlopt2.setBackgroundResource(R.drawable.layout)
            rlopt3.setBackgroundResource(R.drawable.layout)
            rlopt4.setBackgroundResource(R.drawable.layout)



            ivopt1.visibility = View.VISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.INVISIBLE
            isoptSelected = true
            question[index].mselans = "A"
        }

        rlopt2.setOnClickListener {

            rlopt1.setBackgroundResource(R.drawable.layout)
            rlopt2.setBackgroundColor(Color.parseColor("#34d408"))
            rlopt3.setBackgroundResource(R.drawable.layout)
            rlopt4.setBackgroundResource(R.drawable.layout)


            ivopt1.visibility = View.INVISIBLE
            ivopt2.visibility = View.VISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.INVISIBLE
            isoptSelected = true
            question[index].mselans = "B"
        }

        rlopt3.setOnClickListener {


            rlopt1.setBackgroundResource(R.drawable.layout)
            rlopt2.setBackgroundResource(R.drawable.layout)
            rlopt3.setBackgroundColor(Color.parseColor("#34d408"))
            rlopt4.setBackgroundResource(R.drawable.layout)


            ivopt1.visibility = View.INVISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.VISIBLE
            ivopt4.visibility = View.INVISIBLE
            isoptSelected = true
            question[index].mselans = "C"
        }

        rlopt4.setOnClickListener {

            rlopt1.setBackgroundResource(R.drawable.layout)
            rlopt2.setBackgroundResource(R.drawable.layout)
            rlopt3.setBackgroundResource(R.drawable.layout)
            rlopt4.setBackgroundColor(Color.parseColor("#34d408"))


            ivopt1.visibility = View.INVISIBLE
            ivopt2.visibility = View.INVISIBLE
            ivopt3.visibility = View.INVISIBLE
            ivopt4.visibility = View.VISIBLE
            isoptSelected = true
            question[index].mselans = "D"
        }


        fun countTime() {
            val duration: Long = TimeUnit.MINUTES.toMillis(5)

            object : CountDownTimer(duration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                    val sduration = String.format("%02d:%02d", minutes, seconds)
                    println(sduration)
                    countTime.text = sduration
                }

                override fun onFinish() {
                    println("Countdown finished")
                    question.forEach {
//                    Log.d("ans", it.mUserSelectedAns)
                        if (it.mans == it.mselans) right++

                    }

                    tvTotalQuestion.text = "Total Questions: " + question.size.toString()
                    tvRightAns.text = "Right Answer: $right"
                    alertDialog.show()
                }
            }.start()
        }
        countTime()


        btnNex.setOnClickListener { it ->
            if (!isoptSelected) {
                val select = Snackbar.make(it, "Please Select a Option", Snackbar.LENGTH_LONG)
                select.setAction("Okay") {
                    select.dismiss()
                }
                select.show()
            } else if (index < question.size - 1) {
                isoptSelected = true
                index++

                rlopt1.setBackgroundColor(Color.parseColor("#fff000"))
                rlopt2.setBackgroundColor(Color.parseColor("#fff000"))
                rlopt3.setBackgroundColor(Color.parseColor("#fff000"))
                rlopt4.setBackgroundColor(Color.parseColor("#fff000"))

                ivopt1.visibility = View.INVISIBLE
                ivopt2.visibility = View.INVISIBLE
                ivopt3.visibility = View.INVISIBLE
                ivopt4.visibility = View.INVISIBLE
                tvQus.text = question[index].mqus
                tvop1.text = question[index].mopt1
                tvop2.text = question[index].mopt2
                tvop3.text = question[index].mopt3
                tvop4.text = question[index].mopt4

                tvQusNo.text = "${index + 1} / ${question.size}"
                isoptSelected = false
                if (index == question.size - 1) btnNex.text = "Submit"
            } else {
                question.forEach {
//                    Log.d("ans", it.mUserSelectedAns)
                    if (it.mans == it.mselans) right++

                }

                tvTotalQuestion.text = "Total Questions: " + question.size.toString()
                tvRightAns.text = "Right Answer: $right"
                alertDialog.show()
            }

        }
        btnClose.setOnClickListener {
            alertDialog.dismiss()
            finish()
            startActivity(intent)

        }


    }




}



