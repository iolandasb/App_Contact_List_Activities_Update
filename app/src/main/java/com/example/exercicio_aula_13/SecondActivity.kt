package com.example.exercicio_aula_13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.exercicio_aula_13.MainActivity as Exercicio_aula_13MainActivity

class SecondActivity : AppCompatActivity() {

    lateinit var nome: EditText
    lateinit var celular: EditText
    lateinit var tipoCadastro: RadioGroup
    lateinit var referencia: EditText
    lateinit var salvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nome = findViewById(R.id.edtNome)
        celular = findViewById(R.id.edtCelular)
        tipoCadastro = findViewById(R.id.rdgTipoCadastro)
        referencia = findViewById(R.id.edtReferencia)
        salvar = findViewById(R.id.btnSalvar)

        val cadastro = Cadastro() //Aqui se está chamando a classe "Cadastro"

        salvar.setOnClickListener { //Botão que salva itens na lista.
            //Nos "ifs" abaixo, se está apenas verificando se os campos de "nome", "celular" e "referência" estão vazios. Se estiverem, uma mensagem de erro é criada. Os "ifs" e "elses" estão um dentro do outro para que caso uma das condições não se satisfaça, as demais não possam ocorrer, criando um bloqueio para salvar o contato.
            if (nome.text.isEmpty()) {
                nome.error = "Digite um nome."
            } else if (celular.text.isEmpty()) {
                celular.error = "Digite um número de telefone."
            } else if (referencia.text.isEmpty()) {
                referencia.error = "Digite uma referência."
            } else {
                //No comando abaixo se está chamando a função "adicionarLista" da classe "Cadastro", e colocando dentro dela a frase que se quer montar. Além disso, tudo isso está sendo inserido dentro de uma variável, a qual [e exibida na caixa de texto "resultado" por meio do comando "setText".
                cadastro.adicionarLista(" " + "Nome:" + " " + nome.text.toString() + " " + "\n" + " " + "Telefone:" + " " + celular.text.toString() + " " + "\n" + " " + "Referência/E-mail:" + " " + referencia.text.toString() + "\n")
                val intent = Intent(this, Exercicio_aula_13MainActivity::class.java)
                intent.putExtra("salvar", cadastro.exibirLista())
                startActivity(intent)
            }
                //Os comandos abaixo servem apenas para limpar as caixas de texto após o clique no botão "salvar".
                nome.text = null
                celular.text = null
                referencia.text = null
            }

    }

    fun onRadioButtonClicked(view: View) { //Função com os itens "checáveis".
        if (view is RadioButton) {
            val foiChecado = view.isChecked //Verifica se o item foi "checado".

            when (view.id) { //Quando a view estiver na opção..." -> Aqui já está se inserindo o "id" para indicar que é por meio dele que a opção do layout será chamada.
                R.id.rdPessoal -> //Nome da opção no layout
                    if (foiChecado) { //"Se houve a seleção/checagem da opção..."
                        referencia.setHint("Referência") //"...escreve no "hint" da caixa de texto "Referência"".
                    }
                R.id.rdTrabalho -> { //Nome da opção no layout
                    if (foiChecado) { //"Se houve a seleção/checagem da opção..."
                        referencia.setHint("E-mail") //"...escreve no "hint" da caixa de texto "E-mail"".
                    }
                }
            }
        }
    }

}