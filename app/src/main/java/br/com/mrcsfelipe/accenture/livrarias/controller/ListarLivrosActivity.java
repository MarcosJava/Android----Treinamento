package br.com.mrcsfelipe.accenture.livrarias.controller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mrcsfelipe.accenture.livrarias.R;
import br.com.mrcsfelipe.accenture.livrarias.model.Livro;
import br.com.mrcsfelipe.accenture.livrarias.util.Constantes;

/**
 * Created by markFelipe on 18/10/15.
 */
public class ListarLivrosActivity extends ListActivity {

    private Livro livro;
    private SimpleAdapter adapter;
    private static List<Map<String, Object>> livros = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent.hasExtra(Constantes.EXTRA_LIVRO)) {
            livro = (Livro) intent.getSerializableExtra(Constantes.EXTRA_LIVRO);
            popularLista(livro);
        } else {
            livro = new Livro();
        }

        criarLista();

        Log.i("Objeto", livro.toString());
    }

    private void popularLista(Livro livro){

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("nome", livro.getNome());
        item.put("autor", livro.getAutor());
        item.put("editor", livro.getEditora());
        this.livros.add(item);

    }

    private void criarLista(){
        String[] de = {"nome", "autor", "editor"};
        int[] para = {R.id.tv_nome_livro, R.id.tv_autor_livro, R.id.tv_editora_livro};

        adapter = new SimpleAdapter(this, livros, R.layout.activity_listar_livros, de, para);
        setListAdapter(adapter);

        adapter.notifyDataSetChanged();

    }


}
