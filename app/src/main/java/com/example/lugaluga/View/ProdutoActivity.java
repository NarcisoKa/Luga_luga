package com.example.lugaluga.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lugaluga.Model.Produto;
import com.example.lugaluga.R;

public class ProdutoActivity extends AppCompatActivity {
    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.nomeProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutotv);
        precoProduto= findViewById(R.id.precoProduto);
        descProduto = findViewById(R.id.descricaotv);


                produto = getIntent().getExtras().getParcelable("produto");

                nomeProduto.setText(produto.getNome());
                qtdProduto.setText(produto.getQuantidade());
                precoProduto.setText(String.valueOf(produto.getPreco()));
                descProduto.setText(produto.getDescricao());
    }
}