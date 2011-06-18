package com.MovieRand;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieRand extends Activity {
    /** Called when the activity is first created. */
	TextView m_textView = null;

	private List<Genre> m_genres = new ArrayList<Genre>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        m_textView = (TextView) findViewById(R.id.testText);
        
       
        /* \TODO: Get the genres once and cache them! */
        getGenres(); 
    }
    
    private void getGenres()
    {
    	String genres = DBInterface.getGenresFromDB();
    	JSONArray genreArray = null;
    	try
    	{
			genreArray = new JSONArray(genres);
			for (int i = 1; i < genreArray.length(); i++)
	    	{
				JSONObject curGenre = genreArray.getJSONObject(i);

				if (curGenre.has("name") && curGenre.has("id"))
				{
					Genre newGenre = new Genre(id, name);
					m_genres.add(newGenre);
				}	
			}
		}
    	catch (JSONException e)
    	{
			e.printStackTrace();
			m_textView.setText(e.getMessage());
			return;
		}
    }
}