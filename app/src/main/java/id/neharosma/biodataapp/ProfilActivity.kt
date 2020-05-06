package id.neharosma.biodataapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    companion object{
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()

        btnEdtNama.setOnClickListener { navigasiKeEditProfil() }
        btnAbout.setOnClickListener { goToAbout() }
        btnDial.setOnClickListener { dialPhoneNumber(inputTelp.text.toString()) }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:085231656361")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun ambilData() {
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val umur = bundle?.getString("umur")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        inputNama.text = nama
        inputGander.text = gender
        inputUmur.text = umur
        inputEmail.text = email
        inputTelp.text = telp
        inputAlamat.text = alamat
    }


    private fun goToAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }


    private fun navigasiKeEditProfil(){
        val intent = Intent(this, EditNamaActivity::class.java)

        val namaUser = inputNama.text.toString()
        intent.putExtra("nama",namaUser)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK){
                val result = data?.getStringExtra("nama")
                inputNama.text = result
            }else{
                Toast.makeText(this, "Edit Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
