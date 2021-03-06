package ingeniumbd.jannatmostafiz.khansbalti;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;


public class TakeWayMenu extends Fragment {

    ListView simpleList;
    String countryList[] = {"Starters", "Khan’s Speciality Exquisite Main Dishes", "Balti Dishes", "Biriani Dishes", "Tandoori Main Dishes", "Traditional Dishes",
            "Side Dishes", "Sundries", "Tandoori Bread", "Set Meals", "Rice Dishes"};
    int flags[] = {R.drawable.starters, R.drawable.specialdishes, R.drawable.foodbucket, R.drawable.birianidishes, R.drawable.tandoori,
            R.drawable.traditional, R.drawable.sidedishe, R.drawable.sundishes, R.drawable.tondooribread, R.drawable.setmeans, R.drawable.ricedeshes};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_take_way_menu,
                container, false);
        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), Starters.class);
                    startActivityForResult(i, 0);
                }
                if (position == 1) {
                  Intent myIntent = new Intent(view.getContext(), SpecialtyExquisite.class);
                   startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                   Intent myIntent = new Intent(view.getContext(), BaltiDishes.class);
                   startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), BirianiDishes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), TandooriDishes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), TraditionalDishes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), SideDishes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), Sundries.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), TandooriBread.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), SetMeals.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 10) {
                    Intent myIntent = new Intent(view.getContext(), RiceDishes.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });
        ImageButton imageButtonHome = (ImageButton) view.findViewById(R.id.btnhome);
        ImageButton imageButtonSpecials = (ImageButton) view.findViewById(R.id.btnspecials);
        ImageButton imageButtonOrder = (ImageButton) view.findViewById(R.id.btnorder);

        imageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), AboutUs.class);
                startActivity(intent);
            }
        });
        imageButtonSpecials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Specials.class);
                startActivity(intent);
            }
        });
        imageButtonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Order.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
