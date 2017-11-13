package ingeniumbd.jannatmostafiz.khansbalti;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Reservation extends AppCompatActivity {
    String emailSender;
    String password;

    EditText editTextName, editTextMember, editTextMessage, editTextPhone,editTextEmail;
    Button buttonSend;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        emailSender = "khansbalti@gmail.com";
        password = "shakur29";
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextMember = (EditText) findViewById(R.id.editTextMember);
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        TextView textView = (TextView) findViewById(R.id.call);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "01342826505")));
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(editTextName.getText().toString() )){
                    Toast.makeText(Reservation.this,"Please enter name",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(editTextMember.getText().toString() )){
                    Toast.makeText(Reservation.this,"Please enter member",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(editTextMessage.getText().toString() )){
                    Toast.makeText(Reservation.this,"Please enter your message",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(editTextPhone.getText().toString() )){
                    Toast.makeText(Reservation.this,"Please enter phone number",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(editTextEmail.getText().toString() )){
                    Toast.makeText(Reservation.this,"Please enter email",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    openprogresdialog();
                }

            }
        });
    }
    private void openprogresdialog() {
        // TODO Auto-generated method stub
        final ProgressDialog progDailog = ProgressDialog.show(
                Reservation.this, "Sending mail", "Please wait...", true);

        new Thread() {
            public void run() {
                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");

                    try{
                        session = Session.getDefaultInstance(props, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(emailSender, password);
                            }
                        });

                        if(session != null){
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(emailSender));
                            message.setSubject("Reservation from Application");
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("khansbalti@gmail.com"));
                            message.setContent("Name: " + editTextName.getText().toString() + "\n\n"
                                    + "Member number: " + editTextMember.getText().toString()+ "\n\n"
                                    + "Reservation message: "+ editTextMessage.getText().toString()+ "\n\n"
                                    + "Phone number: " + editTextPhone.getText().toString()+ "\n\n"
                                    + "Email: " + editTextEmail.getText().toString(), "text/html; charset=utf-8");
                            ;
                            Transport.send(message);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                }
                progDailog.dismiss();
            }
        }.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.web) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.khansbalti.com")));
            return true;
        }else if (id == R.id.facebook) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Khans/158013767557799")));
            return true;
        }else if (id == R.id.about) {
            Intent i = new Intent(getApplicationContext(), DeveloperInfo.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.exit) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Exit Application?");
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
