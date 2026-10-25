package com.example.prm_arraylist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    EditText txtNome,txtEnd,txtCpf,txtCargo;

    TextView lblContador;
    Button btnCad, btnPesq;

    ListView listinha;

    // Criando o ArrayList
    ArrayList<Usuario> listaUsers = new ArrayList<Usuario>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos da tela
        lblContador = findViewById(R.id.lblContador);
        txtCargo = findViewById(R.id.txtCargo);
        txtNome = findViewById(R.id.txtNome);
        txtEnd = findViewById(R.id.txtEnd);
        txtCpf = findViewById(R.id.txtCpf);
        btnCad = findViewById(R.id.btnCad);
        btnPesq = findViewById(R.id.btnPesquisar);
        listinha = findViewById(R.id.listinha);


        // 3) Evento do btnCad
        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Recuperando os valores
                String end = txtEnd.getText().toString();
                String cpf = txtCpf.getText().toString();
                String nome = txtNome.getText().toString();
                String cargo = txtCargo.getText().toString();

                // ATUALIZAÇÃO 23/10/26
                //1. VALIDAÇÃO: CAMPOS VAZIOS
                //TRIM == remove os espaços em branco do texto, assim se o idiota digitar espaços branco tambem invalida, gatao
                if      (nome.trim().isEmpty() ||
                        end.trim().isEmpty() ||
                        cpf.trim().isEmpty() ||
                        cargo.trim().isEmpty()) {

                    Toast.makeText(MainActivity.this,
                            "Preencha todos os campos!",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                // Instanciando a classe Usuario
                Usuario user = new Usuario(nome, end, cpf, cargo);



                //Adicionando o usuário
                listaUsers.add(user);

                //4. CONTADOR
                //definindo o lblContador como o tamanho da lista de usuarios
                lblContador.setText("Usuários cadastrados: " + listaUsers.size());

                //Adaptando o ArrayList
                ArrayAdapter<Usuario> adaptador =
                        new ArrayAdapter<Usuario>(MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                listaUsers);

                // Inserindo a Lista Adaptada no layout
                listinha.setAdapter(adaptador);

                //Limpar os campos
                txtNome.setText("");
                txtCargo.setText("");
                txtCpf.setText("");
                txtEnd.setText("");
            }
        });

        //Evento da listinha
        listinha.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l)
            {
                //2. EXCLUSÃO: permitir que o usuario exclua o perfil a escolha
                //quando o usuario clicar em algum item da lista manda uma caixa de dialogo para confirmar se ele quer ou nao excluir aquele usuario
                //apaguei o anterior (toast sobre o usuario)  por que tava feio
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Excluir usuário")
                        .setMessage("Deseja realmente excluir este usuário?")
                        .setPositiveButton("Sim", (dialog, which) -> {

                            // Removendo o usuário do ArrayList
                            listaUsers.remove(position);

                            //CONTINUAÇÃO DO CONTADOR, aqui ele atualiza depois do usuario apagar
                            lblContador.setText("Usuários cadastrados: " + listaUsers.size());

                            // Atualizando a lista na tela
                            ArrayAdapter<Usuario> adaptador =
                                    new ArrayAdapter<Usuario>(
                                            MainActivity.this,
                                            android.R.layout.simple_list_item_1,
                                            listaUsers
                                    );

                            listinha.setAdapter(adaptador);

                            // Mensagem de confirmação
                            Toast.makeText(MainActivity.this,
                                    "Usuário excluído!",
                                    Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Não", (dialog, which) -> {
                            // Fecha a mensagem sem excluir
                            dialog.dismiss();
                        })
                        .show();
            }
        });

        // Evento do botão Pesquisar
        //3. PESQUISA: usuario digita nome e se tiver na lista retorna toast com as infmações
        btnPesq.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Recuperando o nome digitado
                String nome = txtNome.getText().toString().trim();

                // Verificando se o campo está vazio
                if (nome.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Digite o nome para pesquisar!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean encontrado = false;
                //"escaneando" a lista de usuarios
                //em minha defesa nao sei como o professor queria, entao fiz a tecnica no cleiton
                for (int i = 0; i < listaUsers.size(); i++)
                {

                    if (listaUsers.get(i).getNome().equalsIgnoreCase(nome))
                    {

                        // Exibindo os dados do usuário encontrado
                        Usuario user = listaUsers.get(i);

                        String mens = "Nome: " + user.getNome() +
                                "\nEnd.: " + user.getEndereco() +
                                "\nCargo: " + user.getCargo() +
                                "\nCPF: " + user.getCpf();

                        Toast.makeText(MainActivity.this,
                                mens,
                                Toast.LENGTH_LONG).show();

                        encontrado = true;
                        break;
                    }
                }

                // Caso não encontre o usuário
                if (!encontrado)
                {
                    Toast.makeText(MainActivity.this,
                            "Usuário não encontrado!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}