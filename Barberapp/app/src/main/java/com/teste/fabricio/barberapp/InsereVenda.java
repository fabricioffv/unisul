package com.teste.fabricio.barberapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsereVenda extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    EditText editDataHora;
    Button botaoDataHora;
    Button botaoInserirVenda;
    Button botaoCancelar;
    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    Venda venda;
    Produto_Servico produtoServico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_venda);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        produtoServico = null;
        venda = new Venda(0, "", null);

        botaoDataHora = findViewById(R.id.buttonDataHora);
        editDataHora = findViewById(R.id.editTextDataHora);
        final ListView listViewPS = findViewById(R.id.listViewPSInserirVenda);
        botaoInserirVenda = findViewById(R.id.buttonInserir);
        botaoCancelar = findViewById(R.id.buttonCancelar);

        Produto_ServicoDAO servicoDAO = new Produto_ServicoDAO();
        servicoDAO.listar();

        final ListAdapterProdutosServicos listAdapterServicos = new ListAdapterProdutosServicos(servicoDAO.psList, this);
        listViewPS.setAdapter(listAdapterServicos);

        botaoDataHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(InsereVenda.this, InsereVenda.this, year, month, day);
                datePickerDialog.show();
            }
        });


        listViewPS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                produtoServico = (Produto_Servico) parent.getItemAtPosition(position);
                venda.setProdSer(produtoServico);
                view.setBackgroundColor(Color.CYAN);
            }
        });


        botaoInserirVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (venda.getdataVenda() != "" && venda.getProdSer() != null) {
                    VendaDAO vendaDAO = new VendaDAO();
                    vendaDAO.inserir(venda);
                    Intent intent = new Intent(InsereVenda.this, MainActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    dialog(getResources().getString(R.string.error_fields_required_title), getResources().getString(R.string.error_fields_required_message));
                }
            }
        });

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsereVenda.this, MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(InsereVenda.this, InsereVenda.this, hour, minute, true);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;
        String date = formataDataHora(dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal);
        editDataHora.setText(date);
        venda.setdataVenda(date);
    }

    private String formataDataHora(int dia, int mes, int ano, int hora, int minuto) {
        String res;
        if (dia < 10) {
            res = "0" + Integer.toString(dia);
        } else
            res = Integer.toString(dia);

        res += "/";

        if (mes < 10) {
            res += "0" + Integer.toString(mes);
        } else
            res += Integer.toString(mes);

        res += "/" + Integer.toString(ano) + " ";

        if (hora < 10) {
            res += "0" + Integer.toString(hora);
        } else
            res += Integer.toString(hora);

        res += ":";

        if (minuto < 10) {
            res += "0" + Integer.toString(minuto);
        } else
            res += Integer.toString(minuto);

        return res;
    }

    public void dialog(String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(InsereVenda.this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setNeutralButton("Ok", null);
        builder.show();
    }
}
