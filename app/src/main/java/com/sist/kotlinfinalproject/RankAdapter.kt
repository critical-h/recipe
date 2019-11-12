package com.sist.kotlinfinalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class RankAdapter(context:Context,rankList:List<RankData>):BaseAdapter(){
    // 추상 클래스는 모든 변수가 초기화 => init{}
    private val mContext:Context
    /*private val names = arrayListOf<String>(
        "홍길동","심청이","강감찬","을지문덕","이순신"
    )*/
    private val nList:List<RankData> = rankList
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
        val rowMain=layoutInflater.inflate(R.layout.rank_row,parent,false)

        val nameTextView=rowMain.findViewById<TextView>(R.id.rank_tilte)
        nameTextView.text=nList.get(position).summary.toString()
        val rankView=rowMain.findViewById<TextView>(R.id.rank_chef)
        rankView.text=nList.get(position).made.toString()

        val hitView=rowMain.findViewById<TextView>(R.id.rank_hit)
        hitView.text=nList.get(position).hit.toString()

        val imageView:ImageView=rowMain.findViewById<ImageView>(R.id.rank_imageView)
        Glide.with(rowMain.context).load("${nList.get(position).poster}")
            .into(imageView)
        /*val linkView:TextView=rowMain.findViewById(R.id.textView8)
        linkView.text=nList.get(position).link.toString()*/
        return rowMain
    }
}