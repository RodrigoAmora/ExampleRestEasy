package com.example.ws.rest;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Consumer {
	public static void main(String[] args) throws Exception {
		//Serviçe: getPessoa
		HttpClient client = new DefaultHttpClient();
		
		HttpGet get = new HttpGet("http://localhost:8080/ExampleRestEasy/example/getPerson");
		get.addHeader("accept", "application/xml");

		HttpResponse response = client.execute(get);
		InputStream content = response.getEntity().getContent();
		
		Scanner scanner = new Scanner(content);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine()+"\n");
		}
		
		content.close();
		
		//Serviçe: getPessoa/{nome}
		get = new HttpGet("http://localhost:8080/ExampleRestEasy/example/getPerson/Peter");
		get.addHeader("accept", "text/plain");

		response = client.execute(get);
		content = response.getEntity().getContent();
		
		scanner = new Scanner(content);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine()+"\n");
		}
		
		content.close();

		//Serviçe: inserirPessoa
		HttpPost post = new HttpPost("http://localhost:8080/ExampleRestEasy/example/insertPerson");
		post.addHeader("content-type", "application/xml");
		post.addHeader("accept", "application/json");
		
		StringEntity xml = new StringEntity(
			"<person>"+
				"<name>Richard</name>"+
				"<email>richard@email.com</email>"+
				"<age>22</age>"+
			"</person>");
		
		post.setEntity(xml);
		response = client.execute(post);
		
		content = response.getEntity().getContent();
		scanner = new Scanner(content);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		
		content.close();
	}
}
