package br.com.mrcsfelipe.accenture.livrarias.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.mrcsfelipe.accenture.livrarias.R;
import br.com.mrcsfelipe.accenture.livrarias.model.Livro;
import br.com.mrcsfelipe.accenture.livrarias.util.Constantes;

import static br.com.mrcsfelipe.accenture.livrarias.util.Constantes.EXTRA_LIVRO;

/**
 * Created by markFelipe on 17/10/15.
 */
public class CadastrarLivrosActivity extends AppCompatActivity {

    private EditText nomeLivro;
    private EditText editoraLivro;
    private EditText autorLivro;

    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livros);

        nomeLivro = (EditText) findViewById(R.id.et_nome_livro);
        editoraLivro = (EditText) findViewById(R.id.et_editora_livro);
        autorLivro = (EditText) findViewById(R.id.et_autor_livro);

    }



    public void cadastro(View view) {
        String nome = nomeLivro.getText().toString().trim();
        String editora = editoraLivro.getText().toString().trim();
        String autor = autorLivro.getText().toString().trim();

        livro = new Livro(null, nome, autor, editora);

        Log.i("aviso", "Chegou aqui");

        if(dadosValidos()){

            Intent intent =  new Intent(this, ListarLivrosActivity.class);
            intent.putExtra(EXTRA_LIVRO, livro);
            startActivity(intent);

        }

    }

    public boolean dadosValidos(){

        if(livro.getNome().equalsIgnoreCase("")
                || livro.getNome() == null) {

            Toast.makeText(this, "É necessario o nome", Toast.LENGTH_LONG).show();
            return false;

        } else if (livro.getAutor().equalsIgnoreCase("")
                || livro.getAutor() == null){

            Toast.makeText(this, "É necessario o autor", Toast.LENGTH_LONG).show();
            return false;

        } else if (TextUtils.isEmpty(livro.getEditora())){

            Toast.makeText(this, "É necessario a editora", Toast.LENGTH_LONG).show();
            return false;

        } else {
            return true;
        }
    }
}
