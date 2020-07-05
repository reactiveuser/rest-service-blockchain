package com.example.restservice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {

	private static final String PATH = "/home/roberto/Desktop/projects/MockRestEndpointSpring/complete/src/main/resource/bitcoinNode/00000000000046c4d228fc6cb844dd89cc010f91f97bc7381584e622d6e245cb/";

	@GetMapping("/block")
	public Object block(@RequestParam(value = "block")String block) {
		Object obj = null;
		try (FileReader reader = new FileReader(PATH+block+".json"))
		{
			JSONParser jsonParser = new JSONParser();
			 obj = jsonParser.parse(reader);
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			obj = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@GetMapping("/transaction")
	public Object transaction(@RequestParam(value = "hash")String tx) {
		Object obj = null;
		try (FileReader reader = new FileReader(PATH+tx+".json"))
		{
			JSONParser jsonParser = new JSONParser();
			obj = jsonParser.parse(reader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			obj = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Returning: "+ obj.toString());
		return obj;
	}
	@GetMapping("/address")
	public JSONObject address(@RequestParam(value = "addr")String addr) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JSONObject addressDetail = new JSONObject();
		addressDetail.put("address", addr);
		return addressDetail;
	}
}

