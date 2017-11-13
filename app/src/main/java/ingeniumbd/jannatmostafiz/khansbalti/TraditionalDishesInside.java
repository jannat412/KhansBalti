package ingeniumbd.jannatmostafiz.khansbalti;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TraditionalDishesInside extends AppCompatActivity {
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapterTake listAdapter;
    private ExpandableListView simpleExpandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_dishes_inside);
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
        ImageButton imageButtonHome = (ImageButton) findViewById(R.id.btnhome);
        ImageButton imageButtonSpecials = (ImageButton) findViewById(R.id.btnspecials);
        ImageButton imageButtonOrder = (ImageButton) findViewById(R.id.btnorder);

        imageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(intent);
            }
        });
        imageButtonSpecials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Specials.class);
                startActivity(intent);
            }
        });
        imageButtonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Order.class);
                startActivity(intent);
            }
        });
        loadData();

        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);

        listAdapter = new CustomAdapterTake(TraditionalDishesInside.this, deptList);

        simpleExpandableListView.setAdapter(listAdapter);


        expandAll();
        collapseAll();

        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                GroupInfo headerInfo = deptList.get(groupPosition);

                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);

//                Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
//                        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                GroupInfo headerInfo = deptList.get(groupPosition);

//                Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
//                        Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.expandGroup(i);
        }
    }

    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.collapseGroup(i);
        }
    }

    private void loadData(){

        addProduct("1.6.1 Vegetable","Curry .......................£5.25");
        addProduct("1.6.1 Vegetable","Madras ......................£5.30");
        addProduct("1.6.1 Vegetable","Vindaloo.....................£5.35");
        addProduct("1.6.1 Vegetable","Korma........................£5.45");
        addProduct("1.6.1 Vegetable","Bhuna........................£5.45");
        addProduct("1.6.1 Vegetable","Dupiaza .....................£5.45");
        addProduct("1.6.1 Vegetable","Rogon Josh...................£5.45");
        addProduct("1.6.1 Vegetable","Sag .........................£5.45");
        addProduct("1.6.1 Vegetable","Dansak ......................£5.75");
        addProduct("1.6.1 Vegetable","Pathia.......................£5.75");
        addProduct("1.6.1 Vegetable","Kashmir .....................£5.75");
        addProduct("1.6.1 Vegetable","Muglai.......................£5.75");
        addProduct("1.6.1 Vegetable","Garlic.......................£5.75");

        addProduct("1.6.2 Chicken or Lamb","Curry .......................£5.45");
        addProduct("1.6.2 Chicken or Lamb","Madras ......................£5.50");
        addProduct("1.6.2 Chicken or Lamb","Vindaloo.....................£5.55");
        addProduct("1.6.2 Chicken or Lamb","Korma........................£5.75");
        addProduct("1.6.2 Chicken or Lamb","Bhuna........................£5.75");
        addProduct("1.6.2 Chicken or Lamb","Dupiaza .....................£5.75");
        addProduct("1.6.2 Chicken or Lamb","Rogon Josh...................£5.75");
        addProduct("1.6.2 Chicken or Lamb","Sag .........................£5.75");
        addProduct("1.6.2 Chicken or Lamb","Dansak ......................£6.45");
        addProduct("1.6.2 Chicken or Lamb","Pathia.......................£6.45");
        addProduct("1.6.2 Chicken or Lamb","Kashmir .....................£6.45");
        addProduct("1.6.2 Chicken or Lamb","Muglai.......................£6.45");
        addProduct("1.6.2 Chicken or Lamb","Garlic.......................£6.45");

        addProduct("1.6.3 Chicken or Lamb Tikka","Curry .......................£6.75");
        addProduct("1.6.3 Chicken or Lamb Tikka","Madras ......................£6.75");
        addProduct("1.6.3 Chicken or Lamb Tikka","Vindaloo.....................£6.75");
        addProduct("1.6.3 Chicken or Lamb Tikka","Korma........................£6.85");
        addProduct("1.6.3 Chicken or Lamb Tikka","Bhuna........................£6.85");
        addProduct("1.6.3 Chicken or Lamb Tikka","Dupiaza .....................£6.85");
        addProduct("1.6.3 Chicken or Lamb Tikka","Rogon Josh...................£6.85");
        addProduct("1.6.3 Chicken or Lamb Tikka","Sag .........................£6.85");
        addProduct("1.6.3 Chicken or Lamb Tikka","Dansak ......................£6.95");
        addProduct("1.6.3 Chicken or Lamb Tikka","Pathia.......................£6.95");
        addProduct("1.6.3 Chicken or Lamb Tikka","Kashmir .....................£6.95");
        addProduct("1.6.3 Chicken or Lamb Tikka","Muglai.......................£6.95");
        addProduct("1.6.3 Chicken or Lamb Tikka","Garlic.......................£6.95");

        addProduct("1.6.4 Fish or Prawn","Curry .......................£6.75");
        addProduct("1.6.4 Fish or Prawn","Madras ......................£6.75");
        addProduct("1.6.4 Fish or Prawn","Vindaloo.....................£6.75");
        addProduct("1.6.4 Fish or Prawn","Korma........................£6.85");
        addProduct("1.6.4 Fish or Prawn","Bhuna........................£6.85");
        addProduct("1.6.4 Fish or Prawn","Dupiaza .....................£6.85");
        addProduct("1.6.4 Fish or Prawn","Rogon Josh...................£6.85");
        addProduct("1.6.4 Fish or Prawn","Sag .........................£6.85");
        addProduct("1.6.4 Fish or Prawn","Dansak ......................£6.95");
        addProduct("1.6.4 Fish or Prawn","Pathia.......................£6.95");
        addProduct("1.6.4 Fish or Prawn","Kashmir .....................£6.95");
        addProduct("1.6.4 Fish or Prawn","Muglai.......................£6.95");
        addProduct("1.6.4 Fish or Prawn","Garlic.......................£6.95");

        addProduct("1.6.5 King Prawn","Curry .......................£7.95");
        addProduct("1.6.5 King Prawn","Madras ......................£7.95");
        addProduct("1.6.5 King Prawn","Vindaloo.....................£7.95");
        addProduct("1.6.5 King Prawn","Korma........................£8.25");
        addProduct("1.6.5 King Prawn","Bhuna........................£8.25");
        addProduct("1.6.5 King Prawn","Dupiaza .....................£8.25");
        addProduct("1.6.5 King Prawn","Rogon Josh...................£8.25");
        addProduct("1.6.5 King Prawn","Sag .........................£8.25");
        addProduct("1.6.5 King Prawn","Dansak ......................£8.45");
        addProduct("1.6.5 King Prawn","Pathia.......................£8.45");
        addProduct("1.6.5 King Prawn","Kashmir .....................£8.45");
        addProduct("1.6.5 King Prawn","Muglai.......................£8.45");
        addProduct("1.6.5 King Prawn","Garlic.......................£8.45");

        addProduct("1.6.6 King Prawn Tikka","Curry .......................£8.25");
        addProduct("1.6.6 King Prawn Tikka","Madras ......................£8.25");
        addProduct("1.6.6 King Prawn Tikka","Vindaloo.....................£8.25");
        addProduct("1.6.6 King Prawn Tikka","Korma........................£8.45");
        addProduct("1.6.6 King Prawn Tikka","Bhuna........................£8.45");
        addProduct("1.6.6 King Prawn Tikka","Dupiaza .....................£8.45");
        addProduct("1.6.6 King Prawn Tikka","Rogon Josh...................£8.45");
        addProduct("1.6.6 King Prawn Tikka","Sag .........................£8.45");
        addProduct("1.6.6 King Prawn Tikka","Dansak ......................£8.95");
        addProduct("1.6.6 King Prawn Tikka","Pathia.......................£8.95");
        addProduct("1.6.6 King Prawn Tikka","Kashmir .....................£8.95");
        addProduct("1.6.6 King Prawn Tikka","Muglai.......................£8.95");
        addProduct("1.6.6 King Prawn Tikka","Garlic.......................£8.95");

    }
    private int addProduct(String department, String product) {

        int groupPosition = 0;

        GroupInfo headerInfo = subjects.get(department);
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        int listSize = productList.size();
        listSize++;

        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
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
