package com.deyvidsalvatore.shopinventory_api.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class WebUtils {
	public static String[] createSortParams(String sort) {
		String[] sortParams = new String[0];
        if (sort != null && !sort.isEmpty()) {
            sortParams = new String[] { sort };
        }
		return sortParams;
	}
	
	public static Pageable createPageable(int page, int size, String[] sort) {
        if (sort.length == 0) {
            return PageRequest.of(page, size);
        }

        Sort sortObj = Sort.unsorted();

        for (String sortParam : sort) {
            String[] parts = sortParam.split(",");
            if (parts.length == 2) {
                String property = parts[0];
                String direction = parts[1].toLowerCase();
                if (direction.equals("asc")) {
                    sortObj = sortObj.and(Sort.by(Sort.Direction.ASC, property));
                } else if (direction.equals("desc")) {
                    sortObj = sortObj.and(Sort.by(Sort.Direction.DESC, property));
                }
            } else if (parts.length == 1) {
                sortObj = sortObj.and(Sort.by(Sort.Direction.ASC, parts[0]));
            }
        }

        return PageRequest.of(page, size, sortObj);
    }

}
