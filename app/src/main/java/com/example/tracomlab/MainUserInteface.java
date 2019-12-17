package com.example.tracomlab;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tracomlab.Fragments.ContactsFragment;
import com.example.tracomlab.Fragments.CustomerFragment;
import com.example.tracomlab.Fragments.DashFragment;
import com.example.tracomlab.Fragments.DeliveryFragment;
import com.example.tracomlab.Fragments.DevicesFragment;
import com.example.tracomlab.Fragments.InventoryFragment;
import com.example.tracomlab.Fragments.ManufacturerFragment;
import com.example.tracomlab.Fragments.OrdersFragment;
import com.example.tracomlab.Fragments.RepairFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;


public class MainUserInteface extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_inteface);

        toolbar=findViewById(R.id.main_user_interface_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DashBoard");


        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_layout);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Container, new DashFragment()).commit();


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

     switch (menuItem.getItemId()){

     case  R.id.repairMenu:

     Objects.requireNonNull(getSupportActionBar()).setTitle("Repairs");
     getSupportFragmentManager().beginTransaction().replace(R.id.Container,new RepairFragment()).commit();

     break;

         case  R.id.dashMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Dashboard");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new DashFragment()).commit();

             break;


         case  R.id.orderMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Orders");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new OrdersFragment()).commit();

             break;

         case R.id.deliveryMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Delivery");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new DeliveryFragment()).commit();

             break;

         case R.id.consultationMenu:
             Objects.requireNonNull(getSupportActionBar()).setTitle("Contacts");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new ContactsFragment()).commit();

             break;

         case R.id.customerOnBoardedDeviceMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Customers");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new CustomerFragment()).commit();

             break;

         case R.id.manufacturerOnBoardedDeviceMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Manufacturer");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new ManufacturerFragment()).commit();

             break;

         case R.id.devicesOnBoardedDeviceMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Devices");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new DevicesFragment()).commit();

             break;

         case R.id.inventoryReportsMenu:

             Objects.requireNonNull(getSupportActionBar()).setTitle("Inventory Reports");
             getSupportFragmentManager().beginTransaction().replace(R.id.Container,new InventoryFragment()).commit();

             break;



        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_out_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.logOutMenu:
                Toast.makeText(getApplicationContext(),"Logging out",Toast.LENGTH_LONG).show();
                System.exit(0);
                break;




        }


        return true;
    }
}
