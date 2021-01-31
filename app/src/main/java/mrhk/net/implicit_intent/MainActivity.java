package mrhk.net.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_link = (EditText)findViewById(R.id.et_link);
    }

    public void openLink(View view) {
        String url = et_link.getText().toString().trim();

        //String url = "https://google.com"; //static Url

        if(url.isEmpty()){
            et_link.setError("Cannot Be Empty");
            et_link.requestFocus();
        }else{
            Toast.makeText(getApplicationContext(),""+url,Toast.LENGTH_SHORT).show();
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //Net set the Data
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }catch (Exception e){
              Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_SHORT).show();e.getMessage();
            }
            //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //startActivity(i);
        }
    }
}