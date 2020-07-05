package com.example.demo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Response {
	private String id;
	private long origin;
	private String message;
}
