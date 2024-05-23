package com.example.lugaluga.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lugaluga.Model.Produto;
import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.View.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosFragment extends Fragment {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;
    private List<Produto> produtoList = new ArrayList<>();

    public ProdutosFragment() {
        // Required empty public constructor
    }


    public static ProdutosFragment newInstance(String param1, String param2) {
        ProdutosFragment fragment = new ProdutosFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        recyclerView = view.findViewById(R.id.ListaProduto);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getContext(), produtoList.get(position).getStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

        return view;
    }

    public void  CriarListaProdutos(){

        Produto  produto;


        produto = new Produto(
                "Iphone 13",
                200.00,
                "Iphone 13 64gb",
                10,
                "Indisponível");

        produtoList.add(produto);
        produto = new Produto(
                "Fone",
                50.00,
                "Bluetooth",
                120,
                "Disponível");

        produtoList.add(produto);
        produto = new Produto(
                "Iphone X",
                150.00,
                "Iphone X 128gb",
                10,
                "Disponível");

        produtoList.add(produto);
        produto = new Produto(
                "Carregador",
                64.90,
                "Super Turbo 45w",
                100,
                "Disponível");

        produtoList.add(produto);
        produto = new Produto(
                "Ipad",
                400.00,
                "Apple Ipad mini-64GB",
                98,
                "Indsponível");

        produtoList.add(produto);
        produto = new Produto(
                "Apple Watch",
                90.00,
                "Apple Watch SE GPS",
                8,
                "Disponível");

        produtoList.add(produto);
        produto = new Produto(
                "Notebook",
                600.00,
                "Notebook Dell 256GB",
                230,
                "Disponível");

        produtoList.add(produto);
        produto = new Produto(
                "Máquina de Lavar",
                900.00,
                "Máquina de Lavar Electrolux 8,5kg Branca ",
                50,
                "Disponível");

        produtoList.add(produto);
        produto = new Produto(
                "TV",
                700.00,
                "Smart TV 75” UHD 4K LED Samsung 75CU7700",
                100,
                "Indisponível");

        produtoList.add(produto);
        produto = new Produto(
                "Mouse",
                100.00,
                "Mouse Logitech M185 Sem fio 1000DPI 2.4GHz Cinza",
                200,
                "Disponível");


    }

}