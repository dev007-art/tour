package com.andios.tourism.common;

import com.andios.tourism.dto.wareHouseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class wareHouse<T> implements Serializable {
    private static final long serialVersionUID = 5263929449909418122L;
    private int code;

    private String msg;
    private int count;
    private List<T> data;
    public static<T> wareHouse<T> get(T t,T t2){
        wareHouse<T> objectwareHouse = new wareHouse<>();
        List<T> wareHouseDtos = new ArrayList<>();
        wareHouseDtos.add(t);
        wareHouseDtos.add(t2);
        objectwareHouse.setCode(0);
        objectwareHouse.setCount(wareHouseDtos.size());
        objectwareHouse.setData(wareHouseDtos);
        objectwareHouse.setMsg("");
        return objectwareHouse;
    }
}
