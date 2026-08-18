package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	@GetMapping("/hash")
	public String myHash() throws NoSuchAlgorithmException {

		String data = "Jesse Smith CS 305 Project Two";

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));

		StringBuilder hexString = new StringBuilder();
		for (byte b : hashBytes) {
			hexString.append(String.format("%02x", b));
		}

		return "<p>Name: Jesse Smith</p>"
			+ "<p>Data String: " + data + "</p>"
			+ "<p>Algorithm: SHA-256</p>"
			+ "<p>Checksum Value: " + hexString.toString() + "</p>";
	}
}