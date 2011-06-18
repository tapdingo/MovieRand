package com.MovieRand;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


public class DBInterface {
	private static final String APIKEY = "7564c792552a9a7c1c0756ac555d6e10";
	private static final String BASICURL = "http://api.themoviedb.org/2.1";
	private static final String LANGUAGE_EN = "en-US";
	private static final String FORMAT_JSON = "json";
	private static final String GET_GENRES = "Genres.getList";
	
	
	public static String getGenresFromDB ()
	{
		String genreRequest = BASICURL + "/" + GET_GENRES + "/" + LANGUAGE_EN + 
			"/" + FORMAT_JSON + "/" + APIKEY;
		
		String response = performRequest(genreRequest);
		return response;
	}
	
	private static String performRequest(String reqString)
	{
		 HttpGet request = new HttpGet(reqString);
	    DefaultHttpClient client = new DefaultHttpClient();
	    ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    HttpResponse response = null;
		try
		{
			response = client.execute(request);
		}
		catch (Exception e)
		{
			return "ERROR!";
		}
		
	    int statusCode = response.getStatusLine().getStatusCode();
	    if (statusCode == 404)
	    {
	    	return "Please check request URL!";
	    }
	    try 
	    {
			String responseText = responseHandler.handleResponse(response);
			return responseText;
		}
	    catch (Exception e)
	    {
	    	return "ERROR!";
	    }
	}
}
