package com.example.exercicio_aula_13

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

var frase = mutableListOf<String>() //Criação da lista.

@Parcelize
open class Cadastro : Parcelable {

    open fun adicionarLista(X: String): String { //Função que adiciona itens na lista
        var exibir = "" //Variável começa vazia.
        frase.add(X) //Adiciona um item à lista de acordo com o parâmetro da função.
        Collections.sort(frase) //Organiza os nomes da lista por ordem alfabética.
        for(y in frase) { //Faz o loop, indicando que "para cada item na lista...."
            exibir += y + "\n" + "\n" //"...exibir o que já estava mais o que foi aidicionado. O "/n" é apenas para criar um "enter" entre os itens."
        }
        return exibir //Retorna a lista completa.

    }

    open fun consultarLista(N: String) : String { //Função que consulta itens na lista.
        var exibir = "" //Variável começa vazia.
        Collections.sort(frase) //Organiza os nomes da lista por ordem alfabética.
        for(y in frase) { //Faz o loop, indicando que "para cada item na lista...."
            val nome = y.split(" ") //...quebrar os elementos do item pelo separador " ". Isso se relaciona à frase que é montada no "MainActivity", a qual contém os elementos de 3 caixas de texto, e é separada por " ".
            for (i in nome.indices){ //Aqui o loop é relacionado com a POSIÇÃO dos elementos do item, considerando que o "nome.indices" pega o correspondente ao "length" da variável "nome".
                if (nome.get(i) == N) { //Aqui se está dizendo "se o que consta escrito na posição "i" (que pode ser qualquer uma, nome, endereço ou referência) for igual ao parâmetro "N" (ou seja, o que se digitar na pesquisa), então..."
                    exibir += y + "\n" + "\n" //"...exibir as frases que contém a condicional acima, ou seja, a palavra digitada. O "/n" é apenas para criar um "enter" entre os itens."
                }
                /* Abaixo consta apenas uma alternativa caso em vez de procurar por qualquer item, se opte por procurar apenas pelo nome, por exemplo.
                if (nome.get(0)== N) {
                      exibir += y + "\n"
                }
                */
            }
        }
        return exibir //Retorna a lista com apenas os elementos que contém a condicional.
    }


    open fun exibirLista() : String{ //Função que mostra a lista completa.
        var exibir = "" //Variável começa vazia.
        Collections.sort(frase) //Organiza os nomes da lista por ordem alfabética.
        for(y in frase) { //Faz o loop, indicando que "para cada item na lista...."
            exibir += y + "\n" //"...exibir o que já estava mais o que foi aidicionado (no caso, nada é adicionado, então apenas a lista completa). O "/n" é apenas para criar um "enter" entre os itens."
        }
        return exibir //Retorna a lista completa.
    }

}