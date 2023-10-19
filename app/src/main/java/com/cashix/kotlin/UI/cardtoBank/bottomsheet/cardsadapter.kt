package com.cashix.kotlin.UI.cardtoBank.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cashix.R
import com.stripe.android.view.CardInputWidget
import com.stripe.android.view.CardMultilineWidget
import org.w3c.dom.Text

class cardsadapter : RecyclerView.Adapter<cardsadapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val radioButton = itemView.findViewById<RadioButton>(R.id.radio_button)
        val bankName = itemView.findViewById<TextView>(R.id.bankName)
        val lastDigit = itemView.findViewById<TextView>(R.id.last_digit)
        val bankLogo = itemView.findViewById<ImageView>(R.id.bank_logo)
        val cardInputWidget = itemView.findViewById<CardMultilineWidget>(R.id.cardInputWidget)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_list_dialog_list_dialog_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 2;
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.cardInputWidget.setCardNumber("4341680200693892")
        holder.cardInputWidget.setExpiryDate(2, 2025)
        holder.cardInputWidget.setCvcCode("354")
    }

}