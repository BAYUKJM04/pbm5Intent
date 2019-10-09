package com.example.pert5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ContactAdapter(testData, {phoneItem: PhoneData -> phoneItem(phoneItem)})
    }
    private fun phoneItem(phone: PhoneData){
        val showDetail = Intent(this, PhoneDetailActivity::class.java)
        showDetail.putExtra(Intent.EXTRA_TEXT, phone.phone.toString())
        startActivity(showDetail)
    }
    private fun createPhoneData() : List<PhoneData>{
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(175410173, "Bayu"))
        partList.add(PhoneData(175410174, "Adi"))
        partList.add(PhoneData(175410175, "kjm"))
        return partList
    }
}
