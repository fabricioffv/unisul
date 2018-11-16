package com.teste.fabricio.barberapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InsereProdutoServico extends AppCompatActivity {
    Spinner spinner;
    EditText nome;
    EditText valor;
    Button buttonInserir;
    Button botaoCancelar;
    Produto_Servico produto_servico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_produtoservico);

        buttonInserir = findViewById(R.id.buttonInserirProduto);
        botaoCancelar = findViewById(R.id.buttonCancelarProduto);

        buttonInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spinner = findViewById(R.id.spinnerTipo);
                String tipo = spinner.getSelectedItem().toString();
                char _tipo = tipo.charAt(0);

                nome = findViewById(R.id.editTextNome);
                valor = findViewById(R.id.editTextValor);

                if (!nome.getText().toString().equals("") && _tipo != ' ' && !valor.getText().toString().equals("")) {
                    double _valor = Double.parseDouble(valor.getText().toString());
                    produto_servico = new Produto_Servico(0, nome.getText().toString(), _tipo, _valor);
                    Produto_ServicoDAO produto_servicoDAO = new Produto_ServicoDAO();
                    produto_servicoDAO.inserir(produto_servico);
                    Intent intent = new Intent(InsereProdutoServico.this, MainActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    dialog(getResources().getString(R.string.error_fields_required_title), getResources().getString(R.string.error_fields_required_message));
                }
            }
        });

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsereProdutoServico.this, MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void dialog(String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(InsereProdutoServico.this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setNeutralButton("Ok", null);
        builder.show();
    }

}
