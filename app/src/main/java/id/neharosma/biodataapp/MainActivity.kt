package id.neharosma.biodataapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var namaInput:String = ""
    private var ganderInput:String = ""
    private var umurInput:String = ""
    private var emailInput:String = ""
    private var telpInput:String = ""
    private var alamatInput:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener { goProfilActivity() }
    }


    private fun goProfilActivity() {
        namaInput  = edtNama.text.toString()
        umurInput = edtUmur.text.toString()
        emailInput = edtEmail.text.toString()
        telpInput = edtTelp.text.toString()
        alamatInput = edtTelp.text.toString()
        ganderInput = edtGander.selectedItem.toString()
        when{
            namaInput.isEmpty() -> edtNama.error = "Nama Harus Diisi"
            ganderInput.equals("pilih jenis kelamin",ignoreCase = true)->tampilToast("Jenis kalamin Harus Diisi")
            umurInput.isEmpty() -> edtUmur.error = "Umur Harus Diisi"
            emailInput.isEmpty() -> edtEmail.error = "Email Harus Diisi"
            telpInput.isEmpty() -> edtTelp.error = "No.Telp Harus Diisi"
            alamatInput.isEmpty() -> edtAlamat.error = "Alamat Harus Diisi"

            else->{
                goToProfilActivity()
                tampilToast("Navigasi ke Halaman Profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(massage: String) {
        Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)
        val bundle = Bundle()

        bundle.putString("nama", namaInput)
        bundle.putString("umur", umurInput)
        bundle.putString("gender", ganderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
