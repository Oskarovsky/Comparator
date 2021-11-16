package com.oskarro.comparator.common;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public <T> T convert(Object srcObj, Class<T> targetClass) throws Exception {
        T response = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        try {
            response = modelMapper.map(srcObj, targetClass);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return response;
    }

    public <S, T> List<T> convertToList(List<S> srcList, Class<T> targetClass) throws Exception {
        List<T> response = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        try {
            srcList.forEach(source -> response.add(modelMapper.map(source, targetClass)));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return response;

    }

}