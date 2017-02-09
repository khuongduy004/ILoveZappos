package com.intern.ILoveZappos;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.intern.ILoveZappos.databinding.ActivityProductBinding;
import com.squareup.picasso.Picasso;


import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProductActivity extends AppCompatActivity {

    //magic-numbers declaration
    final String NOT_FOUND = "Sorry, we cannot find any item matching your search";
    final String API = "http://api.zappos.com";
    final String KEY = "b743e26728e16b81da139182bb2094357c31d331";
    final String ADDED_CART = "Item added to cart!";

    //default search result being empty with NOT_FOUND as name
    Result result = new Result("","","","","","","","","", NOT_FOUND);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //getting search query
        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //binding
        final ActivityProductBinding productBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_product);

        //starting retrofit

        //creating an adapter for retrofit with base url
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).build();

        //creating a service for adapter using our GET class
        ApiService service = restAdapter.create(ApiService.class);

        //calling for response
        //convert JSON to POJO
        service.getFeed(searchQuery, KEY, new Callback<SearchModel>() {
            @Override
            public void success(SearchModel searchModel, Response response) {
                if (!searchModel.getResults().isEmpty()) {
                    Result temp = searchModel.getResults().get(0);
                    result.setBrandName(temp.getBrandName());
                    result.setThumbnailImageUrl(temp.getThumbnailImageUrl());
                    result.setProductId(temp.getProductId());
                    result.setOriginalPrice(temp.getOriginalPrice());
                    result.setStyleId(temp.getStyleId());
                    result.setColorId(temp.getColorId());
                    result.setPrice(temp.getPrice());
                    result.setPercentOff(temp.getPercentOff());
                    result.setProductUrl(temp.getProductUrl());
                    result.setProductName(temp.getProductName());
                    Picasso.with(getApplicationContext())
                            .load(result.getThumbnailImageUrl())
                            .fit()
                            .into(productBinding.img);
                }
            }

            //error message if applicable
            @Override
            public void failure(RetrofitError error) {
                Log.e("RETROFIT ERROR",error.toString());
            }
        });

        productBinding.setResult(result);

        //FAB implementation - adding to cart animation and toast
        FloatingActionButton fab = productBinding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //only proceed if there is result found
                if (result.getProductName().compareTo(NOT_FOUND) != 0){
                    //toast
                    Toast.makeText(ProductActivity.this, ADDED_CART, Toast.LENGTH_SHORT).show();

                    //animation
                    ImageView imgView = productBinding.img;
                    AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.flip);
                    set.setTarget(imgView);
                    set.start();
                }

            }
        });
    }

}
