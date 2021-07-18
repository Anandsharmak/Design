package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
int x;
int y;

public double difference(int x,int y) {
	return Math.sqrt(Math.pow(Math.abs(this.x-x),2)+Math.pow(Math.abs(this.y-y),2));
}
}
