package com.example.exercicio_aula_13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var pesquisa: EditText
    lateinit var pesquisar: ImageButton
    lateinit var resultado: TextView
    lateinit var limparPesquisa: Button
    lateinit var cadastrarContato: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesquisa = findViewById(R.id.edtPesquisa)
        pesquisar = findViewById(R.id.btnPesquisar)
        resultado = findViewById(R.id.txtResultado)
        limparPesquisa = findViewById(R.id.btnLimparPesquisa)
        cadastrarContato = findViewById(R.id.btnIrCadastro)

        val cadastro = Cadastro() //Aqui se está chamando a classe "Cadastro"

        resultado.text = intent.getStringExtra("salvar")

        pesquisar.setOnClickListener { //Botão que pesquisa itens na lista.
            val nomeConsultado = pesquisa.text.toString() //Foi inserido numa variável o que é escrito na caixa de texto "pesquisa", a qual deve ser transformada em "string".
            if (nomeConsultado.isNotEmpty()) { //"Se a caixa de texto "pesquisa" NÃO estiver vazia, então..."
                if (cadastro.consultarLista(nomeConsultado).isNotEmpty()) { //"...verificar se quando chamamos a função de "consultarLista" da classe "Cadastro" usando o parâmetro "nomeConsultado" (ou seja, quando digitamos o nome), o RESULTADO da função NÃO voltou vazio (ou seja, foi encontrada um item da lista com a palavra digitada)..."
                    resultado.text = cadastro.consultarLista(nomeConsultado) //"...nesse caso então, mostrar na caixa de texto "resultado" o resultado da função."
                    pesquisa.text = null //Limpar a caixa de texto "pesquisa".
                } else { //"Se o RESULTADO da função for vazio (ou seja, a palavra digitada não encontra correspondente na lista), então..."
                    Toast.makeText( //"...mostrar um aviso de que aquele cadastr não existe."
                        this,
                        "Esse cadastro não consta na agenda!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else pesquisa.error = "Informe um nome para consultar." //"Se a caixa de texto "pesquisa" estiver vazia, então mostrar um erro."
        }

        limparPesquisa.setOnClickListener { //Botão que mostra a lista inteira.
            resultado.text = cadastro.exibirLista() //Aqui se está apenas colocando o resultado da função "exibirLista" da classe "Cadastro" dentro da caixa de texto "resultado".
        }

        cadastrarContato.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

}