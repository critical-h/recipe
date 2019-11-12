package com.sist.kotlinfinalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NewsAdapter(context:Context,newsList:List<NewsData>):BaseAdapter(){
    // 추상 클래스는 모든 변수가 초기화 => init{}
    private val mContext:Context
    /*private val names = arrayListOf<String>(
        "홍길동","심청이","강감찬","을지문덕","이순신"
    )*/
    private val nList:List<NewsData> = newsList
    // 초기화
    init{
        mContext=context
    }
    // 출력할 총 갯수 => loop
    override fun getCount(): Int {
        return nList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    // Any => 모든 데이터형
    override fun getItem(position: Int): Any {
        val selectedItem=nList.get(position)
        return selectedItem
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater=LayoutInflater.from(mContext)
        // ListView를 가지고 온다
        val rowMain=layoutInflater.inflate(R.layout.item_row,parent,false)

        val nameTextView=rowMain.findViewById<TextView>(R.id.textView7)
        nameTextView.text=nList.get(position).title.toString()
        val rankView=rowMain.findViewById<TextView>(R.id.editText)
        rankView.text=nList.get(position).description.toString()

        /*val linkView:TextView=rowMain.findViewById(R.id.textView8)
        linkView.text=nList.get(position).link.toString()*/
        return rowMain
    }
}