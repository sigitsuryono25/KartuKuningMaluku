package com.surelabs.auto.kartukuningmaluku.detaillayanan

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.surelabs.auto.kartukuningmaluku.R
import com.surelabs.auto.kartukuningmaluku.etc.Etc
import com.surelabs.auto.kartukuningmaluku.model.MLayanan
import com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan.DataItem
import com.surelabs.auto.kartukuningmaluku.presenter.ILayananPresenter
import com.surelabs.auto.kartukuningmaluku.view.ILayananView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_detail_layanan.*
import kotlinx.android.synthetic.main.toolbar.*


class DetailLayananActivity : AppCompatActivity(), ILayananView {
    private var iLayananPresenter: ILayananPresenter? = null
    private var item: com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.DataItem? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_layanan)

        setSupportActionBar(toolbar)
        titles.text = getString(R.string.detail_layanan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getSerializableExtra("data") as DataItem

        iLayananPresenter = MLayanan(this)
        iLayananPresenter?.getContentLayanan(data.idKategori)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onLayananLoaded(itemLayanan: List<DataItem?>?) {

    }

    override fun onLayananFailedLoad(message: String?, code: Int?) {

    }

    override fun onDetailLayananLoaded(itemDetail: List<com.surelabs.auto.kartukuningmaluku.network.datamodel.detail.layanan.DataItem?>?) {
        val adapter = AdapterDetailLayanan(itemDetail) { item ->
            this.item = item
            val permission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (permission == PackageManager.PERMISSION_GRANTED) {
                Etc.downloadManager(
                    this,
                    item?.berkas,
                    item?.judul,
                    "Files are download",
                    item?.fileName
                )
            } else {
                requestPermissions(
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    WRITE_EXTERNAL_PERMISSION
                )
            }
        }
        rcDetailLayanan.adapter = adapter
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == WRITE_EXTERNAL_PERMISSION) {
            if (grantResults.size == 1 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toasty.warning(this, "Read Contacts permission granted", Toast.LENGTH_SHORT).show()
            } else {
                val showRationale =
                    shouldShowRequestPermissionRationale(android.Manifest.permission.READ_CONTACTS)
                if (showRationale) {
                    Etc.downloadManager(
                        this,
                        item?.berkas,
                        item?.judul,
                        "Files are download",
                        item?.fileName
                    )
                } else {
                    Toasty.warning(this, "Read Contacts permission denied", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    companion object {
        const val WRITE_EXTERNAL_PERMISSION = 100
    }
}
