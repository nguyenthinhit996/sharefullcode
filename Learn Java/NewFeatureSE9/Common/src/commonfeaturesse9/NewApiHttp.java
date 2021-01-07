package commonfeaturesse9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;


public class NewApiHttp {

	static void newRequestAndReponse() {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest httpRequest;
		HttpResponse<String> httpResponse;
		try {
			httpRequest = HttpRequest.newBuilder().uri(new URI("https://sharecodefull.blogspot.com/2021/01/provided-money-and-currency-api.html")).GET().build();
			
			// use normal 
			httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
			System.out.println( httpResponse.body() );
			
			// use Future determine whether the request has been completed or not.
			CompletableFuture<HttpResponse<String>> sychRepose = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandler.asString());
			
			while(!sychRepose.isDone()) {
			    System.out.println("Calculating...");
			    Thread.sleep(300);
			}
			
			HttpResponse<String> httpResponse2 = sychRepose.get();
			System.out.println( httpResponse2.body() );
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		newRequestAndReponse();
	}
}
