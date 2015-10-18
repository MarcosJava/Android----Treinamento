package br.com.mrcsfelipe.accenture.livrarias.controller;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import br.com.mrcsfelipe.accenture.livrarias.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opcoesBotoes(View view){

        int botao = view.getId();

        if(R.id.bt_cadastro == botao){
            startActivity(new Intent(this, CadastrarLivrosActivity.class));

        } else if ( R.id.bt_listar == botao){
            startActivity(new Intent(this, ListarLivrosActivity.class));

        } else if (R.id.bt_foto == botao){
            capturarFoto();
        }
    }


    Uri uri;
    public void capturarFoto(){

        boolean temCamera = getPackageManager().
                            hasSystemFeature(PackageManager.FEATURE_CAMERA);

        if(temCamera) {
            File diretorio = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES);

            String nome = diretorio.getPath() + "/" + System.currentTimeMillis() + ".jpg";
            uri = Uri.fromFile(new File(nome));

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            startActivityForResult(intent, 1);

        } else {
            mostrarMensagem("Não tem camera no dispositivo");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){

            if(resultCode == RESULT_OK){
                adicionarNaGaleria();
                mostrarMensagem("Capturada com Sucesso");
            } else {
                mostrarMensagem("Ocorreu um erro, tente novamente");
            }
        }

    }

    private void mostrarMensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    private void visualizarImagem(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "imagem/jpeg");
        startActivity(intent);
    }
}
