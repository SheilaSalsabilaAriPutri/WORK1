package id.sch.smktelkom_mlg.tugas01.xirpl6035.work1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button bOK;
    TextView tvHasil, tvMuncul, tvKeluar, tvLha;
    Spinner spinnerkelas;
    CheckBox Ta, Fi, Ba, Tu;
    RadioButton Rb1, Rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextnama);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textView4);
        spinnerkelas = (Spinner) findViewById(R.id.spkelas);
        Rb1 = (RadioButton) findViewById(R.id.radioButton);
        Rb2 = (RadioButton) findViewById(R.id.radioButton2);
        tvMuncul = (TextView) findViewById(R.id.textView10);
        tvKeluar = (TextView) findViewById(R.id.textView11);
        tvLha = (TextView) findViewById(R.id.textView12);
        Ta = (CheckBox) findViewById(R.id.checkBox);
        Fi = (CheckBox) findViewById(R.id.checkBox2);
        Ba = (CheckBox) findViewById(R.id.checkBox3);
        Tu = (CheckBox) findViewById(R.id.checkBox4);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProccess();
                doClick();

            }

        });
    }

    private void doProccess() {

        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("Nama   = " + nama);
        }

    }

    public boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Masukkan Nama Anda");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Masukkan minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

    private void doClick() {

        tvMuncul.setText("Kelas = " + spinnerkelas.getSelectedItem().toString());

        String hasil = null;
        if (Rb1.isChecked()) {
            hasil = Rb1.getText().toString();
        } else if (Rb2.isChecked()) {
            hasil = Rb2.getText().toString();
        }

        if (hasil == null) {
            tvKeluar.setText("Anda belum memilih lama anda belajar");
        } else {
            tvKeluar.setText("Lama anda akan belajar = " + hasil);
        }

        String lha = "Jurusan yang anda pilih = \n";
        int startlen = lha.length();
        if (Ta.isChecked()) lha += Ta.getText() + "\n";
        if (Fi.isChecked()) lha += Fi.getText() + "\n";
        if (Ba.isChecked()) lha += Ba.getText() + "\n";
        if (Tu.isChecked()) lha += Tu.getText() + "\n";

        if (lha.length() == startlen) lha += "Anda belum memilih jurusan apapun";
        tvLha.setText(lha);
    }
}

