package com.example.laboratorioprogra4


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.gms.ads.mediation.Adapter

class MainActivity : AppCompatActivity() {

    private lateinit var etn_nombre: EditText
    private  lateinit var  etn_edad: EditText
    private  lateinit var  etn_departamento: EditText
    private  lateinit var tv_Resultado: EditText
    private  lateinit var lv_inventario: EditText

    val Nombre = arrayListOf<String>()
    val Edad = arrayListOf<String>()
    val Departamento = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etn_nombre = findViewById(R.id.etn_nombre)
        etn_edad = findViewById(R.id.etn_edad)
        etn_departamento = findViewById(R.id.etn_departamento)
        tv_Resultado = findViewById(R.id.tv_Resultado)
        lv_inventario = findViewById(R.id.lv_inventario)

    }
    fun  agregarpersona () {
        if (!etn_nombre.text.toString().isEmpty() && !etn_edad.text.toString()
                .isEmpty() && !etn_departamento.text.toString().isEmpty()
        ) {


            Nombre.add(etn_nombre.text.toString())
            Edad.add(etn_edad.text.toString())
            Departamento.add(etn_departamento.text.toString())


            var adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.list, Nombre)
            lv_inventario?.Adapter = adaptador

            lv_inventario?.onItemClickListener=object : AdapterView.OnItemClickListener{
                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    tv_Resultado.setText("Los datos de ${Nombre.get(p2)} la edad es ${Edad.get(p2)} Y recide  en el departamento de ${Departamento.get(p2)}")

                }else{


                    Toast.makeText(this,"Campos vacios",Toast.LENGTH_SHORT).show()
                }
            }


        }
