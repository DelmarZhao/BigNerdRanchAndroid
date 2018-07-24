package com.bignerdranch.android.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;


public class CrimeListActivity extends SingleFragmentActivity implements
        CrimeListFragment.Callbacks, CrimeFragment.Callbacks {

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (findViewById(R.id.detail_fragment_container) != null){
            findViewById(R.id.detail_fragment_container).setVisibility(
                    CrimeLab.get(CrimeListActivity.this).getCrimes()
                            .size() == 0 ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId(){
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime){
        if (findViewById(R.id.detail_fragment_container) == null){
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            findViewById(R.id.detail_fragment_container).setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime){
        CrimeListFragment listFragment = (CrimeListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }

    @Override
    public void onCrimeDeleted(){
        CrimeLab crimeLab = CrimeLab.get(this);
        if (crimeLab.getCrimes().size() == 0){
            findViewById(R.id.detail_fragment_container).setVisibility(View.GONE);
        } else {
            Fragment newDetail = CrimeFragment.newInstance(crimeLab.getCrimes().get(0).getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }

    }
}

