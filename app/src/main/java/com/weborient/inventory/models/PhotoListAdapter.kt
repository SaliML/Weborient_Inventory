package com.weborient.inventory.models

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.weborient.inventory.R
import com.weborient.inventory.models.interfaces.IPhotoClickHandler
import java.io.File

class PhotoListAdapter(private val context: Context, private val handler: IPhotoClickHandler,  private val photoList: ArrayList<String>): RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_card_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val groupItem = photoList[position]

        holder.bind(groupItem)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var photoPath: String? = null

        private var imagePhotoView: ImageView? = null
        private var buttonDelete: ImageView? = null
        private var buttonPreview: ImageView? = null

        init{
            imagePhotoView = itemView.findViewById(R.id.iv_photo)
            buttonDelete = itemView.findViewById(R.id.iv_photo_delete)
            buttonPreview = itemView.findViewById(R.id.iv_photo_preview)

            buttonDelete?.setOnClickListener {
                handler.onClickedDeletePhotoButton(photoPath)
            }

            buttonPreview?.setOnClickListener {
                handler.onClickedPreviewButton(photoPath)
            }
        }

        fun bind(path: String?){
            photoPath = path

            if(photoPath != null){
                imagePhotoView?.let {
                    val circularProgressDrawable = CircularProgressDrawable(context)
                    circularProgressDrawable.strokeWidth = 5f
                    circularProgressDrawable.centerRadius = 30f
                    circularProgressDrawable.start()
                    Glide.with(context).load(File(photoPath!!)).placeholder(circularProgressDrawable).into(it)
                }
            }
        }
    }
}