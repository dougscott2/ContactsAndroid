package drscott.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{
    ArrayAdapter<String> contacts;
    ListView listView;
    EditText nameField;
    EditText phoneField;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        nameField = (EditText) findViewById(R.id.nameField);
        phoneField = (EditText) findViewById(R.id.phoneField);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(contacts);
    }

    @Override
    public void onClick(View v) {
        String nameText = nameField.getText().toString();
        String phoneText = phoneField.getText().toString();
        String text = String.format("%s (%s)", nameText, phoneText);
        contacts.add(text);
        nameField.setText("");
        phoneField.setText("");
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
