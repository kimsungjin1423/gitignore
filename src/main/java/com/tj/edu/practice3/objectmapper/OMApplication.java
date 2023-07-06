package com.tj.edu.practice3.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tj.edu.practice3.objectmapper.dto.Car;
import com.tj.edu.practice3.objectmapper.dto.User;

import java.util.Arrays;
import java.util.List;

public class OMApplication {
    public static void main(String[] args) throws JsonProcessingException {
        // ObjectMapper사용 용도(그 외 gson 등이 있다)

        // String Text -> Json
        // Json -> String Text
        System.out.println("OMApplication시작");

        User user = new User();
        user.setName("홍길동");
        user.setAge(30);

        Car car1 = new Car();
        car1.setName("Avante");
        car1.setCarNumber("123가1234");
        car1.setType("세단");

        Car car2 = new Car();
        car2.setName("Kona");
        car2.setCarNumber("34하5341");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setUserCars(carList);

        ObjectMapper objectMapper = new ObjectMapper();
        // java object model -> json
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.get("name").asText());
        System.out.println(jsonNode.get("age").asInt());

        JsonNode carsJsonNode = jsonNode.get("userCars");
        ArrayNode arrayNode = (ArrayNode)carsJsonNode;

        // JsonNode -> java object model
        List<Car> listCars = objectMapper.convertValue(arrayNode, new TypeReference<>() {});
        System.out.println(listCars);

        ObjectNode objectNode = (ObjectNode)jsonNode;
        System.out.println(objectNode.toPrettyString());

        // json -> java object model


    }
}

