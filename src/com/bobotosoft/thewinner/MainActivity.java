package com.bobotosoft.thewinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity{
	TextView mainList,winner;
	EditText newItem;
	List<String> actualList;
	Button BaddItem;
	TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener(){
		public boolean onEditorAction(TextView exampleView, int actionId, KeyEvent event) {
			   if (actionId == EditorInfo.IME_NULL  
			      && event.getAction() == KeyEvent.ACTION_DOWN) { 
				   addItem(BaddItem);//match this behavior to your 'Send' (or Confirm) button
			   }
			   return true;
			}
	};
	
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BaddItem = (Button)findViewById(R.id.BaddItem);
		mainList = (TextView)findViewById(R.id.TVmainList);
		newItem = (EditText)findViewById(R.id.ETnewItem);
		winner = (TextView)findViewById(R.id.TVwinner);
		actualList = new ArrayList<String>();
		newItem.setOnEditorActionListener(enterListener);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	public void addItem(View view) {
		String nuevoItem = newItem.getText().toString();
		if(nuevoItem != "")
		{
			actualList.add(newItem.getText().toString());
			String itemsToAdd="";
		    Collections.sort(actualList);
		    Iterator<String> iterator = actualList.iterator();
			while (iterator.hasNext()) {
				itemsToAdd+=iterator.next().toString()+"\n";
			}
			mainList.setText(itemsToAdd);
		    newItem.setText("");
		}
	}
	
	public void resetList(View view) {
		actualList.clear();
		mainList.setText("");
	    newItem.setText("");
	    winner.setText("");
	}
	
	public void getTheWinner(View view) {
		winner.setText(actualList.get(aleatorio(0,actualList.size()-1)));
	    
	 }
	
	public static int aleatorio(int max,int min){
		return min + (int)(Math.random() * ((max- min) + 1));
}
}
