package com.vinrak.mybottomsheet

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            showFirstBottomDialog()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            showSecondBottomDialog()
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            showOfficialBottomSheet()
        }

    }

    private fun showOfficialBottomSheet() {
        val mBottomSheetDialog = BottomSheetDialog(this)
        val sheetView: View = layoutInflater.inflate(R.layout.fragment_history_bottom_sheet, null)
        mBottomSheetDialog.setContentView(sheetView)
        mBottomSheetDialog.show()
    }

    private fun showFirstBottomDialog() {
        val bottomDialog = Dialog(this, R.style.BottomDialog)
        val contentView: View = LayoutInflater.from(this).inflate(R.layout.rectangular_dialog, null)
        bottomDialog.setContentView(contentView)

        val editMenuItem = contentView.findViewById<TextView>(R.id.editMenuItem)
        editMenuItem.setOnClickListener {
            Log.d("MainActivity", "editClicked")
        }

        val sendMenuItem = contentView.findViewById<TextView>(R.id.sendMenuItem)
        sendMenuItem.setOnClickListener {
            Log.d("MainActivity", "sendClicked")
        }

        val layoutParams = contentView.layoutParams
        layoutParams.width = resources.displayMetrics.widthPixels
        contentView.layoutParams = layoutParams
        bottomDialog.window!!.setGravity(Gravity.BOTTOM)
        bottomDialog.setCancelable(false)
        bottomDialog.setCanceledOnTouchOutside(false)
        bottomDialog.window!!.setWindowAnimations(R.style.BottomDialog_Animation)
        bottomDialog.show()
    }

    private fun showSecondBottomDialog() {
        val bottomDialog = Dialog(this, R.style.BottomDialog)
        val contentView: View = LayoutInflater.from(this).inflate(R.layout.curved_dialog, null)
        bottomDialog.setContentView(contentView)
        val params = contentView.layoutParams as MarginLayoutParams
        params.width = resources.displayMetrics.widthPixels - dp2px(this, 16f)
        params.bottomMargin = dp2px(this, 8f)
        contentView.layoutParams = params
        bottomDialog.setCanceledOnTouchOutside(true)
        bottomDialog.window!!.setGravity(Gravity.BOTTOM)
        bottomDialog.window!!.setWindowAnimations(R.style.BottomDialog_Animation)
        bottomDialog.show()
    }

    private fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dpVal,
            context.resources.displayMetrics
        ).toInt()
    }

}